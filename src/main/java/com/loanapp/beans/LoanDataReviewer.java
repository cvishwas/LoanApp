package com.loanapp.beans;

import java.math.BigInteger;

public class LoanDataReviewer {
	private int loanID;
	private String loanType;
	private String custName;
	private int loanAmount;
	private String reviewStatus;
	
	
	
	public LoanDataReviewer(int id, String type, String name, int amount, String status) {
		this.loanID = id;
		this.loanType = type;
		this.custName = name;
		this.loanAmount = amount;
		this.reviewStatus = status;
	}
	
	public int getLoanID() {
		return loanID;
	}
	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	
}
