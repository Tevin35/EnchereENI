<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'acceuil</title>
</head>
<body>
	<header>
		<h1>
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
		<c:if test="${!model.connecter}">
		<p>
			<a href="http://localhost:8080/EnchereENI/UtilisateurConnexionServlet">S'inscrire
				- Se connecter</a>
		</p>
		</c:if>
		<c:if test="${model.connecter}">
		<p>
			<a href="http://localhost:8080/EnchereENI/EnchereServlet">Enchère</a>
			<a href="http://localhost:8080/EnchereENI/ArticleCreationServlet">Vendre un article</a>
			<a href="http://localhost:8080/EnchereENI/UtilisateurInformationServlet">Mon profil</a>
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">Déconnexion</a>
		</p>
		</c:if>
	</header>

	<div>
		<h2>Listes des enchères</h2>

		<p>Filtres :</p>
		<form action="PageAcceuilServlet" method="post">
			<input type="text" name="filtre"> <input type="submit"
				name="submit" value="Rechercher"> Categories : <select
				name="categories" id="categories-select">
				<option value="">--choisir une catégorie--</option>
				<c:forEach items="${modelCat.lstCategories}" var="cat">
					<option value="${cat.libelle}">${cat.libelle}</option>
				</c:forEach>

			</select>
		</form>

		<!-- afficher la liste des encheres en cour -->
		
	</div>

</body>
</html>