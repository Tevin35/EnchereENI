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
	<p>
	${model.articleVendu.nomArticle}
	Description : ${model.articleVendu.description}
	Categorie : ${model.articleVendu.noCategorie.libelle }
	
	Meilleure offre : 
	Mise à prix : ${model.articleVendu.miseAPrix }
	Fin de l'enchère : ${model.articleVendu.dateFinEncheres }
	Retrait : ${model.articleVendu.lieuRetrait.rue} ${model.articleVendu.lieuRetrait.codePostal } ${model.articleVendu.lieuRetrait.ville }
	Vendeur : ${model.articleVendu.noUtilisateur.noUtilisateur}
	Ma proposition :
	
	
		
		
	</p>
	
	
	</header>
</body>
</html>