package edu.ucalgary.oop;

import java.io.Serializable;

public class TranslationText implements Serializable {

    private String[] days;
    private String[] months;
    private String sentence;
    private static final long serialVersionUID = 19L;


    /* TranslationText
     * Serializable representation of the data file. Has the serialVersionUID of 19L.
     * Member data names should be based on those implied by the getters. Member data are not final.
     */

    /* getSentence()
     * Getter method, returns String
     */

    public String getSentence(){
        return this.sentence;
    }

    /* getMonths()
     * Getter method, returns String[]
     */

    public String[] getMonths(){
        return this.months;
    }

    /* getDays()
     * Getter method, returns String[]
     */

    public String[] getDays(){
        return this.days;
    }

    /* getMonth()
     * Accepts an integer 0-11 corresponding to an index in the months array,
     * and returns the value at that index. (e.g., 0 = January)
     */

    public String getMonth(int m){
        return this.months[m];
    }

    /* getDay()
     * Accepts an integer 0-30 corresponding to an index in the day array,
     * and returns the value at that index. (e.g., 30 = 31st)
     */

    public String getDay(int d){
        return this.days[d];
    }

    /* Constructor
     * Accepts a String array of months, a String array of days, and a String
     * containing a sentence with formatting.
     */

    public TranslationText( String[] months, String[] days, String s){
        this.days = days;
        this.months = months;
        this.sentence = s;
    }

}
