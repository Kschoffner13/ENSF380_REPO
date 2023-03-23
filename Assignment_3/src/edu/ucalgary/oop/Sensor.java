package edu.ucalgary.oop;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sensor implements FormattedOutput, Cloneable{

    // variables
    private String sensor;
    private final static String REGEX = "\\(([a-z]+)\\)";
    private final static Pattern PATTERN = Pattern.compile(REGEX);

    // constructor

    public Sensor(String sensor) throws IllegalArgumentException{
        Pattern PATTERN = Pattern.compile(REGEX);
        Matcher matcher = PATTERN.matcher(sensor);

        if(matcher.find()){
            this.sensor = matcher.group().substring(1, matcher.group().length() - 1);
        }
        else{
            throw new IllegalArgumentException();
        }


    }


    // methods

    public String getSensor(){
        return this.sensor;
    }

    @Override
    public String getFormatted() {
        return "Sensor: " + this.getSensor();
    }

    // Clone
    public Object clone() throws CloneNotSupportedException {
        Sensor cloneSensor = (Sensor)super.clone();
        return cloneSensor;
    }

}
