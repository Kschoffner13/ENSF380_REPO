package edu.ucalgary.oop;


/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/

import java.util.Arrays;


public class Itinerary {
    private Trip[] trips = new Trip[20];

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        return value + " (" + key + ")";
    }

    // Constructor
    public Itinerary(String[][] myTrips) {
        for(int i = 0; i < myTrips.length; i++)
            trips[i] = new Trip(myTrips[i]);
    }

    // Getter
    public Trip[] getTrips() {
        return trips;
    }





    public String formatByArrival() {

        String mainString = new String();

        // there can be 20 or less values in trips so set the test condtion to:
        // trips[i] != null

        int year2021 = 0;
        int year2022 = 0;
        int year2023 = 0;

        for(int i = 0; trips[i] != null; i++){
            if(trips[i].getTheYear() == 2021){
                year2021 = 1;
            }
            if(trips[i].getTheYear() == 2022){
                year2022 = 1;
            }
            if(trips[i].getTheYear() == 2023){
                year2023 = 1;
            }
        }



        // arrays to hold each trip. each index is the month. index 0 will hold the "year" print statement
        String[] months2021 = new String[13];
        String[] months2022 = new String[13];
        String[] months2023 = new String[13];

        // if the year exist in the array of strips, set the first value to the year print statement
        // the first index will be used later to check certain values
        // the for loops will populate each array with the month header.
        // we will test substrings of after the headers to see if we will add it too the main string
        if(year2021 == 1){
            months2021[0] = "2021 (Year)\n";
            for(int m = 1; m < 13; m++){
                months2021[m] = "--" + m + " (Month)\n";
            }
        }
        if(year2022 == 1){
            months2022[0] = "2022 (Year)\n";
            for(int m = 1; m < 13; m++){
                months2022[m] = "--" + m + " (Month)\n";
            }
        }
        if(year2023 == 1){
            months2023[0] = "2023 (Year)\n";
            for(int m = 1; m < 13; m++){
                months2023[m]= "--" + m + " (Month)\n";
            }
        }

        // populates the arrays with concated strings in the correct month and year
        for(int i = 0; trips[i] != null; i++){

            if(trips[i].getTheYear() == 2021){
                months2021[trips[i].getTheMonth()] += "----" + trips[i].fmtPlace() + "\n";
            }
            else if(trips[i].getTheYear() == 2022){
                months2022[trips[i].getTheMonth()] += "----" + trips[i].fmtPlace() + "\n";
            }
            else if(trips[i].getTheYear() == 2023){
                months2023[trips[i].getTheMonth()] += "----" + trips[i].fmtPlace() + "\n";
            }
        }

        // add each string in order to the main String that is to be returned
        if(months2021[0] != null){
            mainString += months2021[0];
            for(int x = 1; x < 13; x++){
                if(months2021[x].length() > 13){
                    mainString += months2021[x];
                }
            }
        }

        if(months2022[0] != null){
            mainString += months2022[0];
            for(int x = 1; x < 13; x++){
                if(months2022[x].length() > 13){
                    mainString += months2022[x];
                }
            }
        }

        if(months2023[0] != null){
            mainString += months2023[0];
            for(int x = 1; x < 13; x++){
                if(months2023[x].length() > 13){
                    mainString += months2023[x];
                }
            }
        }

        return mainString;


    } // end of function dec





    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month

    String[][][] byDate() {


        String[][][] totalTravel = new String[3][12][];

        for(int i = 0; i < 12; i++) {               // creates a 3D "null" array

            totalTravel[0][i] = new String[20];
            totalTravel[1][i] = new String[20];
            totalTravel[2][i] = new String[20];
        }



        for(int i = 0; trips[i] != null; i++){          // main "for" loop that puts in the values in
                                                        // the right spot.
            int year = -1;

            if(trips[i].getTheYear() == 2021){
                year = 0;
            }
            else if(trips[i].getTheYear() == 2022){
                year = 1;
            }
            else if(trips[i].getTheYear() == 2023){
                year = 2;
            }

            int month = trips[i].getTheMonth() - 1;

            for(int x = 0; x < 20; x++){
                if(totalTravel[year][month][x] == null){
                    totalTravel[year][month][x] = trips[i].fmtDest();
                    x = 20;     // in here so that the loop stops
                }
            }

        }

        return totalTravel;
    }

}

