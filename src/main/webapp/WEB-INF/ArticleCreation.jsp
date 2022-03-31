<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création d'articles</title>
</head>
<body>
	<form action="ArticleCreationServlet" method="post">
	Nom de l'article : <input type="text" name="nomArticle"><br><br>
	Description : <input type="text" name="description"><br><br>
	Date de début de l'enchère :  <input type="date" name="dateDebutEncheres"><br><br>
	Date de fin de l'enchère :  <input type="date" name="dateFinEncheres"><br><br>
	Prix du début de l'enchère : <input type="number" name="miseAPrix"><br><br>
	Prix de la fin de l'enchère : <input type="number" name="prixVente"><br><br>
	Numéro de l'utilisateur : <input type="number" name="noUtilisateur"><br><br>
	Numéro de la catégorie (1 à 4) : <input type="number" name="noCategorie"><br><br>
	
	<input type="submit" name="valider" value="Valider">
	
	</form>


	<h3>${model.message}</h3>
</body>
</html>