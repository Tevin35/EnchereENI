<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/pageAcceuil.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'acceuil</title>
</head>
<body>
	<header>

		<h1 class="acceuil">
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
		<c:if test="${!modelU.connecter}">
			<div class="deconnecter">
				<p>
					<a
						href="http://localhost:8080/EnchereENI/UtilisateurConnexionServlet">S'inscrire
						- Se connecter</a>
				</p>
			</div>
		</c:if>
		<c:if test="${modelU.connecter}">
			<div class="connecter">
				<p>
					<a href="http://localhost:8080/EnchereENI/EnchereServlet">Enchère</a>
					<a href="http://localhost:8080/EnchereENI/ArticleCreationServlet">Vendre
						un article</a> <a
						href="http://localhost:8080/EnchereENI/UtilisateurInformationServlet">Mon
						profil</a>
				<form action="PageAcceuilServlet" method="post">
					<input type="submit" name="deco" value="Déconnexion">
				</form>
				</p>
			</div>
		</c:if>
	</header>

	<div class="enchere">

		<!-- utlisateur deconnecter -->
		<c:if test="${!modelU.connecter}">

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

			<p>
			<p>Liste des Encheres</p>
			<c:forEach items="${modelA.lstArticles}" var="article">
					${article.nomArticle}<br>
					Prix : ${article.miseAPrix}<br>
					Fin de l'enchere : ${article.dateFinFormat}<br> 
					Vendeur : ${article.noUtilisateur.pseudo}
					<br>
				<br>
			</c:forEach>
			</p>
		</c:if>


		<!-- utlisateur connecter -->
		<c:if test="${modelU.connecter}">
			<div class="filtre">
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

				<form action="PageAcceuilServlet" method="post" class="form">
					<div class="achat">
						<input type="radio" id="achatSelect" name="filtre" value="email">
						<label for="contactChoice1">Achat</label><br> <input
							type="checkbox" id="ouvertes" name="ouvertes"> <label
							for="ouvertes">Enchères ouvertes</label><br> <input
							type="checkbox" id="mesEncheres" name="mesEncheres"> <label
							for="mesEncheres">Mes enchères</label><br> <input
							type="checkbox" id="remporte" name="remporte"> <label
							for="remporte">Mes enchères remportées</label> <br>
						<br>
						<br>

					</div>
					<div class="ventes">
						<input type="radio" id="ventesSelect" name="filtre" value="Ventes">
						<label for="ventesSelect">Ventes</label><br> <input
							type="checkbox" id="enCour" name="enCour"> <label
							for="enCour">Mes ventes en cours</label><br> <input
							type="checkbox" id="debute" name="debute"> <label
							for="debute">Ventes débutées</label><br> <input
							type="checkbox" id="termine" name="termine"> <label
							for="termine">Ventes terminées</label><br>

					</div>
				</form>
			</div>
5			<div class="lstenchere">
				<p>Liste des Encheres</p>


				<c:forEach items="${modelA.lstArticles}" var="article">

					<div class="uneEnchere">
						<a href="http://localhost:8080/EnchereENI/DetailVenteServlet?noArticle=${article.noArticle}">${article.nomArticle}</a><br>
						Prix : ${article.miseAPrix}<br> Fin de l'enchere :
						${article.dateFinFormat}<br> Vendeur : <a
							href="http://localhost:8080/EnchereENI/VendeurInformationServlet?pseudo=${article.noUtilisateur.pseudo}">${article.noUtilisateur.pseudo}</a>
						<br> <br>
					</div>

				</c:forEach>
			</div>
				
		</c:if>
	</div>
</body>
</html>