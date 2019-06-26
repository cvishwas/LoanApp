<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<meta charset="ISO-8859-1">
<title>Loan Application</title>
</head>
<body>
	<div class="container p-3">
		<h1>Loan Application Form</h1>
		<form method="POST" action="${contextPath}/loanFormLoanDetails">
			<fieldset class="border p-2">
				<legend class="w-auto">Loan Details:</legend>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="personal">
					<label class="form-check-label" for="gridRadios1"> Personal</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="mortgage">
					<label class="form-check-label" for="gridRadios2"> Mortgage
					</label>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4">
						<label class="control-label" for="">Loan amount</label> <input
							type="text" class="form-control" name="loanAmount"
							placeholder="Amount">
					</div>
					<div class="form-group col-md-4">
						<label class="control-label" for="">Down payment</label> <input
							type="text" class="form-control" name="downPayment"
							placeholder="Amount">
					</div>
					<div class="form-group col-md-4">
						<label class="control-label" for="">Co-signer</label> <input
							type="text" class="form-control" name="cosigner" placeholder=""
							required>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label" for="">Reason for loan</label>
					<textarea class="form-control" aria-label="With textarea"
						name="reasonOfLoan"></textarea>
				</div>
			</fieldset>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<script type="text/javascript"
			src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</div>
</body>
</html>