<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Dashboard</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="mt-5">
			<div class="row form-group">
				<div class="col-md-3 font-weight-bold">
					Loan Type
				</div>
				<div class="col-md-2 font-weight-bold">
					Loan Status
				</div>
				<div class="col-md-3 font-weight-bold">
					Review Status
				</div>
				<div class="col-md-2 font-weight-bold">
					Assigned To
				</div>
				<div class="col-md-2 font-weight-bold">
					Assign/Reassign
				</div>
			</div>
			
			<hr>
			
			<c:if test="${not empty loanData}">

				<c:forEach var="item" items="${loanData}">
					<div class="row form-group">
						<div class="col-md-3 bg-light border">
							${item.loanType}
						</div>
						<div class="col-md-2 bg-light border">
							${item.loanStatus}
						</div>
						<div class="col-md-3 bg-light border">
							${item.reviewStatus}
						</div>
						<div class="col-md-2 bg-light border">
							<c:choose> 
								<c:when test="${not empty edit && edit == item.loanId}">
									<select class="form-control form-control-sm" id="exampleFormControlSelect1">
								      <option>Underwriter 1</option>
								      <option>Reviewer 1</option>
								      <option>Reviewer 3</option>
								      <option>Underwriter 2</option>
								    </select>
								</c:when>
								<c:otherwise>
									${item.assignedTo}
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col-md-2">
							<c:choose> 
								<c:when test="${not empty edit && edit == item.loanId}">
									<a href="/managerDash" class="btn btn-success btn-block">Save</a>
								</c:when>
								<c:otherwise>
									<a href="/managerDash?editId=${item.loanId}" class="btn btn-outline-success btn-block">Edit</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:forEach>

			</c:if>
			
		</div>
	</div>
</body>
</html>