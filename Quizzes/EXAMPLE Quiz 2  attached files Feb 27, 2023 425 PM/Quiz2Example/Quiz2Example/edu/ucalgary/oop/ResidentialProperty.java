/*
Copyright Ann Barcomb and Emily Marasco, 2022
All rights reserved. This code may not be published or shared.
Sharing or posting this code is an academic integrity violation.
*/

/**
 * Class which describes a residential property in Calgary
**/
public class ResidentialProperty extends CalgaryProperty {
    final String description = "apartment";

    /** Constructors **/
    public ResidentialProperty(int taxRollNumber, String streetName, int buildingNumber, String postCode, String description) throws IllegalArgumentException {
        super(taxRollNumber, "RESIDENTIAL", streetName, buildingNumber, postCode);
    }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { }

    public String formatOutput() {
        StringBuilder output = new StringBuilder();
        String address = this.buildingNumber + " " + this.streetName;
        output.append(StandardFormatting.super.formatOutput("Address", address) + "\n");
        output.append(StandardFormatting.super.formatOutput("PostCode", this.postCode) + "\n");
        return output.toString(); 
    }
}
