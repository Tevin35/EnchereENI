<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/information.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Information du Vendeur</title>
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
		<p>
			<button id="theme-switcher" class="lumiere"><i class="fa-solid fa-lightbulb"></i></button>
		</p>
	</header>

	<div class="form">
		<p>Pseudo : ${modelU.utilisateur.pseudo}</p> 
		<p>Nom : ${modelU.utilisateur.nom}</p> 
		<p>Prenom : ${modelU.utilisateur.prenom}</p>
		<p>Email : ${modelU.utilisateur.email}</p> 
		<p>Telephone : ${modelU.utilisateur.telephone}</p>
		<p>Rue : ${modelU.utilisateur.rue}</p> 
		<p>Code Postal : ${modelU.utilisateur.codePostal}</p>
		<p>Ville : ${modelU.utilisateur.ville}</p> 
		<p>Crédit :	${modelU.utilisateur.credit}</p>
	</div>

</body>
</html>