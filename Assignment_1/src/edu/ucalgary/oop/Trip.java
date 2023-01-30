package edu.ucalgary.oop;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2023
All rights reserved.
*/

public class Trip {
    private String arrival;
    private String departure;
    private String city;
    private String country;


    // Each line is: arrival date, departure date, city, country/territory



    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        return value + " (" + key + ")";
    }

    // Constructor
    public Trip(String[] array) {
        arrival = array[0];
        departure = array[1];
        city = array[2];
        country = array[3];
    }



    // Given a date string, return just the year
    public static int getYear(String date) {
        String stringYear = date.substring(0, 4);
        int intYear = Integer.valueOf(stringYear);

        return intYear;
    }



    // Given a date string, return just the month
    // Since it is an int, a date like "2022-01-12" returns 1
    public static int getMonth(String date) {
        String stringMonth = date.substring(5, 7);
        int intMonth = Integer.valueOf(stringMonth);
        return intMonth;
    }

    // Return a formatted string of key/value pairs, with commas
    // between each. See the output for an example.
    public String formatTrip() {
        return arrival + " (Arrival), " + departure + " (Departure), "
                + city + " (City), " + country + " (Country)";
    }

    // Getter
    public String getArrival() {
        return arrival;
    }

    // Getter
    public String getDeparture() {
        return departure;
    }

    // Getter
    public String getCity() {
        return city;

    }

    // Getter
    public String getCountry() {
        return country;
    }



    // Additional Getters
    // returns the year in the form of a string for the formatByArrival method
    public int getTheYear(){
        return Integer.valueOf(arrival.substring(0, 4));
    }

    // returns the month in the form of a int for the formatByArrival method
    public int getTheMonth(){
        return Integer.valueOf(arrival.substring(5, 7));
    }




    // Setter
    public void setArrival(String date) {
        this.arrival = date;
    }

    // Setter
    public void setDeparture(String date) {
        this.departure = date;
    }

    // Setter
    public void setCity(String city) {
        this.city = city;
    }

    // Setter
    public void setCountry(String country) {
        this.country = country;
    }

}