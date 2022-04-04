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
	${model.articleVendu.nomArticle}</p>
	Description : ${model.articleVendu.description}</p>
	Categorie : ${model.articleVendu.noCategorie.libelle }</p>
	
	Meilleure offre :  </p>
	Mise à prix : ${model.articleVendu.miseAPrix }</p>
	Fin de l'enchère : ${model.articleVendu.dateFinEncheres }</p>
	Retrait : ${model.articleVendu.lieuRetrait.rue} ${model.articleVendu.lieuRetrait.codePostal } ${model.articleVendu.lieuRetrait.ville }</p>
	Vendeur : ${model.articleVendu.noUtilisateur.nom} ${model.articleVendu.noUtilisateur.prenom}</p>
	Ma proposition :
	<li>
	
	</li>
	<form>
		<input type ="button" value="Encherir"> 
	</form>
	
	
	
		
		
	</p>
	
	
	</header>
</body>
</html>