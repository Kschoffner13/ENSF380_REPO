package edu.ucalgary.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movement implements FormattedOutput, Cloneable {

    // variables
    private String action;
    private String direction;

    private final static String REGEX = "\"([A-z]+) - ([A-z]{1,2})";
    private final static Pattern PATTERN = Pattern.compile(REGEX);

    // Constructor

    // can do something like action.input to check values for exceptions
    public Movement(String movement) throws IllegalArgumentException{
        Pattern PATTERN = Pattern.compile(REGEX);
        Matcher matcher = PATTERN.matcher(movement);

        boolean checkA = false;
        boolean checkD = false;

        if(matcher.find()){
            String temp = (matcher.group());
            String[] tempArray = temp.split(" - ", 0);

            // need to provide some checks for exceptions here before setting values.
            String tempAction = tempArray[0].substring(1, tempArray[0].length() );
            String tempDirection = tempArray[1];

            for(Actions A : Actions.values()){
                if(tempAction.equals(A.name())){
                    this.action = tempAction;
                    checkA = true;
                }

            }


            for(Directions D : Directions.values()){
                if(tempDirection.equals(D.name())){
                    this.direction = tempDirection;
                    checkD = true;
                }

            }

            if(!checkA || !checkD){
                throw new IllegalArgumentException();
            }
        }

    }

    // methods
    public String getAction(){
        return this.action;
    }

    public String getDirection(){
        return this.direction;
    }

    @Override
    public String getFormatted() {
        String returnString = "Action: " + this.getAction() + ", Direction: ";
        Directions thisDirection = Directions.valueOf(this.getDirection());

        returnString += thisDirection.toString();

        return returnString;
    }


    // Clone

    public Object clone() throws CloneNotSupportedException{
        Movement cloneMovement = (Movement)super.clone();
        return cloneMovement;
    }
}
