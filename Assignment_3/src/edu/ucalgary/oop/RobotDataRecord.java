package edu.ucalgary.oop;

import java.util.ArrayList;

public class RobotDataRecord implements Cloneable{

    private ArrayList<RobotDataLine> log;

    public RobotDataRecord(String[] array) {

        this.log = new ArrayList<RobotDataLine>();
        for(int i = 0; i < array.length; i++) {
            RobotDataLine temp = new RobotDataLine(array[i]);
            try{
                this.log.add(temp);
            }
            catch(IllegalArgumentException e){
            }

        }
    }

    public RobotDataLine getLine( int index){
        return this.log.get(index);
    }

    public ArrayList<RobotDataLine> getDataRecord(){
        return this.log;
    }

    public Object clone() throws CloneNotSupportedException{
        RobotDataRecord cloneRobot = (RobotDataRecord)super.clone();
        cloneRobot.log = new ArrayList<RobotDataLine>();
        for (int i = 0; i < log.size(); i++) {
            cloneRobot.log.add((RobotDataLine) log.get(i).clone());
        }
        return cloneRobot;
    }

}
