package edu.ucalgary.oop;

/*
File Edited by: Koen Schoffner
version 1.1
 */

class ReportCard {
    private final Booking REPORT;

    public ReportCard(Booking reportinfo) {
        this.REPORT = reportinfo;
    }

    public String printReport() {
        String petName = this.REPORT.getBOOKEDPET().getName();
        String caregiver = this.REPORT.getCareGiver().getName();

        return caregiver + " enjoyed taking care of " + petName + ". See you next time!";
    }


}
