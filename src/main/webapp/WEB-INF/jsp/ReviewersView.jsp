<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loan Status Review</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="wrapper">
		<div class="top-container">
			<div class="pos-f-t">
				<div class="sticky collapse" id="navbarToggleExternalContent">
					<div class="bg-dark p-4">
						<h5 class="text-white h4">Welcome to LoanApp</h5>
						<a href="" class="text-white">Home</a> <a href=""
							class="text-white">About</a> <a href="./LoanLogin.jsp"
							class="text-white">Sign-In</a>
					</div>
				</div>
				<nav class="navbar navbar-dark bg-dark">
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarToggleExternalContent"
						aria-controls="navbarToggleExternalContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
				</nav>
			</div>
			<div class="jumbotron jumbotron-fluid" style="text-align: center;">
				<h1>Loan Status Review</h1>
				<div class="dropdown">
					<button class="btn btn-secondary btn-lg dropdown-toggle"
						type="button" id="dropdownMenu2" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">All Loans</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
						<button class="dropdown-item" type="button" id="dropdown-mortgage"
							data-value="Mortgage">Mortgage</button>
						<button class="dropdown-item" type="button" id="dropdown-personal"
							data-value="Personal">Personal</button>
						<button class="dropdown-item" type="button" id="dropdown-auto"
							data-value="Auto">Auto</button>
						<button class="dropdown-item" type="button" id="dropdown-business"
							data-value="Business">Business</button>
					</div>
				</div>
			</div>
		</div>
		<div class="bottom-container" style="text-align: center;">
			<table class="table table-hover" id="loanTable">
				<tr>
					<th scope="col"> Loan ID </th>
					<th scope="col"> Amount </th>
					<th scope="col"> Type </th>
					<th scope="col"> Review </th>
				</tr>
				<c:forEach items="${loans}" var="loan" varStatus="LoopStatus">
					<tr>
						<th scope="row">${loan.loanID} </th>
						<td>${loan.amount}</td>
						<td>${types[loan.loanType-1]} </td>
						<td> <button type = "button" class="btn btn-primary" data-toggle="modal" 
						data-target="#myModal" data-loanid="${loan.loanID}" data-loantype = "${types[loan.loanType-1]}" 
							data-custname="${customerName}" data-amount = "${loan.amount}" data-startdate="${loan.startDate}" 
								data-loanduration = "${loan.loanDuration}" data-interestrate = "${loan.interestRate}" 
									data-downpayment = "${loan.downPayment}">Review</button></td>
					</tr>
				</c:forEach>
			</table>
			
			
		</div>
		<hr />
	</div>

	<div class="wrapper">
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Loan ID</h5>
						<button type="button" class="close" data-dismiss="modal">
							&times;</button>
					</div>
					<div class="modal-body">

						Loan Type: <br> (Input Loan Type here) <br> Customer
						Name: <br> (Input customer Name here) <br> Loan Amount:
						<br> (Input loan amount here) <br> Start Date: <br>
						(Input start date) <br> Loan Duration: <br> (Input loan
						duration) <br> Interest Rate: <br> (Input interest rate)
						<br> Down Payment: <br> (Input down payment))

					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-success" value="completed">Review
							Completed</button>
						<button type="submit" class="btn btn-light" value="need more information">Need more
							information</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<script>
	$(document).ready(function() {
		$('#myModal').on('show.bs.modal', function (event) {
			var button = $(event.relatedTarget)
			var loanid = button.data('loanid')
			var loantype = button.data('loantype')
			var custname = button.data('custname')
			var amount = button.data('amount')
			var startdate = button.data('startdate')
			var loanduration = button.data('loanduration')
			var interestrate = button.data('interestrate')
			var downpayment = button.data('downpayment')
			
			var body = "Loan Type: <br>" + loantype + "<br> Customer Name: <br>" + custname + "<br> Loan Amount: <br>" + 
							custname + "<br> Amount: <br>" + amount + "<br> Start Date: <br>" + startdate + "<br> Loan Duration: <br>" +
							loanduration + "<br> Interest Rate: <br>" + interestrate + "<br> Down Payment: " + downpayment
			var modal = $(this)
			modal.find('.modal-title').text(loanid)
			modal.find('.modal-body').text(body)
			
			modal.find('button.btn-danger').val(loanid)
			modal.find('button.btn-light').val(loanid)
		});
	});
	
</script>

<!-- Script for table dropdown -->
<script>
		$(document).ready(function) {
			$("#dropdownMenu2").change(function() {
				var value = $(this).data("value").toLowerCase();
				$("#loanTable tr").filter(function() {
					$(this).toggle($(this).text().toLowerCase().indexOf(value) > - 1)
				});
			});
		});	
</script>

</body>
</html>