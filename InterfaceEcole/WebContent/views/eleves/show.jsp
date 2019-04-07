<%@ page import="java.util.ArrayList"%>
<%@ page import="com.crea.dev1.jee.ecole.model.beans.Eleve"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {
	background: #33cc99;
	color: #fff;
	font-family: 'Open Sans', sans-serif;
}

.center {
	width: 80%;
	margin: auto 10%;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
}

h2 {
	margin-left: 10%;
}

td, th {
	border: 1px solid #33cc99;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #208060;
}
</style>
</head>
<body>
<% Eleve eleveNum = (Eleve) request.getAttribute("eleveNum");  %>
	<div class="center">
	<table>
		<tr>
	    	<th>Num</th>
	    	<th>No</th>
	    	<th>Nom</th>
	    	<th>Age</th>
	    	<th>Adresse</th>
	    </tr>
		<tr>
		    <td> <%=eleveNum.getNum() %></td>
		    <td> <%=eleveNum.getNo() %></td>
		    <td> <%=eleveNum.getNom() %></td>
		    <td> <%=eleveNum.getAge() %></td>
		    <td> <%=eleveNum.getAdresse()%></td>
	    </tr>
    </table>
</div>
</body>
</html>