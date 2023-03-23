package edu.ucalgary.oop;

public class CommandArgumentNotProvidedException extends Exception{
    public CommandArgumentNotProvidedException(){
        super("No Commandline Argument Provided.");
    }
}
