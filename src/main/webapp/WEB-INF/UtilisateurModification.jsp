<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/modification.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification</title>
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
		<form action="UtilisateurModificationServlet" method="post">
	
			<p>Pseudo : <input type="text" name="pseudo" value="${modelU.utilisateur.pseudo}"></p>
			<p>Nom : <input type="text" name="nom" value="${modelU.utilisateur.nom}"></p>
			<p>Prenom : <input type="text" name="prenom" value="${modelU.utilisateur.prenom}"></p>
			<p>Email : <input type="email" name="email" value="${modelU.utilisateur.email}"></p>
			<p>Telephone : <input type="text" name="telephone" value="${modelU.utilisateur.telephone}"></p>
			<p>Rue : <input type="text" name="rue" value="${modelU.utilisateur.rue}"></p>
			<p>Code postal : <input type="text" name="codePostal" value="${modelU.utilisateur.codePostal}"></p>
			<p>Ville : <input type="text" name="ville"	value="${modelU.utilisateur.ville}"></p>
			<p>Mot de passe : <input type="password" name="password" value=""></p>
			<p>Nouveau mot de passe : <input type="password" name="newMotDePasse" required></p>
			<p>Confirmation mot de passe : <input type="password" name="confirmMotDePasse"	required></p>
			<p>Crédit : ${modelU.utilisateur.credit}</p>
			<p><input class="btn" type="submit" name="modifier" value="Enregistrer"></p>
			<p><input class="btn" type="submit" name="supprimer" value="Supprimer mon compte"></p>
	
		</form>
	</div>
	
	<p>${modelU.message}
</body>
</html>