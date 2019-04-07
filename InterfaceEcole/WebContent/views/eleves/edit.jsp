<%@ page
	import="com.crea.dev1.jee.ecole.interf.control.ControleurPrincipal"%>
<jsp:useBean id="eleve" class="com.crea.dev1.jee.ecole.model.beans.Eleve" scope="request" />  
<jsp:setProperty name="eleve" property="*" /> 
<jsp:useBean id="eleveDAO" class="com.crea.dev1.jee.ecole.model.dao.EleveDAO" scope="request" />
 
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

div {
	margin: 10px 50px;
}
</style>
<title>Edition eleve</title>
</head>
<body>
	<h2>Edition eleve dans la base de donnee</h2>
	<form method="post" action="" enctype="multipart/form-data">
		<div class="form-group">
			<label for="name">Num</label> <input type="text" name="num" id="num"
				value="<%=eleve.getNum() %>" required />
		</div>
	</form>
	<form method="post" action="" enctype="multipart/form-data">
		<div class="form-group">
			<label for="name">No</label> <input type="text" name="no" id="no"
				value="<%=eleve.getNo() %>" required />
		</div>
	</form>
	<form method="post" action="" enctype="multipart/form-data">
		<div class="form-group">
			<label for="name">Nom</label> <input type="text" name="nom" id="nom"
				value="<%=eleve.getNom() %>" required />
		</div>
	</form>
	<form method="post" action="" enctype="multipart/form-data">
		<div class="form-group">
			<label for="name">Age</label> <input type="text" name="age" id="age"
				value="<%=eleve.getAge() %>" required />
		</div>
	</form>
	<form method="post" action="" enctype="multipart/form-data">
		<div class="form-group">
			<label for="name">Adresse</label>
			<input type="text" name="num" id="num" value="" required />
		</div>
		<input type="submit" class="btn btn-primary" />
	</form>
</body>
</html>