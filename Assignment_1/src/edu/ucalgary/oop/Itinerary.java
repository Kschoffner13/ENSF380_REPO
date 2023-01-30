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


        String mainString = new String();              // mainString created (will be returned at the end)
        return mainString;

    } // end of function dec





    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month

    String[][][] byDate() {
        String[][][] cubeWords = new String[3][3][3];
        return cubeWords;
    }

}

