<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UnderWriter Dashboard</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="background-color:powderblue;">
<br><center> <font size=6 color="Brown"><b> UNDERWRITER DASHBOARD</b> </font> </center>
<br>
	<div class="container">
		<div class="mt-7">
			<div class="row form-group">
				<div class="col-sm-1 font-weight-bold ">
					Loan Id
				</div>	
				<div class="col-sm-2 font-weight-bold ">
					Loan Type
				</div>			
				<div class="col-sm-2 font-weight-bold">
					Customer Id
				</div>
				
				<div class="col-sm-2 font-weight-bold">
					Loan Status
				</div>
				<div class="col-sm-2 font-weight-bold">
					Review Status
				</div>
			 
				 <div class="col-sm-1 font-weight-bold">					
				</div>
				<div class="col-sm-1 font-weight-bold">					
				</div>
			</div>
			<hr>

			<c:if test="${not empty undList}">

				<c:forEach var="item" items="${undList}">
					<div class="row form-group">
						<div class="col-sm-1 ">
							${item.loan_Id}
						</div>
						
						<div class="col-sm-2 ">
							${item.loan_Type}
						</div>
						
						<div class="col-sm-2 ">
							${item.customer_Id}
						</div>
						
						<div class="col-sm-2 ">
							${item.loan_Status}
						</div>
					  	<div class="col-sm-2">
							${item.loan_Status}
						</div>
						<div class="col-sm-2">
							<button  class="btn btn-outline-success btn-block">Approve</button>
						</div>
						<div class="col-sm-1">
							<button class="btn btn-outline-success btn-block">Deny</button>
						</div>
					</div>
				</c:forEach>

			</c:if>

		</div>
	</div>
</body>
</html> 