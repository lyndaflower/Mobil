package com.moringaschool.live_cleanliness.Models;


public class InstallationCustomer {
    String name;
    String phone;
    String email;
    String location;
    String time;
    String service;

    public InstallationCustomer(String name, String phone, String email, String location, String time, String service) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.time = time;
        this.service = service;

    }

    public InstallationCustomer() {
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        location = location;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;

    }
}
