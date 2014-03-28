<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
<title>Sistema de Gestión de Innovación</title>
</head>
<body>
	<div class="container">
		<span style="color: red;">Hubo un error en el sistema.
			Contáctese con el administrador.</span>
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
</body>
</html>