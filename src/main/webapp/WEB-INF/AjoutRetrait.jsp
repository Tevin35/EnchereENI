<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout de Retrait</title>
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
		<h1>
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
		<c:if test="${!model.connecter}">
			<p>
				<a
					href="http://localhost:8080/EnchereENI/UtilisateurConnexionServlet">S'inscrire
					- Se connecter</a>
			</p>
			<p>
			<button id="theme-switcher"><i class="fa-solid fa-lightbulb"></i></button>
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
			<p>
			<button id="theme-switcher"><i class="fa-solid fa-lightbulb"></i></button>
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