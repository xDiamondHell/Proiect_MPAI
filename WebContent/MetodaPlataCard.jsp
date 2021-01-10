<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Payment card checkout</title>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet"> 
      <link rel="stylesheet" href="css/style.css"> 
</head>
<body>
  <div class="tips">
Payment card number: (4) VISA, (51 -> 55) MasterCard, (36-38-39) DinersClub, (34-37) American Express, (65) Discover, (5019) dankort
</div>
<%
					String sumaDePlata = (String) request.getAttribute("sumaDePlata");
				%>
<div class="container">
  <div class="col1">
    <div class="card">
      <div class="front">
        <div class="type">
          <img class="bankid"/>
        </div>
        <span class="chip"></span>
        <span class="card_number">&#x25CF;&#x25CF;&#x25CF;&#x25CF; &#x25CF;&#x25CF;&#x25CF;&#x25CF; &#x25CF;&#x25CF;&#x25CF;&#x25CF; &#x25CF;&#x25CF;&#x25CF;&#x25CF; </span>
        <div class="date"><span class="date_value">MM / YYYY</span></div>
        <span class="fullname">FULL NAME</span>
      </div>
      <div class="back">
        <div class="magnetic"></div>
        <div class="bar"></div>
        <span class="seccode">&#x25CF;&#x25CF;&#x25CF;</span>
        <span class="chip"></span><span class="disclaimer">This card is property of Random Bank of Random corporation. <br> If found please return to Random Bank of Random corporation - 21968 Paris, Verdi Street, 34 </span>
      </div>
    </div>
  </div>
  <div class="col2">
  <form action="plaseazaComandaCard" method="post">
    <label>Card Number</label>
    <input name="cardNumber" class="number" type="text" ng-model="ncard" maxlength="19" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
    <label>Cardholder name</label>
    <input name="carholderName" class="inputname" type="text" placeholder=""/>
    <label>Expiry date</label>
    <input name="expiryDate" class="expire" type="text" placeholder="MM / YYYY"/>
    <label>Security Number</label>
    <input name="cvc" class="ccv" type="text" placeholder="CVC" maxlength="3" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
    <button type="submit" class="buy"><i class="material-icons">lock</i> Pay <%=sumaDePlata%> &#36;</button>
    </form>
  </div>
</div>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.1/angular.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>
<script src="js/index.js"></script>
</body>
</html>
  <style type="text/css">
  <%@include file="css/font.css"%>
  <%@include file="css/style.css"%>
  </style>
  <script>
  <%@include file = "js/index.js" %>
  <%@include file = "js/angular.min.js" %>
  <%@include file = "js/jquery.min.js" %>
  <%@include file = "js/jquery-ui.min.js" %>
  </script>
  <style>

 </style>
