package com.loanapp.beans;
//comment
public class LoanDataUnderwriter 
{
	private int loanId;
	private String custName;
	private String loanType;
	private String loanStatus;
	private String reviewStatus;

	public LoanDataUnderwriter(int loadId,String custName, String loanType, String loanStatus, String reviewStatus) 
	{
		this.loanId = loadId;
		this.custName=custName;
		this.loanType = loanType;
		this.loanStatus = loanStatus;
		this.reviewStatus = reviewStatus;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getcustName() {
		return custName;
	}

	public void setcustName(String custName) {
		this.custName = custName;
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

	
}