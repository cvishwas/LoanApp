package com.loanapp.beans;
//comment
public class LoanDataUnderwriter 
{
	private int loan_Id;
	private int loan_Type;
	private int customer_Id;
	private String loan_Status;
	private String review_Status;
	
	public String getReview_Status() {
		return review_Status;
	}

	public void setReview_Status(String review_Status) {
		this.review_Status = review_Status;
	}

	public LoanDataUnderwriter(int load_Id, int loan_Type,int customer_Id,String loan_Status,String review_Status) 
	{
		this.loan_Id = load_Id;
		this.loan_Type=loan_Type;
		this.customer_Id = customer_Id;
		this.loan_Status = loan_Status;
		this.review_Status = review_Status;
	}

	public int getLoan_Id() {
		return loan_Id;
	}

	public void setLoan_Id(int loan_Id) {
		this.loan_Id = loan_Id;
	}

	public int getLoan_Type() {
		return loan_Type;
	}

	public void setLoan_Type(int loan_Type) {
		this.loan_Type = loan_Type;
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getLoan_Status() {
		return loan_Status;
	}

	public void setLoan_Status(String loan_Status) {
		this.loan_Status = loan_Status;
	}

	@Override
	public String toString() {
		return "LoanDataUnderwriter [loan_Id=" + loan_Id + ", loan_Type=" + loan_Type 
				+ ", loan_Status=" + loan_Status + ", review_Status=" + review_Status + "]";
	}

	

	
}