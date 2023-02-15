package edu.ucalgary.oop;

/*
File Edited by: Koen Schoffner
version 1.1
 */
class Client {
    private String name;
    private String phoneNumber;
    private String address;
    private RewardsProfile rewardsInfo;


    public Client(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rewardsInfo = new RewardsProfile();
    }

    // needs fixing
    public boolean enrollRewards(String newNumber) {

        boolean valid = true;

        try {
            rewardsInfo = new RewardsProfile(newNumber);
        } catch (InvalidRewardsNumException e) {
            valid = false;
        }

        return valid;

    }

    public int getRewardsPoints() {
        return this.rewardsInfo.getPoints();
    }

    public String getRewardsNumber() {
        return this.rewardsInfo.getNumber();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String num) {
        this.phoneNumber = num;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void updatePoints(int addPoints) {
        this.rewardsInfo.setPoints((this.rewardsInfo.getPoints() + addPoints));
    }

}
