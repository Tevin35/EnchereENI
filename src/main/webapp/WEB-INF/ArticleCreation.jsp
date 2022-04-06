<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création d'articles</title>
</head>
<body>
	<header>

		<h1 class="acceuil">
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
		<c:if test="${!modelU.connecter}">
			<div class="deconnecter">
				<p>
					<a class="nav"
						href="http://localhost:8080/EnchereENI/UtilisateurConnexionServlet">S'inscrire
						- Se connecter</a>
				</p>
			</div>
		</c:if>
		<c:if test="${modelU.connecter}">
			<div class="connecter">
				<p>
					<a class="nav"
						href="http://localhost:8080/EnchereENI/EnchereServlet">Enchère</a>
				</p>
				<p>
					<a class="nav"
						href="http://localhost:8080/EnchereENI/ArticleCreationServlet">Vendre
						un article</a>
				</p>
				<p>
					<a class="nav"
						href="http://localhost:8080/EnchereENI/UtilisateurInformationServlet">Mon
						profil</a>
				</p>
				<p>
				<form class="margin" action="PageAcceuilServlet" method="post">
					<input class="nav" type="submit" name="deco" value="Déconnexion">
				</form>
				</p>
			</div>
		</c:if>
	</header>
	
	<form action="ArticleCreationServlet" method="post">
		Nom de l'article : <input type="text" name="nomArticle"><br>
		<br> Description : <br><textarea name="description" rows="5" cols="50" placeholder="Description décrivant votre joli produit"></textarea><br>
		<br> Date de début de l'enchère : <input type="date"
			name="dateDebutEncheres"><br> <br> Date de fin de
		l'enchère : <input type="date" name="dateFinEncheres"><br>
		<br> Prix du début de l'enchère : <input type="number"
			name="miseAPrix"><br><br> Catégorie : <select
			name="categories" id="categories-select">
			<option value="">--Choisir une catégorie--</option>
			<c:forEach items="${modelCat.lstCategories}" var="cat">
				<option value="${cat.noCategorie}">${cat.libelle}</option>
			</c:forEach>
		</select> <input type="submit" name="valider" value="Valider">

	</form>


	<h3>${model.message}</h3>
</body>
</html>