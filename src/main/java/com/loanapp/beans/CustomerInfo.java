package com.loanapp.beans;

public class CustomerInfo {
    private int SSN;
    private String address;
    private String city;
    private String state;
    private String country;
    private String dateOfBirth;
    private String phoneNumber;
    private int salary;
    private String relationshipStatus;

    // Constructor with all parameters specified
    public CustomerInfo(int SSN, String address, String city, String state, String country, String dateOfBirth, String phoneNumber, int salary, String relationshipStatus) {
        this.SSN = SSN;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.relationshipStatus = relationshipStatus;
    }

    // Default Constructor
    public CustomerInfo() {

    }

    //Getters and Setters
    public int getSSN() { return SSN; }
    public void setSSN(int SSN) { this.SSN = SSN; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country;   }
    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }
    public String getRelationshipStatus() { return relationshipStatus; }
    public void setRelationshipStatus(String relationshipStatus) { this.relationshipStatus = relationshipStatus; }



}
