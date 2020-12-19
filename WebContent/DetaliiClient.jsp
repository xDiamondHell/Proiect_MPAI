<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ro.ase.mpai.web.model.Client" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii client</title>
</head>
<body>
<%
	Client client = (Client)request.getAttribute("client");
	
if (client != null) {
	%>
	<p>Cod: <%=client.getCod() %></p>
	<p>Denumire: <%=client.getDenumire() %></p>
	<p>Adresa: <%=client.getAdresa() %></p>
	<p>Localitate: <%=client.getLocalitate() %></p>
	<p>E-mail: <%=client.getEmail() %></p>	
	<p>Telefon: <%=client.getTelefon() %></p>	
	<% 
	}
%>
</body>
</html>