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
<meta name="description" content="Pagina principal">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<jsp:include page="include/cabecera.jsp" flush="true" />
	<div class="container">
		<div class="jumbotron">
			<h4>
				Bienvenido <b>${usuarioActual.nombre}
					${usuarioActual.apellidoPaterno} ${usuarioActual.apellidoMaterno}</b>
			</h4>
		</div>
		<c:if
			test="${usuarioActual.estudiante or usuarioActual.administrador}">
			<div class="row">
				<c:if test="${usuarioActual.estudiante}">
					<div class="col-lg-4">
						<h4>Mantenimiento de Ideas</h4>
						<p>Desde esta opción usted podrá crear, modificar, buscar y
							eliminar las ideas.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.administrador}">
					<div class="col-lg-4">
						<h4>Mantenimiento de Centros de Formación</h4>
						<p>Desde esta opción usted podrá crear, modificar, buscar y
							eliminar los centros de formación.</p>
						<p>
							<a href="${contextPath}/InicioCentroFormacionServlet"
								class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>

					<div class="col-lg-4">
						<h4>Mantenimiento de Usuarios</h4>
						<p>Desde esta opción usted podrá crear, modificar, buscar y
							eliminar los usuarios.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
			</div>
		</c:if>
		<c:if test="${not usuarioActual.administrador}">
			<div class="row">
				<c:if
					test="${usuarioActual.estudiante or usuarioActual.docente or usuarioActual.evaluador}">
					<div class="col-lg-4">
						<h4>Consulta de Ideas</h4>
						<p>Desde esta opción usted podrá consultar las ideas.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.docente}">
					<div class="col-lg-4">
						<h4>Registro de Reuniones</h4>
						<p>Desde esta opción usted podrá registrar las reuniones.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.estudiante}">
					<div class="col-lg-4">
						<h4>Publicación de Ideas</h4>
						<p>Desde esta opción usted podrá publicar las ideas.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.estudiante or usuarioActual.docente}">
					<div class="col-lg-4">
						<h4>Participación de Ideas</h4>
						<p>Desde esta opción usted podrá participar de las ideas.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.evaluador}">
					<div class="col-lg-4">
						<h4>Evaluación de Ideas</h4>
						<p>Desde esta opción usted podrá evaluar las ideas.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
			</div>
		</c:if>
		<c:if test="${usuarioActual.evaluador or usuarioActual.administrador}">
			<div class="row">
				<c:if test="${usuarioActual.evaluador}">
					<div class="col-lg-4">
						<h4>Reporte de Ideas</h4>
						<p>Desde esta opción usted podrá ver el reporte de las ideas.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.administrador}">
					<div class="col-lg-4">
						<h4>Pagos de Centros de Formación</h4>
						<p>Desde esta opción usted podrá consultar los pagos de los
							centros de formación.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
			</div>
		</c:if>
		<jsp:include page="include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js" type="text/javascript"
		charset="ISO-8859-1"></script>
	<script src="${contextPath}/js/bootstrap.js" type="text/javascript"
		charset="ISO-8859-1"></script>
</body>
</html>