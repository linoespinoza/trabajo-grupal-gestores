<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Harry Bravo">
<meta name="description" content="P�gina de error">
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
<title>Sistema de Gesti�n de Innovaci�n</title>
</head>
<body>
	<div class="container">
		<span style="color: red;">Hubo un error en el sistema.
			Cont�ctese con el administrador.</span>
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
</body>
</html>