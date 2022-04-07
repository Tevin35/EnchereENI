<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a remporté l'enchère</title>
<script src="https://kit.fontawesome.com/c1c5cfe2d5.js" crossorigin="anonymous"></script>
</head>
<body>
	<header>
		<h1>
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
		<p>Description : ${modelA.articleVendu.description}</p>

		Meilleure offre :
		</p>
		Mise à prix : ${modelA.articleVendu.miseAPrix }
		</p>
		Fin de l'enchère : ${modelA.articleVendu.dateFinEncheres }
		</p>
		Retrait : ${modelA.articleVendu.lieuRetrait.rue}
		${modelA.articleVendu.lieuRetrait.codePostal}
		${modelA.articleVendu.lieuRetrait.ville}
		</p>
		${modelA.articleVendu.lieuRetrait.codePostal }
		${modelA.articleVendu.lieuRetrait.ville }
		</p>
		Vendeur : ${modelA.articleVendu.noUtilisateur.nom}
		${modelA.articleVendu.noUtilisateur.prenom}
		</p>
	</header>
	<form>
		<input type="button" name="Retrait effectué" value="Retrait effectué">
	</form>
</body>
</html>