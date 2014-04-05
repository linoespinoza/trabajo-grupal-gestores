<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Harry Bravo">
<meta name="description" content="Página de autenticación de usuario">
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
			<input type="email" name="email" class="form-control"
				placeholder="E-mail" autofocus="autofocus" required="required">
			<input type="password" name="contrasenia" class="form-control"
				placeholder="Contraseña" required="required">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
			<span style="color: red;">${mensaje}</span>
		</form>
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
</body>
</html>