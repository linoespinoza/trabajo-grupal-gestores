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
<meta name="description" content="Pagina de error">
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
<title>Sistema de Gestión de Innovación</title>
</head>
<body>
	<div class="container">
		<span style="color: red;">Hubo un error en el sistema.
			Contáctese con el administrador.</span>
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js" type="text/javascript"
		charset="ISO-8859-1"></script>
	<script src="${contextPath}/js/bootstrap.js" type="text/javascript"
		charset="ISO-8859-1"></script>
</body>
</html>