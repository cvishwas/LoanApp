<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loan Status Review</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<div class="wrapper">
<div class="top-container">
<div class="pos-f-t">
  <div class="sticky collapse" id="navbarToggleExternalContent">
    <div class="bg-dark p-4">
      <h5 class="text-white h4">Welcome to LoanApp</h5>
      <a href="" class="text-white">Home</a>
      <a href="" class="text-white">About</a>
      <a href="" class="text-white">Sign In</a>
    </div>
  </div>
  <nav class="navbar navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  </nav>
</div>
<div class="jumbotron jumbotron-fluid">
<h1>Loan Status Review</h1>
<div class="dropdown">
  <button class="btn btn-secondary btn-lg dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Select Type of Loan
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
  	<button class="dropdown-item" type="button">All Loans</button>
    <button class="dropdown-item" type="button">Mortgage</button>
    <button class="dropdown-item" type="button">Personal</button>
    <button class="dropdown-item" type="button">Auto</button>
    <button class="dropdown-item" type="button">Business</button>
  </div>
</div>
</div>
</div>
<div class="bottom-container">
<div class="row">
  	<div class="col-md-4">
    <div>Name (Append name from db here)</div>
    <div>(Loan Type) Loan (append loan name from db here)</div>
    </div>
    <div class="col-md-8">LOAN PDF GOES HERE (append loan link here)</div>
 </div>


<div class="row">
  	<div class="col-md-4">
    Loan Status: (clicking one should change status to db) 
    </div>
    <div class="col-md-8">
    	<div class="custom-control custom-radio custom-control-inline">
  <input type="radio" id="customRadioInline1" name="customRadioInline1" class="custom-control-input">
  <label class="custom-control-label" for="customRadioInline1">Complete</label>
</div>
<div class="custom-control custom-radio custom-control-inline">
  <input type="radio" id="customRadioInline2" name="customRadioInline1" class="custom-control-input">
  <label class="custom-control-label" for="customRadioInline2">Needs more information</label>
</div>
    </div>
 </div>
</div>
<hr />
</div>
</body>
</html>