<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Metode plata</title>
</head>
<body>

<div class="form-style-10">
<h1>Choose the payment method<span>You can pay directly with your card or through PayPal</span></h1>
    <div class="section"><span>1</span>Payment methods</div>
    <div class="inner-wrap">       
      <form action="tipMetodaPlata" method="post">
    <label>
      <input type="radio" name="metodaPlata" value="paypal"/>
      <span>PayPal</span>
    </label>
    <label>
      <input type="radio" name="metodaPlata" checked value="card"/>
      <span>Card</span>
    </label>
    <div class="button-section">
     <input type="submit" name="Sign Up" value="Next Step"/>
    </div>
  </form>
    </div>
</div>

</body>
</html>
  <style type="text/css">
  <%@include file="css/style-forms.css"%>
  <%@include file="css/style-radio-buttons.css"%>
  </style>
  
