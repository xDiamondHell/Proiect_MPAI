<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="ro.ase.mpai.web.model.Client" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista clientilor companiei</title>
</head>
<body>
<a href="formAdaugareClient">Adauga client nou</a>
<%
	List<Client> listaClienti = (List<Client>)request.getAttribute("lista");

	for (Client client : listaClienti) {%>
	<p><%=client.getCod()%> &nbsp; <%=client.getDenumire()%> <a href="detaliiClient?cod=<%=client.getCod()%>">Detalii ...</a>  </p>	
<% 	
	}
%>
</body>
</html>