package com.loanapp.beans;

/**
 * LoanDat bean Class for holding loan data.
 *  
 * @author Gursimran Singh
 *
 */
public class LoanData 
{
	private int loanId;
	private String loanType;
	private String loanStatus;
	private String reviewStatus;
	private User assignedTo;
	
	public LoanData(int loadId, String loanType, String loanStatus, String reviewStatus) 
	{
		this.loanId = loadId;
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
	
	public User getAssignedTo() {
		return assignedTo;
	}
	
	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	@Override
	public String toString() {
		return "LoanData [loanId=" + loanId + ", loanType=" + loanType + ", loanStatus=" + loanStatus
				+ ", reviewStatus=" + reviewStatus + "]";
	}
}
