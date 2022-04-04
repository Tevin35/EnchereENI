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
 <p>
 ${model.articleVendu.nomArticle}</p>
 Description : ${model.articleVendu.description}</p>
 Categorie : ${model.articleVendu.noCategorie.libelle }</p>
 
 Meilleure offre :  </p>
 Mise à prix : ${model.articleVendu.miseAPrix }</p>
 Retrait : ${model.articleVendu.lieuRetrait.rue} ${model.articleVendu.lieuRetrait.codePostal } ${model.articleVendu.lieuRetrait.ville }</p>
 Vendeur : ${model.articleVendu.noUtilisateur.nom} ${model.articleVendu.noUtilisateur.prenom}</p>
 Tel : ${model.articleVendu.noUtilisateur.telephone}
</header>
</body>
</html>