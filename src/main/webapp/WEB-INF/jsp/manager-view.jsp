<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Dashboard</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	.material-icons{
	    display: inline-flex;
	    vertical-align: top;
	}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
  <div class="container">
    <a class="navbar-brand" href="/">
    	<i class="material-icons md-48">account_balance</i>
    	<span class="h5">Loan App</span>
    </a>
    
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
	     <li class="nav-item active">
	        <a class="btn btn-light" href="/timeChoice">Time Choice</a>
	    </li>
	    <li class="nav-item active">
	        <a class="btn btn-light" href="/loanReport">Loan Report</a>
	    </li>
        <li class="nav-item active">
        	<a class="nav-link" href="/?sign-out=true">Sign Out</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
	<div class="container">
	
		<div class="mt-5">
			<div class="row form-group font-weight-bold">
				<div class="col-md-3">
					Loan Type
				</div>
				<div class="col-md-2">
					Loan Status
				</div>
				<div class="col-md-3">
					Review Status
				</div>
				<div class="col-md-2">
					Assigned To
				</div>
				<div class="col-md-2">
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
						
						<!-- Drop Down Menu -->
						<div class="col-md-2 bg-light border">
							<c:choose> 
								<c:when test="${not empty edit && edit == item.loanId}">
									<select id="dropDown" name="usersDropDown" class="form-control form-control-sm">
									
								      <c:forEach var="userObj" items="${dropDownList}">
								    	<option value="${userObj.userID}"
								    		<c:if test="${userObj.userID == item.assignedTo.userID}">selected="selected"</c:if>>
								    			${userObj.firstName} ${userObj.lastName}
								    	</option>
								      </c:forEach>
								      
								    </select>
								</c:when>
								<c:otherwise>
									${item.assignedTo.firstName} ${item.assignedTo.lastName}
								</c:otherwise>
							</c:choose>
						</div>
						
						<div class="col-md-2">
							<c:choose> 
								<c:when test="${not empty edit && edit == item.loanId}">
									<a id="save" href="/managerDash?save=true&loanId=${item.loanId}" class="btn btn-success btn-block">Save</a>
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
<script>
	$("#save").click(function(event){
		event.preventDefault();
		
		var userId = $("select#dropDown option:checked" ).val(); 
		var route = $("#save").attr('href')+ '&userId=' + userId;
		
		var redirect = "/managerDash";
		$.get(route, () => window.location.href = redirect);
	});
</script>
</html>