package edu.ucalgary.oop;


/*
File Edited by: Koen Schoffner
version 1.1
 */
public class CareProfile {
    private String[] medList;
    private String medInstructions;
    private String feedingInstructions;


    public CareProfile(String[] medList, String meds, String feeding){
        this.medList = medList;
        this.medInstructions = meds;
        this.feedingInstructions = feeding;
    }

    public String summarizeCareInstructions(){
        String mainString = medList[0] + ", ";

        for(int i = 1; i < medList.length; i++){
            if(i == (medList.length)-1){
                mainString += medList[i] + "\n";
            }
            else{
                mainString += medList[i] + ", ";
            }
        }

        mainString += medInstructions + "\n";
        mainString += feedingInstructions;

        return mainString;
    }

}
