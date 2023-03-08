package edu.ucalgary.oop;

import java.time.LocalDate;

public class RobotDataLine {
    private String dataLine;
    private String robotID;

    Sensor sensor;

    Movement movement;
    LocalDate date;




    public String getRobotID(){
        return this.robotID;
    }

    public String getDataLine(){
        return this.dataLine;
    }





}
