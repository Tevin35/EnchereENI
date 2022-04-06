<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout de Retrait</title>
</head>
<body>
	<header>
		<h1>
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
		<c:if test="${!model.connecter}">
			<p>
				<a
					href="http://localhost:8080/EnchereENI/UtilisateurConnexionServlet">S'inscrire
					- Se connecter</a>
			</p>
		</c:if>
		<c:if test="${model.connecter}">
			<p>
				<a href="http://localhost:8080/EnchereENI/EnchereServlet">Enchère</a>
				<a href="http://localhost:8080/EnchereENI/ArticleCreationServlet">Vendre
					un article</a> <a
					href="http://localhost:8080/EnchereENI/UtilisateurInformationServlet">Mon
					profil</a> <a
					href="http://localhost:8080/EnchereENI/PageAcceuilServlet">Déconnexion</a>
			</p>
		</c:if>
	</header>
	
		<form action="AjoutRetraitServlet" method="post">
			Numéro de l'article : <input type="number" name="noArticle"><br>
			Rue : <input type="text" name="rue"><br>
			Code Postal : <input type="text" name="codePostal"><br>
			Ville : <input type="text" name="ville"><br>
			<input type="submit" name="valider" value="Valider">
		</form>
	
</body>
</html>