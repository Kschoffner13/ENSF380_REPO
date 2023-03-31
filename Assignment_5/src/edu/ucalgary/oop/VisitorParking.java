package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;

public class VisitorParking {


    // create a hash map for the license and date of registration
    private HashMap<String, LocalDate> reservationList = new HashMap<String, LocalDate>();

    // constructors

    public VisitorParking(){
        int a;
    }
    public VisitorParking(String licence) throws IllegalArgumentException{
        String check_license;
        try{
            check_license = Parking.standardizeAndValidateLicence(licence);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
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
    }


    // methods

    public void addVisitorReservation(String licence){
        String check_license;
        try{
            check_license = Parking.standardizeAndValidateLicence(licence);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void addVisitorReservation(String licence, LocalDate date){
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
    }
}