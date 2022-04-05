<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vous avez remporté la vente</title>
</head>
<body>
	<header>
		<h1>
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
		<p>${model.articleVendu.nomArticle}</p>
		<p>Description : ${modelA.articleVendu.description}</p>
		<p>Categorie : ${modelA.articleVendu.noCategorie.libelle }</p>

		<p>Meilleure offre :</p>
		<p>Mise à prix : ${modelA.articleVendu.miseAPrix }</p>
		<p>Retrait : ${modelA.articleVendu.lieuRetrait.rue}
			${modelA.articleVendu.lieuRetrait.codePostal}
			${modelA.articleVendu.lieuRetrait.ville}</p>

		<p>Vendeur : ${modelA.articleVendu.noUtilisateur.nom}
			${modelA.articleVendu.noUtilisateur.prenom}</p>
		<p>Tel : ${modelA.articleVendu.noUtilisateur.telephone}</p>
	</header>
	<form>
		<input type="button" name="Back" value="Back">
	</form>
</body>
</html>