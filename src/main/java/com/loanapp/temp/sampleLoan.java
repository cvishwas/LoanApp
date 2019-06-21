package com.loanapp.temp;

public class sampleLoan{
	private int loanID;
	private String loanDate;
	private String loanStatus;
	private String loanType;
	private String loanPeriod;
	private String loanAmount;
	public sampleLoan(String loanDate, String loanStatus, String loanType, String loanPeriod, String loanAmount) {
		super();
		this.loanDate = loanDate;
		this.loanStatus = loanStatus;
		this.loanType = loanType;
		this.loanPeriod = loanPeriod;
		this.loanAmount = loanAmount;
	}
	
	public sampleLoan(int loanID, String loanStatus) {
		super();
		this.loanID = loanID;
		this.loanStatus = loanStatus;
	}
	
	public int getLoanID() {
		return loanID;
	}
	public String getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getLoanPeriod() {
		return loanPeriod;
	}
	public void setLoanPeriod(String loanPeriod) {
		this.loanPeriod = loanPeriod;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
}
