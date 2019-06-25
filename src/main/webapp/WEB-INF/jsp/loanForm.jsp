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
		<form method="POST" action="${contextPath}/loanForm">
			<fieldset class="border p-2">
				<legend class="w-auto">Personal Details:</legend>
				<div class="form-row">
					<div class="form-group col-md-4">
						<label class="control-label">First Name</label> <input type="text"
							class="form-control" name="firstname" placeholder="First Name" required>
					</div>
					<div class="form-group col-md-4">
						<label class="control-label"> Last Name</label> <input type="text"
							class="form-control" name="lastname" placeholder="Last Name" required>
					</div>
					<div class="form-group col-md-4">
						<label class="control-label"> Date of Birth</label> <input
							type="date" class="form-control" name="DoB" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4">
						<label class="control-label" for="">City</label> <input
							type="text" class="form-control" name="city" placeholder="City"
							required>
					</div>
					<div class="form-group col-md-2">
						<label class="control-label" for="">State</label> <input
							type="text" class="form-control" name="state" placeholder="State"
							required>
					</div>
					<div class="form-group col-md-2">
						<label class="control-label" for="">Zip Code</label> <input
							type="text" class="form-control" name="zip" placeholder="Zip" required>
					</div>
					<div class="form-group col-md-4">
						<label for="">Country</label> <input type="text"
							class="form-control" name="country" placeholder="Country" required>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label class="control-label" for="">SSN</label> <input
								type="text" class="form-control" name="ssn" placeholder="SSN"
								required>
						</div>
						<div class="form-group col-md-6">
							<label class="control-label" for="">Phone Number</label> <input
								type="text" class="form-control" name="phoneNum"
								placeholder="Phone Number" required>
						</div>
						<div class="form-row">
							<div class="form-group col-md-4">
								<label class="control-label" for="">Salary</label> <input
									type="text" class="form-control" name="salary">
							</div>
							<div class="form-group col-md-4">
								<label class="control-label" for="">Credit Score</label> <input
									type="text" class="form-control" name="creditScore"
									placeholder="Credit Score" placeholder="Amount" required>
							</div>
							<div class="form-group col-md-4">
								<label class="control-label" for="">Marital status</label> <select
									name="maritalStatus" class="form-control">
									<option selected>Choose...</option>
									<option>Single</option>
									<option>Married</option>
									<option>Divorced</option>
									<option>Widowed</option>
								</select>
							</div>
						</div>
					</div>
				</div>
			</fieldset>
			<fieldset class="border p-2">
				<legend class="w-auto">Loan Details:</legend>
				<div class="form-group">
					<label class="control-label" for="">Lone type</label>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" name="personal" name="customRadioInline1" class="custom-control-input"> <label
							class="custom-control-label" for="customRadioInline1">personal</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" name="mortgage" class="custom-control-input"> <label
							class="custom-control-label" for="customRadioInline2">mortgage</label>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4">
						<label class="control-label" for="">Loan amount</label> <input
							type="text" class="form-control" placeholder="Amount">
					</div>
					<div class="form-group col-md-4">
						<label class="control-label" for="">Down payment</label> <input
							type="text" class="form-control" placeholder="Amount">
					</div>
					<div class="form-group col-md-4">
						<label class="control-label" for="">Co-signer</label> <input
							type="text" class="form-control" id="" placeholder="" required>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label" for="">Reason for loan</label>
					<textarea class="form-control" aria-label="With textarea"></textarea>
				</div>
			</fieldset>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<script type="text/javascript"
			src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</div>
</body>
</html>