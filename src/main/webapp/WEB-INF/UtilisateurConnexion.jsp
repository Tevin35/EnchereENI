<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>

	<header>
		<h1 class="acceuil">
			<a href="http://localhost:8080/EnchereENI/PageAcceuilServlet">ENI-Encheres</a>
		</h1>
	</header>
	
	<div>
		<form action="UtilisateurConnexionServlet" method="post">
			Identifiant : <input type="text" name="pseudo">
			Mot de passe : <input type="password" name="password">
			<input type="submit" name="connexion" value="Connexion">
			<input type="submit" name="inscription" value="Créer un compte">
		</form>
		
		<h4 style="color:red">${model.message}</h4>
	</div>
	

</body>
</html>