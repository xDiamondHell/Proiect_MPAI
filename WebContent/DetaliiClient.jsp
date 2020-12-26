<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="ro.ase.mpai.web.model.Client"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii client</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="container">
		<form action="actualizeazaClient" method="post">

			<div class="row">
				<%
					Client client = (Client) request.getAttribute("client");
				%>
				<h4>
					Customer Details -
					<%=client.getDenumire()%></h4>
				<div class="input-group input-group-icon">
					<input type="hidden" name="id" value="<%=client.getCod()%>" /> <input
						name="denumire" id="full-name" type="text" placeholder="Full Name"
						value="<%=client.getDenumire()%>" />
					<div class="input-icon">
						<i class="fa fa-user"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input name="email" type="email" placeholder="Email Address"
						value="<%=client.getEmail()%>" />
					<div class="input-icon">
						<i class="fa fa-envelope"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input name="telefon" type="tel" placeholder="Phone Number"
						value="<%=client.getTelefon()%>" />
					<div class="input-icon">
						<i class="fa fa-phone"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input name="cnp" type="text" placeholder="CNP"
						value="<%=client.getCNP()%>" />
					<div class="input-icon">
						<i class="fa fa-id-card-o"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input name="adresa" type="text" placeholder="Address"
						value="<%=client.getAdresa()%>" />
					<div class="input-icon">
						<i class="fa fa-map-marker"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input name="localitate" type="text" placeholder="County"
						value="<%=client.getLocalitate()%>" />
					<div class="input-icon">
						<i class="fa fa-home"></i>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-half">
					<h4>Date of Birth</h4>
					<div class="input-group">
						<div class="col-third">
							<input type="text" placeholder="DD"
								value="<%=client.getCNP().substring(5, 7)%>" />
						</div>
						<div class="col-third">
							<input type="text" placeholder="MM"
								value="<%=client.getCNP().substring(3, 5)%>" />
						</div>
						<div class="col-third">
							<input type="text" placeholder="YYYY"
								value="<%=client.getCNP().substring(1, 3)%>" />
						</div>
					</div>
				</div>
				<div class="col-half">
					<h4>Gender</h4>
					<%
						if (client.getCNP().startsWith("1")) {
					%>
					<div class="input-group">
						<input disabled type="radio" name="gender" value="male"
							id="gender-male" checked /> <label for="gender-male">Male</label>
						<input disabled type="radio" name="gender" value="female"
							id="gender-female" /> <label for="gender-female">Female</label>
					</div>
					<%
						} else if (client.getCNP().startsWith("2")) {
					%>
					<div class="input-group">
						<input disabled type="radio" name="gender" value="male"
							id="gender-male" /> <label for="gender-male">Male</label> <input
							disabled type="radio" name="gender" value="female"
							id="gender-female" checked /> <label for="gender-female">Female</label>
					</div>
					<%
						}
					%>
				</div>
			</div>
			<div class="row">
				<h4>Payment Details</h4>
				<div class="input-group">
					<input type="radio" name="payment-method" value="card"
						id="payment-method-card" checked="true" /><label
						for="payment-method-card"><span><i
							class="fa fa-cc-visa"></i>Credit Card</span></label><input type="radio"
						name="payment-method" value="paypal" id="payment-method-paypal" /><label
						for="payment-method-paypal"> <span><i
							class="fa fa-cc-paypal"></i>Paypal</span></label>
				</div>

				<%
					if (client.getCNP().startsWith("2")) {
				%>
				<div class="input-group input-group-icon">
					<input type="text" placeholder="Card Number" />
					<div class="input-icon">
						<i class="fa fa-credit-card"></i>
					</div>
				</div>
				<div class="col-half">
					<div class="input-group input-group-icon">
						<input type="text" placeholder="Card CVC" />
						<div class="input-icon">
							<i class="fa fa-user"></i>
						</div>
					</div>
				</div>
				<div class="col-half">
					<div class="input-group">
						<select>
							<option>January</option>
							<option>February</option>
							<option>March</option>
							<option>April</option>
							<option>May</option>
							<option>June</option>
							<option>July</option>
							<option>August</option>
							<option>September</option>
							<option>October</option>
							<option>November</option>
							<option>December</option>
						</select><select>
							<option>2015</option>
							<option>2016</option>
						</select>
					</div>
				</div>
				<%
					} else if (client.getCNP().startsWith("2")) {
				%>
				<div class="input-group input-group-icon">
					<input type="email" placeholder="Email Address"
						value="<%=client.getEmail()%>" />
					<div class="input-icon">
						<i class="fa fa-envelope"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input type="password" placeholder="Password"
						value="<%=client.getEmail()%>" />
					<div class="input-icon">
						<i class="fa fa-key"></i>
					</div>
				</div>
				<%
					}
				%>
			</div>
			<div class="input-group input-group-icon">
				<input type="submit" value="Update Customer Details">
			</div>
		</form>
	</div>
</body>

</html>

<style>
*, *:before, *:after {
	box-sizing: border-box;
}

body {
	padding: 1em;
	font-family: 'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;
	font-size: 15px;
	color: #b9b9b9;
	background-color: #e3e3e3;
}

h4 {
	color: #7ed321;
}

input, input[type="radio"]+label, input[type="checkbox"]+label:before,
	select option, select {
	width: 100%;
	padding: 1em;
	line-height: 1.4;
	background-color: #f9f9f9;
	border: 1px solid #e5e5e5;
	border-radius: 3px;
	transition: all 0.35s ease-in-out;
}

input:focus {
	outline: 0;
	border-color: #64ac15;
}

input:focus+.input-icon i {
	color: #7ed321;
}

input:focus+.input-icon:after {
	border-right-color: #7ed321;
}

input[type="radio"] {
	display: none;
}

input[type="radio"]+label, select, select {
	display: inline-block;
	width: 50%;
	text-align: center;
	float: left;
	border-radius: 0;
}

input[type="radio"]+label:first-of-type {
	border-top-left-radius: 3px;
	border-bottom-left-radius: 3px;
}

input[type="radio"]+label:last-of-type {
	border-top-right-radius: 3px;
	border-bottom-right-radius: 3px;
}

input[type="radio"]+label i {
	padding-right: 0.4em;
}

input[type="radio"]:checked+label, input:checked+label:before, select:focus,
	select:active {
	background-color: #7ed321;
	color: #ffffff;
	border-color: #64ac15;
}

input[type="checkbox"] {
	display: none;
}

input[type="checkbox"]+label {
	position: relative;
	display: block;
	padding-left: 1.6em;
}

input[type="checkbox"]+label:before {
	position: absolute;
	top: 0.2em;
	left: 0;
	display: block;
	width: 1em;
	height: 1em;
	padding: 0;
	content: "";
}

input[type="checkbox"]+label:after {
	position: absolute;
	top: 0.45em;
	left: 0.2em;
	font-size: 0.8em;
	color: #ffffff;
	opacity: 0;
	font-family: FontAwesome;
	content: "\f00c";
}

input:checked+label:after {
	opacity: 1;
}

select {
	height: 3.4em;
	line-height: 2;
}

select:first-of-type {
	border-top-left-radius: 3px;
	border-bottom-left-radius: 3px;
}

select:last-of-type {
	border-top-right-radius: 3px;
	border-bottom-right-radius: 3px;
}

select:focus, select:active {
	outline: 0;
}

select option {
	background-color: #7ed321;
	color: #ffffff;
}

.input-group {
	margin-bottom: 1em;
	zoom: 1;
}

.input-group:before, .input-group:after {
	content: "";
	display: table;
}

.input-group:after {
	clear: both;
}

.input-group-icon {
	position: relative;
}

.input-group-icon input {
	padding-left: 4.4em;
}

.input-group-icon .input-icon {
	position: absolute;
	top: 0;
	left: 0;
	width: 3.4em;
	height: 3.4em;
	line-height: 3.4em;
	text-align: center;
	pointer-events: none;
}

.input-group-icon .input-icon:after {
	position: absolute;
	top: 0.6em;
	bottom: 0.6em;
	left: 3.4em;
	display: block;
	border-right: 1px solid #e5e5e5;
	content: "";
	transition: all 0.35s ease-in-out;
}

.input-group-icon .input-icon i {
	transition: all 0.35s ease-in-out;
}

.container {
	max-width: 38em;
	padding: 1em 3em 2em 3em;
	margin: 0em auto;
	background-color: #ffffff;
	border-radius: 4.199999999999999px;
	box-shadow: 0px 3px 10px -2px rgba(0, 0, 0, 0.2);
}

.row {
	zoom: 1;
}

.row:before, .row:after {
	content: "";
	display: table;
}

.row:after {
	clear: both;
}

.col-half {
	padding-right: 10px;
	float: left;
	width: 50%;
}

.col-half:last-of-type {
	padding-right: 0;
}

.col-third {
	padding-right: 10px;
	float: left;
	width: 33.333333333333336%;
}

.col-third:last-of-type {
	padding-right: 0;
}

@media only screen and (max-width: 540px) {
	.col-half {
		width: 100%;
		padding-right: 0;
	}
}

input[type=submit] {
	background-color: #7ed321;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	text-align: center;
}

input[type=submit]:hover {
	background-color: #45a049;
}

#Submit {
	width: 50%;
	text-align: center;
}
</style>