<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/information.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Information du Vendeur</title>
</head>
<body>

	<header>
		<h1 class="acceuil">
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>

	</header>

	<div class="form">
		<p>Pseudo : ${modelU.utilisateur.pseudo}</p> 
		<p>Nom : ${modelU.utilisateur.nom}</p> 
		<p>Prenom : ${modelU.utilisateur.prenom}</p>
		<p>Email : ${modelU.utilisateur.email}</p> 
		<p>Telephone : ${modelU.utilisateur.telephone}</p>
		<p>Rue : ${modelU.utilisateur.rue}</p> 
		<p>Code Postal : ${modelU.utilisateur.codePostal}</p>
		<p>Ville : ${modelU.utilisateur.ville}</p> 
		<p>Crédit :	${modelU.utilisateur.credit}</p>
	</div>

</body>
</html>