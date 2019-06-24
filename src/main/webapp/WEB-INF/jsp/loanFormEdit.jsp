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
<title>Edit Loan Application</title>
</head>
<body>
	<div class="container p-3">
		<h1>Edit Loan Application Form</h1>
		<form method="POST" action="${contextPath}/loanFormEdit">
			<fieldset class="border p-2">
				<legend class="w-auto">Loan Details:</legend>
				<div class="form-group">
					<label class="control-label" for="">Lone type</label>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="customRadioInline1"
							name="customRadioInline1" class="custom-control-input"> <label
							class="custom-control-label" for="customRadioInline1">type
							1</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" id="customRadioInline2"
							name="customRadioInline1" class="custom-control-input"> <label
							class="custom-control-label" for="customRadioInline2">type
							2</label>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4">
						<label class="control-label" for="">Loan amount</label> <input
							type="text" class="form-control" placeholder="Amount" value=${loan.amount}>
					</div>
					<div class="form-group col-md-4">
						<label class="control-label" for="">Down payment</label> <input
							type="text" class="form-control" placeholder="Amount" value=${loan.downPayment}>
					</div>
					<div class="form-group col-md-4">
						<label class="control-label" for="">Co-signer</label> <input
							type="text" class="form-control" id="" placeholder="" required value="">
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