<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/main.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/pageAcceuil.css" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'acceuil</title>
<script type="text/javascript">
	// Wait for document to load
	document.addEventListener("DOMContentLoaded", function(event) {
          document.documentElement.setAttribute("data-theme", "dark");
      
          // Get our button switcher
          var themeSwitcher = document.getElementById("theme-switcher");
      
          // When our button gets clicked
          themeSwitcher.onclick = function() {
            // Get the current selected theme, on the first run
            // it should be `light`
            var currentTheme = document.documentElement.getAttribute("data-theme");
      
            // Switch between `dark` and `light`
            var switchToTheme = currentTheme === "dark" ? "light" : "dark"
      
            // Set our currenet theme to the new one
            document.documentElement.setAttribute("data-theme", switchToTheme);
          }
        });
  </script>
  <script src="https://kit.fontawesome.com/c1c5cfe2d5.js" crossorigin="anonymous"></script>
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
				<p>
					<button id="theme-switcher"><i class="fa-solid fa-lightbulb"></i></button>
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
				<p>
					<button id="theme-switcher" class="lumiere"><i class="fa-solid fa-lightbulb"></i></button>
				</p>
			</div>
		</c:if>
	</header>

	<div class="enchere">

		<!-- utlisateur deconnecter -->
		<c:if test="${!modelU.connecter}">

			<p>Filtres :</p>
			<form action="PageAcceuilServlet" method="post">
				<input type="text" name="recherche" placeholder="Recherche" value="">  
				Categories : <select name="categories" id="categories-select">
					<option value="">--choisir une catégorie--</option>
					<c:forEach items="${modelCat.lstCategories}" var="cat">
						<option value="${cat.noCategorie}">${cat.libelle}</option>
					</c:forEach>
				</select>
				<input type="submit" name="submit" value="Rechercher">
			</form>

			<div class=lstenchere>
				<p>Liste des Encheres</p>
				<c:forEach items="${modelA.lstArticles}" var="article">
					<div class="uneEnchere">
						<p class="strong">${article.nomArticle}</p> 
						<p>Prix : ${article.miseAPrix}</p>
						<p>Fin de l'enchere : ${article.dateFinFormat}</p>
						<p>Vendeur : ${article.noUtilisateur.pseudo}</p>
						
					</div>
				</c:forEach>
			</div>
		</c:if>


		<!-- utlisateur connecter -->
		<c:if test="${modelU.connecter}">
			<div class="filtre">
				<p>Filtres :</p>
				<form action="PageAcceuilServlet" method="post">
					<input type="text" name="rechercher" placeholder="Rechercher">  
					Categories : <select name="categories" id="categories-select">
						<option value="">--choisir une catégorie--</option>
						<c:forEach items="${modelCat.lstCategories}" var="cat">
							<option value="${cat.noCategorie}">${cat.libelle}</option>
						</c:forEach>
					</select>

				<div class="form">
					<div class="achat">
						<input type="radio" id="achatSelect" name="filtre" value="email">
							<label for="achatSelect">Achat</label><br> 
						<input type="checkbox" id="ouvertes" name="ouvertes"> 
							<label for="ouvertes">Enchères ouvertes</label><br> 
						<input type="checkbox" id="mesEncheres" name="mesEncheres"> 
							<label for="mesEncheres">Mes enchères</label><br> 
						<input type="checkbox" id="remporte" name="remporte">
							<label for="remporte">Mes enchères remportées</label> <br> <br>
						<br>

					</div>
					<div class="ventes">
						<input type="radio" id="ventesSelect" name="filtre" value="Ventes">
							<label for="ventesSelect">Ventes</label><br> 
						<input type="checkbox" id="enCour" name="enCour"> 
							<label for="enCour">Mes ventes en cours</label><br> 
						<input type="checkbox" id="debute" name="debute"> 
							<label for="debute">Ventes débutées</label><br>
						<input type="checkbox" id="termine" name="termine"> 
							<label for="termine">Ventes terminées</label><br>

					</div>
					</div>
					<input type="submit" name="submit" value="Rechercher">
				</form>
			</div>
			<div class="lstenchere">
				<p>Liste des Encheres</p>


				<c:forEach items="${modelA.lstArticles}" var="article">

					<div class="uneEnchere">
						<p class="strong"><a href="http://localhost:8080/EnchereENI/DetailVenteServlet?noArticle=${article.noArticle}">${article.nomArticle}</a></p>
						<p>Prix : ${article.miseAPrix}</p>
						<p>Fin de l'enchere : ${article.dateFinFormat}</p>				
						<p>Vendeur : <a href="http://localhost:8080/EnchereENI/VendeurInformationServlet?pseudo=${article.noUtilisateur.pseudo}">${article.noUtilisateur.pseudo}</p>
						
					</div>

				</c:forEach>
			</div>

		</c:if>
	</div>
</body>
</html>