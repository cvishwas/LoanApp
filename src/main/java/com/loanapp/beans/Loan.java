package com.loanapp.beans;

public class Loan {
    private int loanID;
    private int loanType;
    private int customerID;
    private double amount;
    private String startDate;
    private int loanDuration;       // Months
    private double interestRate;
    private String loanStatus;
    private String emailStatus;
    private double downPayment;

    // Constructor with all parameters specified
    public Loan(int loanID, int loanType, int customerID, double amount, String startDate, int loanDuration,
                double interestRate, String loanStatus, String emailStatus, double downPayment) {
        this.loanID = loanID;
        this.loanType = loanType;
        this.customerID = customerID;
        this.amount = amount;
        this.startDate = startDate;
        this.loanDuration = loanDuration;
        this.interestRate = interestRate;
        this.loanStatus = loanStatus;
        this.emailStatus = emailStatus;
        this.downPayment = downPayment;
    }

    // Default Constructor
    public Loan() {

    }
    
    // Another constructor (Added and used by Jackie, if this causes merge problems I'm sorry.)
    public Loan(int loanID, int loanType, String loanStatus, String startDate) {
    	this.loanID = loanID;
    	this.loanType = loanType;
    	this.loanStatus = loanStatus;
    	this.startDate = startDate;
    }

    // Getters and Setters
    public int getLoanID() { return loanID; }
    public void setLoanID(int loanID) { this.loanID = loanID; }
    public int getLoanType() { return loanType; }
    public void setLoanType(int loanType) { this.loanType = loanType; }
    public int getCustomerID() { return customerID; }
    public void setCustomerID(int customerID) { this.customerID = customerID; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public int getLoanDuration() { return loanDuration; }
    public void setLoanDuration(int loanDuration) { this.loanDuration = loanDuration; }
    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
    public String getLoanStatus() { return loanStatus; }
    public void setLoanStatus(String loanStatus) { this.loanStatus = loanStatus; }
    public String getEmailStatus() { return emailStatus; }
    public void setReviewStatus(String reviewStatus) { this.emailStatus = emailStatus; }
    public double getDownPayment() { return downPayment; }
    public void setDownPayment(double downPayment) { this.downPayment = downPayment; }
}
