<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Report Choice</title>
</head>

<!--  Copied and pasted radio design from https://markheath.net/post/customize-radio-button-css -->
<!--  Credit for radio buttons go to them -->

<style type="text/css">
	.radio-toolbar {
		margin: 10px;
	}

	.radio-toolbar input[type="radio"] {
    	display:none; 
	}

	.radio-toolbar label {
    	display:inline-block;
    	background-color:#ddd;
    	padding: 10px 20px;
    	font-family:Arial;
    	font-size:16px;
    	border: 2px solid #444;
    	border-radius: 4px;    
	}

	.radio-toolbar label:hover {
  		background-color: #dfd;
	}

	.radio-toolbar input[type="radio"]:checked + label { 
    	background-color:#bfb;
    	border-color: #4c4;
	}
	
	html {
		height: 100%;
	}

	body {
  		background: linear-gradient(to top, #808080 0%, #3fada8 100%);
	}
	
	h1 {
		text-align: center;
		color: white;
		font-family: "Times New Roman", Times, serif;
	}
	
	div {
		text-align: center;
		font-family: "Times New Roman", Times, serif;
	}
	
	input[type=submit] {
  		background-color: #555555;
  		color: white;
  		padding: 14px 20px;
  		margin: 8px 0;
  		border: none;
  		border-radius: 4px;
  		cursor: pointer;
	}
	
	label {
		font-family:Arial;
    	font-size:16px;
    }
	
</style>
<body>
	<h1>Please select a time frame to show all loans in that time</h1>
	<form method="POST" action="/getLoans">

		<div class="radio-toolbar">
    		<input type="radio" id="1" name="time" value="15" checked>
    		<label for="1">Last 15 days</label>

    		<input type="radio" id="2" name="time" value="7">
    		<label for="2">Last 7 days</label>

    		<input type="radio" id="3" name="time" value="1">
    		<label for="3">Last 24 hours</label> 
    		
		</div>
		<div>
			<input type="submit" value="Submit">
		</div>
	</form> 
</body>
</html>