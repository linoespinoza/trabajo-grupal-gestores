<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Página de mantenimiento de Idea">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet" media="screen">
</head>
<body>
	<jsp:include page="../../include/cabecera.jsp" flush="true" />
	<div class="container">
		<p>
			<strong>Mantenimiento de Ideas</strong>
		</p>
		<span style="color: red;">${mensaje}</span>
		<form name="formulario" method="post" action="${contextPath}/BusquedaCentroFormacionServlet"
            class="form-horizontal">
			<input type="hidden" name="rutaContexto" value="${contextPath}">
			<input type="hidden" name="codigo">
            <input type="button" class="btn btn-primary" value="Nuevo" onclick="crear();"><br /><br />
			<div class="table-responsive">
				<table border="1"
					style="width: 550; height: 65; padding: 0; border-spacing: 0;"
					class="table table-hover">
					<tr>
						<th style="width: 50">Título</th>
						<th style="width: 200">Fecha de Creación</th>
						<th style="width: 110">Acciones</th>
					</tr>
					<c:forEach var="idea" items="${listaIdea}">
						<tr>
							<td>${idea.titulo}</td>
							<td>${idea.fechaCreacion}</td>
							<td><a href="javascript: void(0);"
								onclick="editar('${idea.codigo}');">Editar</a> - <a
								href="javascript: void(0);"
								onclick="eliminar('${idea.codigo}');">Eliminar</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
		<jsp:include page="../../include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
	<script src="${contextPath}/js/app/mantenimiento-idea.js"></script>
</body>
</html>