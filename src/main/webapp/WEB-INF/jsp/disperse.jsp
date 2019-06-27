<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${loanStatus == 'approved'}">
			<a href="/disperse?dLoanId=${loanId}"><button>Confirm Disperse Loan</button></a>
		</c:when>
		<c:otherwise>
			<p>You cannot disperse this loan!</p>
		</c:otherwise>
	</c:choose>
	
</body>
</html>