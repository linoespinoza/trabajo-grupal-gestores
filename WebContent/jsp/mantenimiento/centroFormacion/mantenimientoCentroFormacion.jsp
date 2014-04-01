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
<meta name="description"
	content="Pagina de mantenimiento de centro de formacion">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<jsp:include page="../../include/cabecera.jsp" flush="true" />
	<div class="container">
		<p>
			<strong>Mantenimiento de Centro de Formación &gt; Búsqueda</strong>
		</p>
		<span style="color: red;">${mensaje}</span>
		<form name="formulario" method="post"
			action="${contextPath}/BusquedaCentroFormacionServlet"
			class="form-horizontal">
			<input type="hidden" id="rutaContexto" value="${contextPath}">
			<input type="hidden" id="codigo" name="codigo">
			<p>
				Nombre <label><input type="text" name="nombre"
					value="${centroFormacion.nombre}"></label> Tipo <label> <select
					name="tipo">
						<option value="">Todos</option>
						<c:forEach var="tipoCentroFormacion"
							items="${listaTipoCentroFormacion}">
							<c:choose>
								<c:when
									test="${tipoCentroFormacion.codigo eq centroFormacion.tipoCentroFormacion.codigo}">
									<option value="${tipoCentroFormacion.codigo}"
										selected="selected">${tipoCentroFormacion.nombre}</option>
								</c:when>
								<c:otherwise>
									<option value="${tipoCentroFormacion.codigo}">${tipoCentroFormacion.nombre}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select>
				</label> <label> <input type="submit" value="Buscar">
				</label> <label> <input type="button" value="Nuevo"
					onclick="crear();">
				</label>
			</p>
			<div class="table-responsive">
				<table border="1"
					style="width: 550; height: 65; padding: 0; border-spacing: 0;"
					class="table table-hover">
					<tr>
						<th style="width: 49">Nro. RUC</th>
						<th style="width: 200">Razón Social</th>
						<th style="width: 107">Tipo</th>
						<th style="width: 192">Url</th>
						<th style="width: 107">Plan Tarifario</th>
						<th style="width: 107">Acciones</th>
					</tr>
					<c:forEach var="centroFormacion" items="${listaCentroFormacion}">
						<tr>
							<td>${centroFormacion.codigo}</td>
							<td>${centroFormacion.nombre}</td>
							<td>${centroFormacion.tipoCentroFormacion.nombre}</td>
							<td>${centroFormacion.url}</td>
							<td>${centroFormacion.planTarifario.nombre}</td>
							<td><a href="#"
								onclick="editar('${centroFormacion.codigo}');">Editar</a> - <a
								href="#" onclick="eliminar('${centroFormacion.codigo}');">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
		<jsp:include page="../../include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js" type="text/javascript"
		charset="ISO-8859-1"></script>
	<script src="${contextPath}/js/bootstrap.js" type="text/javascript"
		charset="ISO-8859-1"></script>
	<script src="${contextPath}/js/app/mantenimientoCentroFormacion.js"
		type="text/javascript" charset="ISO-8859-1"></script>
</body>
</html>