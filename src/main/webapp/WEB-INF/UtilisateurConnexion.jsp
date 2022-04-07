<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/connexion.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
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
	
	<div class="login">
		<form action="UtilisateurConnexionServlet" method="post">
			<p>Identifiant : <input type="text" name="pseudo" autofocus></p>
			<p>Mot de passe : <input type="password" name="password"></p>
			<p><input class="btn" type="submit" name="connexion" value="Connexion">
			<input type="checkbox" id="saveSelect" name="save">
			<label for="saveSelect">Se souvenir de moi</label></p>
			<p><a href="http://localhost:8080/EnchereENI/MotDePasseOublier">Mot de passe oublié</a>
			</p>
			<p><input class="btn" type="submit" name="inscription" value="Créer un compte"></p>
		</form>
		
		<h4 style="color:red">${modelU.message}</h4>
	</div>
	

</body>
</html>