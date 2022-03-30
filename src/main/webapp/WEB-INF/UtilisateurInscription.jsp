<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>

<header><a href="http://localhost:8080/Blop/UtilisateurInformationServlet">Mon Compte</a></header><br><br><br><br><br><br>

	<form action="UtilisateurInscriptionServlet" method="post">
	Pseudo : <input type="text" name="pseudo"><br><br>
	Nom : <input type="text" name="nom"><br><br>
	Prenom : <input type="text" name="prenom"><br><br>
	Email : <input type="email" name="email"><br><br>
	Telephone : <input type="text" name="telephone"><br><br>
	Rue : <input type="text" name="rue"><br><br>
	Code postal : <input type="text" name="codePostal"><br><br>
	Ville : <input type="text" name="ville"><br><br>
	Mot de passe : <input type="password" name="motDePasse"><br><br>
	
	<input type="submit" name="valider" value="Valider">
	
	</form>


	<h3>${model.message}</h3>
</body>
</html>