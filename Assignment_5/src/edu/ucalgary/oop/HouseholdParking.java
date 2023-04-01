/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;
import java.time.LocalDate;
import java.util.*;

public class HouseholdParking extends CalgaryProperty {
    // Each residental property is allowed one street parking permit
    private String residentLicence;

    private VisitorParking visitors;

    public HouseholdParking(int taxRollNumber, String zoning,  String streetName, int buildingNumber, String postCode, String buildingAnnex) throws IllegalArgumentException {
        super(taxRollNumber,zoning,streetName,buildingNumber,postCode,buildingAnnex);
        this.visitors = new VisitorParking();
    }

    public HouseholdParking(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode) throws IllegalArgumentException {
        super(taxRollNumber,zoning,streetName,buildingNumber,postCode);
        this.visitors = new VisitorParking();
    }

    // all methods related to visitors
    public VisitorParking getVisitors(){
        return this.visitors;
    }

    public void addVisitorReservation(String licence){
        addVisitorReservation(licence, LocalDate.now());
    }

    public void addVisitorReservation(String licence, LocalDate date){
        visitors.addVisitorReservation(licence, date);
    }

    public ArrayList<String> getLicencesRegisteredForDate(){
        return this.visitors.getLicencesRegisteredForDate(LocalDate.now());
    }

    public ArrayList<String> getLicencesRegisteredForDate(LocalDate date){
        return this.visitors.getLicencesRegisteredForDate(date);
    }

    public boolean licenceIsRegisteredForDate(String licence){
        return this.visitors.licenceIsRegisteredForDate(licence, LocalDate.now());
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate date){
        return this.visitors.licenceIsRegisteredForDate(licence, date);
    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence){
        return this.visitors.getAllDaysLicenceIsRegistered(licence);
    }

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence){
        return this.visitors.getStartDaysLicenceIsRegistered(licence);
    }

    /*
     * Add a licence to the first empty spot in residentLicence, or replace the most recent
     * Ignore if the licence is already stored
     * @param licence - The licence plate to be added
     * @throws IllegalArgumentException if licence plate isn't a valid Alberta licence
     */
    public void addOrReplaceResidentLicence(String licence) throws IllegalArgumentException {
        String check;
        try{
            check = Parking.standardizeAndValidateLicence(licence);
        }
        catch(Exception e){
            throw new IllegalArgumentException();
        }

        this.residentLicence = licence;
    }

    /*
     * Remove all listed licences
     * @return whether the operation succeeded or not
     */
    public boolean removeResidentLicence() {
        this.residentLicence = "";
        return true;
    }

    /*
     * Remove a specific listed licence
     * @param licence - the licence to be removed
     * @return whether the operation succeeded or not
     */
    public boolean removeResidentLicence(String licence) {
        // Standardize the licence name. If it is invalid, it can't exist so return false.
        try {
            licence = Parking.standardizeAndValidateLicence(licence);
        }
        catch (Exception e) {
            return false;
        }

        this.residentLicence = "";
        return true;
    }

    /*
     * Get all the licences stored for the resident
     * @return An array containing the resident's licences
     */
    public String getResidentLicence() {

        if(this.residentLicence == ""){
            return this.residentLicence;
        }
        return Parking.standardizeAndValidateLicence(this.residentLicence);
    }

}
