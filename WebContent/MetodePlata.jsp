<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Metode plata</title>
</head>
<body>

	<form action="tipMetodaPlata" method="post">

		<p>Alege metoda de plata:</p>
		<input type="radio" name="metodaPlata" value="paypal">
		 <label for="paypal">Paypal</label> <br> 
		 <input type="radio" name="metodaPlata" value="card"> 
		 <label for="card">Card</label>
		<br>
		<p>Ales Paypal</p>
		<p id="metodaAleasa"></p>
		<input type="submit">	
	</form>

</body>
</html>