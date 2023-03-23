package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotDataLine implements Cloneable {

    // variables
    private String dataLine;
    private String robotID;

    private Sensor sensor;

    private Movement movement;
    private LocalDate date;

    private final static String DATE_REGEX = "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
    private final static Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);

    private final static String ROBOT_REGEX = "\\s([0-9]{3}[A-Z]{1})\\s";
    private final static Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);


    // constructor

    public RobotDataLine(String line) throws IllegalArgumentException  {
        this.dataLine = line;

        Matcher idMatcher = ROBOT_PATTERN.matcher(line);
        if(idMatcher.find()){       // this line makes sure of a valid date so use the else for the exception
            this.robotID = idMatcher.group();
        }
        else {
            throw new IllegalArgumentException();
        }


        Matcher dateMatcher = DATE_PATTERN.matcher(line);
        if(dateMatcher.find()){     // this line makes sure of a valid date so use the else for the exception
            String stringDate = dateMatcher.group();
            int day = Integer.parseInt(stringDate.substring(1, 3));
            int month = Integer.parseInt(stringDate.substring(4, 6));
            int year = Integer.parseInt(stringDate.substring(7, 11));



            if(day > 31 || month > 12){
                throw new IllegalArgumentException();

            }
            else{
                this.date = LocalDate.of(year, month, day);
            }

        }
        else{
            throw new IllegalArgumentException();
        }


        this.movement = new Movement(line);
        this.sensor = new Sensor(line);
    }


    // setters and getters

    public String getRobotID(){
        return this.robotID;
    }

    public String getDataLine(){
        return this.dataLine;
    }

    public Sensor getSensor(){
        return this.sensor;
    }

    public Movement getMovement() {
        return this.movement;
    }

    public LocalDate getDate(){
        return this.date;
    }


    // Clone

    public Object clone() throws CloneNotSupportedException{
        RobotDataLine cloneRobotDataLine = (RobotDataLine)super.clone();
        cloneRobotDataLine.sensor = (Sensor)sensor.clone();
        cloneRobotDataLine.movement = (Movement)movement.clone();
        return cloneRobotDataLine;
    }


}
