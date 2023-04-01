package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.*;
import java.util.TreeSet;

public class VisitorParking {

    // HashMap
    private HashMap<String, TreeSet<LocalDate>> reservationList = new HashMap<String, TreeSet<LocalDate>>();
    public Comparator<LocalDate> reverseOrder = Comparator.reverseOrder();



    // getters

    public HashMap<String, TreeSet<LocalDate>> getParkingRecord() {
        return reservationList;
    }


    //Constrcutors

    public VisitorParking(){
    }

    public VisitorParking(String licence){
        String check_license;
        try{
            check_license = Parking.standardizeAndValidateLicence(licence);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        TreeSet<LocalDate> addData = new TreeSet<>(reverseOrder);
        addData.add(LocalDate.now());
        this.reservationList.put(licence, addData);

    }

    public VisitorParking(String licence, LocalDate date){
        String check_license;
        LocalDate checkDate = date;
        try{
            check_license = Parking.standardizeAndValidateLicence(licence);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if(checkDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException();
        }

        TreeSet<LocalDate> addData = new TreeSet<>(reverseOrder);
        addData.add(date);
        this.reservationList.put(licence, addData);
    }



    // addVisitorReservation

    public void addVisitorReservation(String licence){
        addVisitorReservation(licence, LocalDate.now());
    }

    public void addVisitorReservation(String licence, LocalDate date){
        // validate licence and date
        String check_license;
        LocalDate checkDate = date;
        LocalDate[] dateArray = threeDayArray(date);

        try{
            check_license = Parking.standardizeAndValidateLicence(licence);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if(checkDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException();
        }

        //overlap checker

        int dayCount = 0;
        for(int i = 0; i < 3; i++) {
            for (Map.Entry e : this.reservationList.entrySet()) {
                TreeSet<LocalDate> currDates = (TreeSet<LocalDate>) e.getValue();
                for (LocalDate value : currDates) {
                    LocalDate[] currDatesArray = threeDayArray(value);
                    if(Arrays.asList(currDatesArray).contains(dateArray[i])){
                        dayCount++;
                    }
                    if(dayCount >= 2){
                        throw new IllegalArgumentException();
                    }
                }
            }
            dayCount = 0;
        }

        // check if the key already exist. if it does, we will make sure
        // that the date provided doesn't overlap with the current one.
        // if no overlap is detected, then we will add it to the treeSet()
        if(this.reservationList.containsKey(licence)){
            TreeSet<LocalDate> currDates = this.reservationList.get(licence);
            Iterator iterator = currDates.iterator();
            while(iterator.hasNext()){
                LocalDate inDate = (LocalDate) iterator.next();
                LocalDate[] currDateArray = threeDayArray(inDate);
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j <3; j++){
                        if(currDateArray[i].isEqual(dateArray[j])){
                            throw new IllegalArgumentException();
                        }
                    }
                }
            }
            this.reservationList.get(licence).add(date);
        }


        if(!this.reservationList.containsKey(licence)){
            TreeSet<LocalDate> addData = new TreeSet<>(reverseOrder);
            addData.add(date);
            this.reservationList.put(licence, addData);
        }

    }

    // licenceIsRegisteredForDate

    public boolean licenceIsRegisteredForDate(String licence){
        return licenceIsRegisteredForDate(licence, LocalDate.now());
    }

    // checks if a licence is registerd date, in one of its 3 days
    public boolean licenceIsRegisteredForDate(String licence, LocalDate date){
        if(this.reservationList.containsKey(licence)){
            TreeSet<LocalDate> currDates = this.reservationList.get(licence);
            Iterator iterator = currDates.iterator();
            while(iterator.hasNext()){
                LocalDate inDate = (LocalDate) iterator.next();
                LocalDate[] currDateArray = threeDayArray(inDate);
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j <3; j++){
                        if(currDateArray[i].isEqual(date)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    // getLicencesRegisteredForDate
    public ArrayList<String> getLicencesRegisteredForDate(){
        return getLicencesRegisteredForDate(LocalDate.now());
    }

    public ArrayList<String> getLicencesRegisteredForDate(LocalDate date){
        // should only check which licences are registered on which day
        ArrayList<String> returnList = new ArrayList<>();
        // go through each value ok the hasmap
        // them each value in the tree list and check if it is there, and add to the array list
        for(Map.Entry e : this.reservationList.entrySet()){
            TreeSet<LocalDate> currDates = (TreeSet<LocalDate>) e.getValue();
            for (LocalDate value : currDates) {
                LocalDate[] currDatesArray = threeDayArray(value);
                if(Arrays.asList(currDatesArray).contains(date)){
                   returnList.add(Parking.standardizeAndValidateLicence(e.getKey().toString()));
                }
            }

        }
        return returnList;
    }

    // getAllDaysLicenceIsRegistered

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence){
        ArrayList<LocalDate> returnList = new ArrayList<>();

        // find the set in the hasmap that has the key the same as the arg
        // then for every value in the treeSet, append it to the arraylist
        for(Map.Entry e : this.reservationList.entrySet()){
            if(e.getKey() == licence){
                TreeSet<LocalDate> currDates = (TreeSet<LocalDate>) e.getValue();
                for (LocalDate value : currDates) {
                    LocalDate[] currDatesArray = threeDayArray(value);
                    for(int j = 0; j < currDatesArray.length; j++){
                        returnList.add(currDatesArray[j]);
                    }
                }
            }
        }
        for (int i = 0; i < returnList.size(); i++) {
            for (int j = i + 1; j < returnList.size(); j++) {
                LocalDate date1 = returnList.get(i);
                LocalDate date2 = returnList.get(j);
                if (date1.isAfter(date2)) {
                    returnList.set(i, date2);
                    returnList.set(j, date1);
                }
            }
        }
        return returnList;
    }

    // getStartDaysLicenceIsRegistered()

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence){
        ArrayList<LocalDate> returnList = new ArrayList<>();
        for(Map.Entry e : this.reservationList.entrySet()){
            if(e.getKey() == licence){
                TreeSet<LocalDate> currDates = (TreeSet<LocalDate>) e.getValue();
                for (LocalDate value : currDates) {
                    returnList.add(value);

                }
            }
        }
        for (int i = 0; i < returnList.size(); i++) {
            for (int j = i + 1; j < returnList.size(); j++) {
                LocalDate date1 = returnList.get(i);
                LocalDate date2 = returnList.get(j);
                if (date1.isAfter(date2)) {
                    returnList.set(i, date2);
                    returnList.set(j, date1);
                }
            }
        }
        return returnList;
    }


    // helper

    public LocalDate[] threeDayArray(LocalDate date){
        LocalDate[] tmp = (LocalDate[]) new LocalDate[]{date, date.plusDays(1), date.plusDays(2)};
        return tmp;

    }

}

