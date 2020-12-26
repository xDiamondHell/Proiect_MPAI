<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Adauga Client</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>

<body>

<div class="form-style-10">
<h1>Customer information<span>Information needed to place an order</span></h1>
<form action="adaugaClient" method="post">
    <div class="section"><span>1</span>First Name & Address</div>
    <div class="inner-wrap">
        <label>Your Full Name*<input required type="text" name="denumire" /></label>
        <label>CNP <input type="text" name="cnp"  minlength="13" maxlength = "13"/></label>
        <label>Address*<textarea required name="adresa"></textarea></label>
        <label>County*<input required type="text" name="localitate"></input></label>
    </div>

    <div class="section"><span>2</span>Email & Phone</div>
    <div class="inner-wrap">
        <label>Email Address*<input required type="email" name="email" /></label>
        <label>Phone Number <input type="text" name="telefon"/></label>
    </div>

    <div class="button-section">
     <input type="submit" name="Sign Up" value="Next Step"/>
    </div>
</form>
</div>

</body>
  <style type="text/css">
  <%@include file="css/style-forms.css"%>
  </style>
   <style>
 body {
  background-image: url("https://wallpaperaccess.com/full/468014.jpg"); /* The image used */
  background-color: #cccccc; /* Used if the image is unavailable */
  background-position: center; /* Center the image */
  background-repeat: no-repeat; /* Do not repeat the image */
  background-size: cover; /* Resize the background image to cover the entire container */
}
 </style>
</html>

  

