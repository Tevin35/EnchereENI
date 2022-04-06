<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/inscription.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>

	<header>
		<h1 class="acceuil">
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
	</header>
	<br>
	<br>
	
	<div class="form">
		<form action="UtilisateurInscriptionServlet" method="post">
			<p>Pseudo : <input type="text" name="pseudo" pattern="[a-zA-Z0-9]+"></p>
			<p>Nom : <input type="text" name="nom"></p>
			<p>Prenom : <input type="text" name="prenom"></p>
			<p>Email : <input type="email" name="email"></p>
			<p>Telephone : <input type="text" name="telephone"></p>
			<p>Rue : <input type="text" name="rue"></p>
			<p>Code postal : <input type="text" name="codePostal"></p>
			<p>Ville : <input type="text" name="ville"></p>
			<p>Mot de passe : <input type="password" name="motDePasse" required></p>
			<p>Confirmation mot de passe : <input type="password" name="confirmMotDePasse" required></p>
			<p><input class="btn" type="submit" name="creer" value="Créer">
			<input class="btn" type="submit" name="annuler" value="Annuler"></p>
	
		</form>
	</div>

	<h3>${modelU.message}</h3>
</body>
</html>