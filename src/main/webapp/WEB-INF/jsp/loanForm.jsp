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
<title>Loan Application Form</title>
</head>
<body>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<div class="container p-3">
		<h1>Loan Application Form</h1>
		<form>
			<fieldset class="border p-2">
				<legend>Personal Details:</legend>
				<div class="row">
					<div class="col-2">
						<label class="control-label">First Name:</label> <input
							type="text" class="form-control" id="" placeholder="First Name"
							required>
					</div>
					<div class="col-2">
						<label class="control-label"> Last Name:</label> <input
							type="text" class="form-control" id="" placeholder="Last Name"
							required>
					</div>
					<div class="col-2">
						<label class="control-label"> Date of Birth:</label> <input
							type="text" class="form-control" id=""
							placeholder="Date of birth" required>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label class="control-label" for="">City</label> <input
							type="text" class="form-control" id="" placeholder="City"
							required>
					</div>
					<div class="col">
						<label class="control-label" for="">State</label> <input
							type="text" class="form-control" id="" placeholder="State"
							required>
					</div>
					<div class="col">
						<label class="control-label" for="">Zip Code</label> <input
							type="text" class="form-control" id="" placeholder="Zip" required>
					</div>
					<div class="col">
						<label for="">Country</label> <input type="text"
							class="form-control" id="" placeholder="Country" required>
					</div>
					<div class="row">
						<div class="col">
							<label class="control-label" for="">SSN</label> <input
								type="text" class="form-control" id="" placeholder="" required>
						</div>
						<label class="control-label" for="">Phone Number</label> <input
							type="text" class="form-control" id="" placeholder="" required>
						<label class="control-label" for="">Salary</label> <input
							type="text" class="form-control" id="" placeholder="" required>
						<label class="control-label" for="">Credit Score</label> <input
							type="text" class="form-control" id="" placeholder="" required>
						<label class="control-label" for="">Marital status</label> <input
							type="text" class="form-control" id="" placeholder="" required>

					</div>
				</div>
			</fieldset>
			<fieldset class="border p-2">
				<legend>Loan Details:</legend>
				<label class="control-label" for="">Lone type</label> <input
					type="text" class="form-control" id="" placeholder="" required>
				<label class="control-label" for="">Down payment</label> <input
					type="text" class="form-control" id="" placeholder="" required>
				<label class="control-label" for="">Reason for loan</label> <input
					type="text" class="form-control" id="" placeholder="" required>
				<label class="control-label" for="">Amount</label> <input
					type="text" class="form-control" id="" placeholder="" required>
				<label class="control-label" for="">Co-signer</label> <input
					type="text" class="form-control" id="" placeholder="" required>
			</fieldset>
		</form>
	</div>
</body>
</html>