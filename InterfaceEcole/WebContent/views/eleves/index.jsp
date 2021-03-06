<%@ page import="java.util.ArrayList"%>
<%@ page import="com.crea.dev1.jee.ecole.model.beans.Eleve"%>
<%@ page
	import="com.crea.dev1.jee.ecole.interf.control.ControleurPrincipal"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des eleves</title>
<style>
body {
	background: #33cc99;
	color: #fff;
	font-family: 'Open Sans', sans-serif;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 90%;
	margin: auto 5%;
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

a {
	color: #fff;
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="center">
		<table>
			<h2>Liste eleves</h2>
			<tr>
				<th>Num</th>
				<th>Nom</th>
				<th>Action</th>
			</tr>
			<% ArrayList<Eleve> eleves = (ArrayList<Eleve>) request.getAttribute("eleves"); %>
			<% for(Eleve eleve:eleves){ %>
			<tr>
				<td><%=eleve.getNum() %></td>
				<td><%=eleve.getNom() %></td>
				<td><a type="button" href="show/<%=eleve.getNum() %>"
					class="btn btn-sm" data-toggle="tooltip" title="Afficher eleve">Afficher
				</a> <a type="button" href="edit/<%=eleve.getNum() %>"
					class="btn btn-sm">Modifier</a></td>
			</tr>
			<% } %>
		</table>
		<br> <br>
		<hr>
		<a href="add">Ajouter un eleve</a>
	</div>
	<br>
	<hr>
	<div id="footer">
		<p id="copyright">
			© <strong>Nancy Tonye</strong> | Projet Ecole | <span
				id="footer_links"><a
				href="mailto:nancy.tonye@crea-inseec.com">nancy.tonye@crea-inseec.com</a></span>
		</p>
	</div>
</body>
</html>