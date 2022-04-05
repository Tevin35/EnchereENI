<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail des ventes</title>
</head>
<body>
	<header>
		<h1>
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
		<p>${modelA.articleVendu.nomArticle}</p>
		<p>Description : ${modelA.articleVendu.description}</p>
		<p>Categorie : ${modelA.articleVendu.noCategorie.libelle }</p>

		<p>Meilleure offre :</p>
		<p>Mise à prix : ${modelA.articleVendu.miseAPrix }</p>
		<p>Fin de l'enchère : ${modelA.articleVendu.dateFinEncheres }</p>
		<p>Retrait : ${modelA.articleVendu.lieuRetrait.rue}
			${modelA.articleVendu.lieuRetrait.codePostal}
			${modelA.articleVendu.lieuRetrait.ville}</p>
		<p>Vendeur : ${modelU.utilisateur.noUtilisateur.nom}</p>
		<p>${modelU.utilisateur.noUtilisateur.prenom}</p>
		<p>Ma proposition :
		<input type="number" name="maproposition" value="Maproposition">
		</p>

		<form>
			<input type="button" name="encherir" value="Encherir">
			
			
			
		</form>

	</header>
</body>
</html>