<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>
<body>
	<header>
		<h1>
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>

	</header>

	<p>
		Pseudo : ${model.utilisateur.pseudo}<br> <br> Nom :
		${model.utilisateur.nom}<br> <br> Prenom :
		${model.utilisateur.prenom}<br> <br> Email :
		${model.utilisateur.email}<br> <br> Telephone :
		${model.utilisateur.telephone}<br> <br> Rue :
		${model.utilisateur.rue}<br> <br> Code Postal :
		${model.utilisateur.codePostal}<br> <br> Ville :
		${model.utilisateur.ville}<br> <br> Crédit :
		${model.utilisateur.credit}
	</p>
	
	<a href="http://localhost:8080/EnchereENI/UtilisateurModificationServlet">Modifier</a>

</body>
</html>