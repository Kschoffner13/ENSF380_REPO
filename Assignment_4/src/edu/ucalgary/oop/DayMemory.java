package edu.ucalgary.oop;

import java.io.*;
import java.util.*;

public class DayMemory {
    /* main()
     * Accept a command-line argument which specifies a translation file.
     * The argument should be in the form of a two-letter language code,
     * followed by a dash and a two-letter region code, e.g., en-US
     * which corresponds with files en-US.txt and en-US.ser
     * If no argument is specified, it throws a custom exception,
     * CommandArgumentNotProvidedException, which extends Exception.
     * Additional arguments are ignored.
     */

    // have the translator create a "translator text" for each file made
    // maybe use a regex for checking if the cmd line argument is valid


    public static void main(String[] args) throws CommandArgumentNotProvidedException, ArgFileNotFoundException, IOException {

        if(args.length == 0){
            throw new CommandArgumentNotProvidedException();
        }
        else{
            Translator test = new Translator(args[0]);
        }

    }
}
