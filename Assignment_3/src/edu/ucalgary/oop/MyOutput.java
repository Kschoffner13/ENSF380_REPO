package edu.ucalgary.oop;

import java.time.LocalDate;

public class MyOutput {
    public static void main(String args[]) throws CloneNotSupportedException{

        // Test expected behaviour
        String[] getSampleData = getSampleData();

        RobotDataRecord dataFile = new RobotDataRecord(getSampleData);
        RobotDataLine dataLine1 = dataFile.getLine(0);
        System.out.println("Data record 0: " + dataLine1.getDataLine());
        RobotDataLine dataLine2 = dataFile.getLine(6);
        System.out.println("Data record 6: " + dataLine2.getDataLine());

        String rID = dataFile.getLine(0).getRobotID();
        System.out.println("Robot ID: " + rID);

        LocalDate date = dataLine1.getDate();
        System.out.println("Date: " + date.toString()); //toString is a built-in method of LocalDate

        Movement mov = dataLine1.getMovement();
        System.out.println("Action: " + mov.getAction());
        System.out.println("Direction: "+ mov.getDirection());

        Sensor sen = dataLine1.getSensor();
        System.out.println("Sensor: " + sen.getSensor());

        System.out.println();
        dataLine1 = dataFile.getLine(4);
        System.out.println("Log line 4: " + dataLine1.getDataLine());
        System.out.println(dataLine1.getMovement().getFormatted());  //Direction abbreviation should be expanded to the full spelling
        System.out.println(dataLine1.getSensor().getFormatted());

        //Test cloning: correct deep copies should equate to false
        //Remember to clone each object that is contained within another object
        //Hint: You cannot use the built-in ArrayList clone- think about how to break the link and clone the elements


        //Example of testing invalid input- modify the data as needed to try various invalid scenarios
        // If you want to check IllegalArgumentExceptions being thrown, you can instantiate RobotDataLine, Movement, and Sensor. Bad data lines should be skipped by RobotDataRecord.
        System.out.println("Uncomment below to test exceptions...");
        String[] badData = getBadData();
        RobotDataRecord badDataFile = new RobotDataRecord(badData);
    }


    // Contains example data
    public static String[] getSampleData() {

        String[] dataLog = {
                "Robot 890A - - [02/03/2022] \"START - NE (ultrasonic)\"",
                "Robot 890A - - [02/03/2022] \"FORWARD - NE (infrared)\"",
                "Robot 123B - - [16/03/2022] \"REVERSE - SW (lidar)\"",
                "Robot 793B - - [29/03/2022] \"STOP - S (temperature)\"",
                "Robot 405A - - [10/04/2022] \"RIGHT - E (light)\"",
                "Robot 561C - - [21/04/2022] \"LEFT - SE (ultrasonic)\"",
                "Robot 227D - - [25/04/2022] \"FORWARD - N (lidar)\""};
        return dataLog;
    }

    public static String[] getBadData() {

        String[] dataLog = {
                "Robot 890A - - [90/03/2022] \"START - NE (ultra$onic)\"",  //Contains invalid day and invalid sensor
                "Robot 890AZ - - [02/03/2022] \"BACKWARDS - NS (infrared)\""};  //Contains invalid id and invalid movement
        return dataLog;
    }
}
