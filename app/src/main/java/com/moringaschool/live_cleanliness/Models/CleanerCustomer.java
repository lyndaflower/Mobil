package com.moringaschool.live_cleanliness.Models;

import java.util.Date;

public class CleanerCustomer {

    String property;
    Date timeToDone;
    String description;
    String location;

    public CleanerCustomer(String property, Date timeToDone, String description, String location) {
        this.property = property;
        this.timeToDone = timeToDone;
        this.description = description;
        this.location = location;
    }

    public CleanerCustomer() {
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Date getTimeToDone() {
        return timeToDone;
    }

    public void setTimeToDone(Date timeToDone) {
        this.timeToDone = timeToDone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
