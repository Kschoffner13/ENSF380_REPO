package edu.ucalgary.oop;

/*
File Edited by: Koen Schoffner
version 1.1
 */


class RewardsProfile {
    private String rewardsNum = "Not Enrolled";
    private int pointsTotal = 10;


    public void setPoints(int addPoints) {
        this.pointsTotal = addPoints;
    }

    public int getPoints() {
        return this.pointsTotal;
    }

    public String getNumber() {
        return this.rewardsNum;
    }

    public RewardsProfile() {
        this.rewardsNum = "Not Enrolled";
        this.pointsTotal = 10;
    }

    public RewardsProfile(String newNumber) throws InvalidRewardsNumException {
        if (newNumber.length() != 7) {
            throw new InvalidRewardsNumException();
        }
        for (int i = 0; i < newNumber.length(); i++) {
            if (newNumber.charAt(i) < '0' || newNumber.charAt(i) > '9') {
                throw new InvalidRewardsNumException();
            }

        }
        this.rewardsNum = newNumber;
    }

}
