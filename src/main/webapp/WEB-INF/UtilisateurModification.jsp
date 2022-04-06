<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification</title>
</head>
<body>

	<header>
		<h1 class="acceuil">
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
	</header>

	<form action="UtilisateurModificationServlet" method="post">

		Pseudo : <input type="text" name="pseudo"
			value="${model.utilisateur.pseudo}"><br> <br> Nom :
		<input type="text" name="nom" value="${model.utilisateur.nom}"><br>
		<br> Prenom : <input type="text" name="prenom"
			value="${model.utilisateur.prenom}"><br> <br> Email
		: <input type="email" name="email" value="${model.utilisateur.email}"><br>
		<br> Telephone : <input type="text" name="telephone"
			value="${model.utilisateur.telephone}"><br> <br>
		Rue : <input type="text" name="rue" value="${model.utilisateur.rue}"><br>
		<br> Code postal : <input type="text" name="codePostal"
			value="${model.utilisateur.codePostal}"><br> <br>
		Ville : <input type="text" name="ville"
			value="${model.utilisateur.ville}"><br> <br> Mot de
		passe : <input type="password" name="password" value=""><br>
		<br> Nouveau mot de passe : <input type="password"
			name="newMotDePasse" required><br> <br> Confirmation
		mot de passe : <input type="password" name="confirmMotDePasse"
			required><br> <br> Crédit :
		${model.utilisateur.credit} <br> <input type="submit"
			name="modifier" value="Enregistrer"> <br> <input
			type="submit" name="supprimer" value="Supprimer mon compte">

	</form>

</body>
</html>