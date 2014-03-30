<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Harry Bravo">
<meta name="description" content="Pagina de autenticacion de Usuario">
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
<link href="${contextPath}/css/app/login.css" rel="stylesheet"
	media="screen">
<title>Sistema de Gestión de Innovación</title>
</head>
<body>
	<div class="container">
		<form class="form-signin" action="${contextPath}/LoginServlet"
			method="post">
			<h2 class="form-signin-heading">Autenticación</h2>
			<input type="text" name="email" class="form-control"
				placeholder="E-mail" autofocus="autofocus"> <input
				type="password" name="contrasenia" class="form-control"
				placeholder="Contraseña">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
			<span style="color: red;">${mensaje}</span>
		</form>
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js" type="text/javascript"
		charset="ISO-8859-1"></script>
	<script src="${contextPath}/js/bootstrap.js" type="text/javascript"
		charset="ISO-8859-1"></script>
</body>
</html>