<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/DetailVentes.css" />
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
	<div class="detail">
	
		<p>${modelA.articleVendu.nomArticle}</br>
		Description : ${modelA.articleVendu.description}</br>
		Categorie : ${modelA.articleVendu.noCategorie.libelle }</br>

		Meilleure offre :
		Mise à prix : ${modelA.articleVendu.miseAPrix }</br>
		Fin de l'enchère : ${modelA.articleVendu.dateFinEncheres }</br>
		Retrait : ${modelA.articleVendu.lieuRetrait.rue}
			${modelA.articleVendu.lieuRetrait.codePostal}
			${modelA.articleVendu.lieuRetrait.ville}</br>
		Vendeur : ${modelA.articleVendu.noUtilisateur.nom}
		${modelA.articleVendu.noUtilisateur.prenom}</br>
		Ma proposition :
		<input type="number" name="maproposition" value="Maproposition">
		<form>
			<input type="button" name="encherir" value="Encherir">
		</form>
		</p>
	</div>	
	
</body>
</html>