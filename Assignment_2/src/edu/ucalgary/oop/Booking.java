package edu.ucalgary.oop;

/*
File Edited by: Koen Schoffner
version 1.1
 */

public class Booking {
    private final String STARTDATE;
    private final String ENDDATE;
    private final Pet BOOKEDPET;
    private final Employee CAREGIVER;


    public Booking(Pet pet, Employee assigned, String startDate, String endDate){
        this.BOOKEDPET = pet;
        this.CAREGIVER = assigned;
        this.STARTDATE = startDate;
        this.ENDDATE = endDate;
    }

    public String getStartDate(){
        return this.STARTDATE;
    }

    public String getEndDate(){
        return this.ENDDATE;
    }

    public Pet getBOOKEDPET(){
        return this.BOOKEDPET;
    }

    public Employee getCareGiver(){
        return this.CAREGIVER;
    }

}
