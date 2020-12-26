<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="ro.ase.mpai.web.model.Client"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Afiseaza Lista Clienti</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Full Name</th>
								<th class="column2">E-mail</th>
								<th class="column3">Phone Number</th>
								<th class="column4">CNP</th>
								<th class="column5">Address</th>
								<th class="column6">County</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Client> listaClienti = (List<Client>) request.getAttribute("lista");

							for (Client client : listaClienti) {
							%>
							<tr onclick="window.location='detaliiClient?cod=<%=client.getCod()%>';">
							<td class="column1"><%=client.getDenumire()%></td>
							<td class="column2"><%=client.getEmail()%></td>
							<td class="column3"><%=client.getTelefon()%></td>
							<td class="column4"><%=client.getCNP()%></td>
							<td class="column5"><%=client.getAdresa()%></td>
							<td class="column6"><%=client.getLocalitate()%></td>
							<%
								}
							%>							
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<style>
<%@include file="fonts/font-awesome-4.7.0/css/font-awesome.min.css"%>
<%@include file="vendor/bootstrap/css/bootstrap.min.css"%>
<%@include file="vendor/animate/animate.css"%>
<%@include file="vendor/select2/select2.min.css"%>
<%@include file="vendor/perfect-scrollbar/perfect-scrollbar.css"%>
<%@include file="css/util.css"%>
<%@include file="css/main.css"%>
</style>

<script>
<%@include file="js/main.js"%>	
<%@include file="vendor/jquery/jquery-3.2.1.min.js"%>
<%@include file="vendor/bootstrap/js/popper.js"%>
<%@include file="vendor/bootstrap/js/bootstrap.min.js"%>
<%@include file="vendor/select2/select2.min.js"%>
</script>