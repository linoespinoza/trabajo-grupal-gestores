<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Jeremías Yalta">
<meta name="description" content="Página de mantenimiento de usuario">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<jsp:include page="../../include/cabecera.jsp" flush="true" />
	<div class="container">
		<p>
			<strong>Mantenimiento de Usuario &gt; Búsqueda</strong>
		</p>
		<span style="color: red;">${mensaje}</span>
		<form name="formulario" method="post"
			action="${contextPath}/BusquedaUsuarioServlet"
			class="form-horizontal">
			<input type="hidden" id="rutaContexto" value="${contextPath}">
			<input type="hidden" id="codigo" name="codigo">
			<p>
				<label> <select name="codigoFiltro">
						<c:forEach var="filtroBusqueda" items="${listaFiltroBusqueda}">
							<c:choose>
								<c:when test="${filtroBusqueda.codigo eq codigoFiltro}">
									<option value="${filtroBusqueda.codigo}" selected="selected">${filtroBusqueda.nombre}</option>
								</c:when>
								<c:otherwise>
									<option value="${filtroBusqueda.codigo}">${filtroBusqueda.nombre}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select>
				</label> <label><input type="text" name="nombre"
					value="${usuario.nombre}"></label> Tipo <label> <select
					name="tipo">
						<option value="">Todos</option>
						<c:forEach var="tipoUsuario" items="${listaTipoUsuario}">
							<c:choose>
								<c:when
									test="${tipoUsuario.codigo eq usuario.tipoUsuario.codigo}">
									<option value="${tipoUsuario.codigo}" selected="selected">${tipoUsuario.nombre}</option>
								</c:when>
								<c:otherwise>
									<option value="${tipoUsuario.codigo}">${tipoUsuario.nombre}</option>
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
						<th style="width: 192">Nombre</th>
						<th style="width: 107">Tipo Documento</th>
						<th style="width: 107">Nro. Documento</th>
						<th style="width: 192">E-mail</th>
						<th style="width: 107">Nro. Celular</th>
						<th style="width: 107">Tipo Usuario</th>
						<th style="width: 192">Centro Formación</th>
						<th style="width: 107">Acciones</th>
					</tr>
					<c:forEach var="usuario" items="${listaUsuario}">
						<tr>
							<td>${usuario.nombreCompleto}</td>
							<td>${usuario.tipoDocumento.nombre}</td>
							<td>${usuario.numeroDocumento}</td>
							<td>${usuario.email}</td>
							<td>${usuario.numeroCelular}</td>
							<td>${usuario.tipoUsuario.nombre}</td>
							<td>${usuario.centroFormacion.nombre}</td>
							<td><a href="javascript: void(0);"
								onclick="editar('${usuario.codigo}');">Editar</a> - <a
								href="javascript: void(0);"
								onclick="eliminar('${usuario.codigo}');">Eliminar</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
		<jsp:include page="../../include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
	<script src="${contextPath}/js/app/mantenimientoUsuario.js"></script>
</body>
</html>