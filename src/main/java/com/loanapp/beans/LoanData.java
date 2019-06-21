package com.loanapp.beans;

public class LoanData 
{
	private int loanId;
	private String loanType;
	private String loanStatus;
	private String reviewStatus;
	private String assignedTo;
	
	public LoanData(int loadId, String loanType, String loanStatus, String reviewStatus, String assignedTo) 
	{
		this.loanId = loadId;
		this.loanType = loanType;
		this.loanStatus = loanStatus;
		this.reviewStatus = reviewStatus;
		this.assignedTo = assignedTo;
	}
	
	public int getLoanId() {
		return loanId;
	}
	
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	
	public String getLoanType() {
		return loanType;
	}
	
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	public String getLoanStatus() {
		return loanStatus;
	}
	
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	
	public String getReviewStatus() {
		return reviewStatus;
	}
	
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	
	public String getAssignedTo() {
		return assignedTo;
	}
	
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
}
