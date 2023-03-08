/*
Copyright Ann Barcomb and Emily Marasco, 2022
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

package edu.ucalgary.oop;
/**
 * Class which describes a residential property in Calgary
**/
public class ResidentialProperty extends CalgaryProperty{
    String description = "apartment";
    private StandardFormatting formatter = new StandardFormatting();

    /** Constructors **/
    public ResidentialProperty(int taxRollNumber, String streetName, int buildingNumber, String postCode, String description) throws IllegalArgumentException {
        super(taxRollNumber, "RESIDENTIAL", streetName, buildingNumber, postCode);
    }

    public String getDescription() { return this.description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public String formatOutput() {
        StringBuilder output = new StringBuilder();
        String address = this.buildingNumber + " " + this.streetName;
        output.append(formatter.formatOutput("Address", address) + "\n");
        output.append(formatter.formatOutput("PostCode", this.postCode) + "\n");
        return output.toString(); 
    }
}
