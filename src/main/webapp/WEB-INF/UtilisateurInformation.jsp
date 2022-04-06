<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>
<body>
	<header>
		<h1 class="acceuil">
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>

	</header>

	<p>
		Pseudo : ${modelU.utilisateur.pseudo}<br> <br> Nom :
		${modelU.utilisateur.nom}<br> <br> Prenom :
		${modelU.utilisateur.prenom}<br> <br> Email :
		${modelU.utilisateur.email}<br> <br> Telephone :
		${modelU.utilisateur.telephone}<br> <br> Rue :
		${modelU.utilisateur.rue}<br> <br> Code Postal :
		${modelU.utilisateur.codePostal}<br> <br> Ville :
		${modelU.utilisateur.ville}<br> <br> Crédit :
		${modelU.utilisateur.credit} <img alt="Credit" src="${pageContext.request.contextPath}/src/main/webapp/images/stonk.png">
	</p>
	
	<a href="http://localhost:8080/EnchereENI/UtilisateurModificationServlet">Modifier</a>

</body>
</html>