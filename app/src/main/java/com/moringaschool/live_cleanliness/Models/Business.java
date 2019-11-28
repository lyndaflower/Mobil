package com.moringaschool.live_cleanliness.Models;

public class Business {

    String bssName;
    String bssEmail;
    String bssLocation;

    public Business(String bssName, String bssEmail, String bssLocation) {
        this.bssName = bssName;
        this.bssEmail = bssEmail;
        this.bssLocation = bssLocation;
    }


    public Business() {
    }

    public String getBssName() {
        return bssName;
    }

    public void setBssName(String bssName) {
        this.bssName = bssName;
    }

    public String getBssEmail() {
        return bssEmail;
    }

    public void setBssEmail(String bssEmail) {
        this.bssEmail = bssEmail;
    }

    public String getBssLocation() {
        return bssLocation;
    }

    public void setBssLocation(String bssLocation) {
        this.bssLocation = bssLocation;
    }
}
