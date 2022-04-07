<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/information.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail des ventes</title>
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
</head>
<body>
	<header>
		<h1 class="acceuil">
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
		<p>
			<button id="theme-switcher">Switch</button>
		</p>
	</header>
	
	<div class="form">
	
		<p>${modelA.articleVendu.nomArticle}</p>
		<p>Description : ${modelA.articleVendu.description}</p>
		<p>Categorie : ${modelA.articleVendu.noCategorie.libelle }</p>

		<p>Meilleure offre :</p>
		<p>Mise à prix : ${modelA.articleVendu.miseAPrix }</p>
		<p>Fin de l'enchère : ${modelA.articleVendu.dateFinEncheres }</p>
		<p>Retrait : ${modelA.articleVendu.lieuRetrait.rue}
			${modelA.articleVendu.lieuRetrait.codePostal}
			${modelA.articleVendu.lieuRetrait.ville}</p>
		<p>Vendeur : ${modelA.articleVendu.noUtilisateur.nom}
		${modelA.articleVendu.noUtilisateur.prenom}</p>
		<p>Ma proposition :
		<form action="DetailVenteServlet" method="post">
			<input type="number" name="maproposition">
			<input type="hidden" name="noArticle" value="${modelA.articleVendu.noArticle}">
			<input type="submit" name="submit" value="Encherir">
		</form></p>
		
	</div>	
	
</body>
</html>