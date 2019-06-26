package com.loanapp.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanapp.dao.ManagerReportDao;
import com.loanapp.beans.Loan;

@Service
public class TimeChoiceServices {
	
	@Autowired
	ManagerReportDao managerRD;
	
	public List<Loan> getLoans(String curTime) {
		int timeC = Integer.parseInt(curTime);
		LocalDateTime currentDate = LocalDateTime.now();
		LocalDateTime minusDate = currentDate.minusDays(timeC);
		DateTimeFormatter ymd =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String upperBound = currentDate.format(ymd);
		String lowerBound = minusDate.format(ymd);
		
		return managerRD.getLoans(upperBound, lowerBound);
	}
}
