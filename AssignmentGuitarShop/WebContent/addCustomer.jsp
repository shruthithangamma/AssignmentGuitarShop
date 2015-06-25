<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
 <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Customer Invoice Retrieval App</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.html">Home</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<br />
<br />
<br />
    <div class="container">
	    ${message}
	    <div class="jumbotron">
		  <h1>Customer Information</h1>
		   <p><a class="btn btn-primary btn-lg" href="GetCustomer" type="button">Add a new Customer</a></p> 
	  <p>${custInformation}</p>
		</div>
		${subTitle}
	    <table class="table table-hover">
			${tableInfo}
		</table>
		
		<form action="GetCustomer" method="post">
	<div class="container">
	  <fieldset>
	     <legend> <h2> User Information </h2>  </legend>
														 
			 Customer ID:<input type="text" name="customer_id"><br>										 
			  Email:<input type="email" name="email"><br>   
			  Password:<input type="password" name="password"><br>
			  First Name: <input type="text" name="fname" ><br>
			  Last Name: <input type="text" name="lname" ><br>
			  Shipping Address id:<input type="text" name="shipping_address_id"><br>
			  Billing Address id: <input type ="text" name="billing_address_id"><br> 
														 
	</fieldset></div>
<input type="submit" value="submit">
<input type="reset" value="reset">

</form>
    </div>
</body>
</html>