<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>

	<header>
		<h1>
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
		<a href="http://localhost:8080/EnchereENI/UtilisateurInformationServlet">
		Mon Compte</a>


	</header>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<form action="UtilisateurInscriptionServlet" method="post">
		Pseudo : <input type="text" name="pseudo"><br>
		<br> Nom : <input type="text" name="nom"><br>
		<br> Prenom : <input type="text" name="prenom"><br>
		<br> Email : <input type="email" name="email"><br>
		<br> Telephone : <input type="text" name="telephone"><br>
		<br> Rue : <input type="text" name="rue"><br>
		<br> Code postal : <input type="text" name="codePostal"><br>
		<br> Ville : <input type="text" name="ville"><br>
		<br> Mot de passe : <input type="password" name="motDePasse"
			required><br>
		<br> Confirmation mot de passe : <input type="password"
			name="confirmMotDePasse" required><br>
		<br> <input type="submit" name="creer" value="Créer"> <input
			type="submit" name="annuler" value="Annuler">

	</form>


	<h3>${model.message}</h3>
</body>
</html>