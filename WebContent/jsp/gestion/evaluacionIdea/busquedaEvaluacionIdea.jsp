<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Harry Bravo">
<meta name="description"
	content="Página de búsqueda de evaluación de idea">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<jsp:include page="../../include/cabecera.jsp" flush="true" />
	<div class="container">
		<p>
			<strong>Evaluación de Idea &gt; Búsqueda</strong>
		</p>
		<span style="color: red;">${mensaje}</span>
		<form name="formulario" method="post"
			action="${contextPath}/BusquedaEvaluacionIdeaServlet"
			class="form-horizontal">
			<input type="hidden" name="rutaContexto" value="${contextPath}">
			<input type="hidden" name="codigo">
			<p>
				Título <label><input type="text" name="titulo"
					value="${idea.titulo}"></label> <label> <input
					type="submit" value="Buscar">
				</label>
			</p>
			<div class="table-responsive">
				<table border="1"
					style="width: 550; height: 65; padding: 0; border-spacing: 0;"
					class="table table-hover">
					<tr>
						<th style="width: 192">Título</th>
						<th style="width: 107">Archivo</th>
						<th style="width: 192">Estudiante</th>
						<th style="width: 192">Asesor</th>
						<th style="width: 107">Estado</th>
						<th style="width: 120">Fecha Creación</th>
						<th style="width: 107">Acciones</th>
					</tr>
					<c:forEach var="idea" items="${listaIdea}">
						<tr>
							<td>${idea.titulo}</td>
							<td><a
								href="${contextPath}${directorioArchivo}/${idea.archivo}"
								target="_blank">${idea.archivo}</a></td>
							<td>${idea.estudiante.nombreCompleto}</td>
							<td>${idea.asesor.nombreCompleto}</td>
							<td>${idea.estadoIdea.nombre}</td>
							<td><fmt:formatDate value="${idea.fechaCreacion}"
									pattern="dd/MM/yyyy HH:mm" /></td>
							<td><c:if test="${idea.publicada}">
									<a href="javascript: void(0);"
										onclick="obtener('${idea.codigo}');">Evaluar</a>
								</c:if> <c:if
									test="${idea.aprobada and empty idea.asesor.nombreCompleto}">
									<a href="javascript: void(0);"
										onclick="obtener('${idea.codigo}');">Asignar Asesor</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
		<jsp:include page="../../include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
	<script src="${contextPath}/js/app/evaluacionIdea.js"></script>
</body>
</html>