<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adauga vin</title>
</head>
<body>

<form action="creeazaProdus" method="post">
  <p>Alege culoarea vinului:</p>
  <input type="radio" id="male" name="culoare" value="Rosu">
  <label for="rosu">Rosu</label><br>
  <input type="radio" id="female" name="culoare" value="Alb">
  <label for="female">Alb</label><br>
  <input type="radio" id="rose" name="culoare" value="Rose">
  <label for="other">Rose</label>

  <br>  

  <p>Alege tipul vinului:</p>
  <input type="radio" id="sec" name="tip" value="Sec">
  <label for="sec">Sec</label><br>
  <input type="radio" id="demisec" name="tip" value="DemiSec">
  <label for="demisec">Demisec</label><br>  
  <input type="radio" id="dulce" name="tip" value="Dulce">
  <label for="dulce">Dulce</label>
  <input type="radio" id="demidulce" name="tip" value="Demidulce">
  <label for="demidulce">Demidulce</label><br><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>