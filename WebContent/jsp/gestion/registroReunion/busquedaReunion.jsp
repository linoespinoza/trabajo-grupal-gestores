<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Jeremías Yalta">
<meta name="description" content="Página de registro de reunión">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
<link href="${contextPath}/css/app/comun.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<jsp:include page="../../include/cabecera.jsp" flush="true" />
	<div class="container">
		<p>
			<strong>Registro de Reunión &gt; Búsqueda</strong>
		</p>
		<span style="color: red;">${mensaje}</span>
		<form name="formulario" method="post"
			action="${contextPath}/BusquedaReunionServlet"
			class="form-horizontal">
			<input type="hidden" id="rutaContexto" value="${contextPath}">
			<input type="hidden" id="codigo" name="codigo">
			<p>
				Rango de Fecha <label> <input type="date" name="fechaInicio"
					value="${fechaInicio}">
				</label> <label><input type="date" name="fechaFin"
					value="${fechaFin}"></label> Tipo de Calificación <label> <select
					name="tipoCalificacion">
						<option value="">Todos</option>
						<c:forEach var="tipoCalificacion" items="${listaTipoCalificacion}">
							<c:choose>
								<c:when
									test="${tipoCalificacion.codigo eq reunion.tipoCalificacion.codigo}">
									<option value="${tipoCalificacion.codigo}" selected="selected">${tipoCalificacion.nombre}</option>
								</c:when>
								<c:otherwise>
									<option value="${tipoCalificacion.codigo}">${tipoCalificacion.nombre}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select>
				</label> <label> <input type="submit" value="Buscar">
				</label> <label> <input type="button" value="Crear"
					onclick="crear();">
				</label>
			</p>
			<div class="table-responsive">
				<table border="1"
					style="width: 550; height: 65; padding: 0; border-spacing: 0;"
					class="table table-hover">
					<tr>
						<th style="width: 107">Fecha de Reunión</th>
						<th style="width: 192">Título de Idea</th>
						<th style="width: 192">Estudiante</th>
						<th style="width: 192">Observación</th>
						<th style="width: 107">Calificación</th>
					</tr>
					<c:forEach var="reunion" items="${listaReunion}">
						<tr>
							<td><fmt:formatDate value="${reunion.fechaReunion}"
									pattern="dd/MM/yyyy HH:mm" /></td>
							<td>${reunion.idea.titulo}</td>
							<td>${reunion.idea.estudiante.nombreCompleto}</td>
							<td><a href="javascript: void(0);"
								title="${reunion.observacion}" class="tooltipInfo">Ver</a></td>
							<td>${reunion.tipoCalificacion.nombre}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
		<jsp:include page="../../include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
	<script src="${contextPath}/js/app/registroReunion.js"></script>
</body>
</html>