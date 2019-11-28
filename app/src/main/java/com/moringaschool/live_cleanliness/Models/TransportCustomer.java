package com.moringaschool.live_cleanliness.Models;

public class TransportCustomer {
String customerId;
    String destination;
    String email;
    int phone;
    String location;

    public TransportCustomer(String customerId, String destination, String email, int phone, String location) {
        this.customerId = customerId;
        this.destination = destination;
        this.email = email;
        this.phone = phone;
        this.location = location;
    }

    public TransportCustomer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
