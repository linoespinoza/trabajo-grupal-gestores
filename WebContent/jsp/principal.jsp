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
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<div class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextPath}/PortadaServlet">Sistema
					de Gestión de Innovación</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${contextPath}/PortadaServlet">Inicio</a></li>
					<c:if
						test="${usuarioActual.estudiante or usuarioActual.administrador}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Mantenimiento</a>
							<ul class="dropdown-menu">
								<c:if test="${usuarioActual.estudiante}">
									<li><a href="#">Ideas</a></li>
								</c:if>
								<c:if test="${usuarioActual.administrador}">
									<li><a href="#">Centros de Formación</a></li>
									<li><a href="#">Usuarios</a></li>
								</c:if>
							</ul></li>
					</c:if>
					<c:if test="${not usuarioActual.administrador}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Gestión</a>
							<ul class="dropdown-menu">
								<c:if
									test="${usuarioActual.estudiante or usuarioActual.docente or usuarioActual.evaluador}">
									<li><a href="#">Consulta de Ideas</a></li>
								</c:if>
								<c:if test="${usuarioActual.docente}">
									<li><a href="#">Registro de Reuniones</a></li>
								</c:if>
								<c:if test="${usuarioActual.estudiante}">
									<li><a href="#">Publicación de Ideas</a></li>
								</c:if>
								<c:if
									test="${usuarioActual.estudiante or usuarioActual.docente}">
									<li><a href="#">Participación de Ideas</a></li>
								</c:if>
								<c:if test="${usuarioActual.evaluador}">
									<li><a href="#">Evaluación de Ideas</a></li>
								</c:if>
							</ul></li>
					</c:if>
					<c:if
						test="${usuarioActual.evaluador or usuarioActual.administrador}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Reporte</a>
							<ul class="dropdown-menu">
								<c:if test="${usuarioActual.evaluador}">
									<li><a href="#">Ideas</a></li>
								</c:if>
								<c:if test="${usuarioActual.administrador}">
									<li><a href="#">Pagos de Centro de Formación</a></li>
								</c:if>
							</ul></li>
					</c:if>
					<li><a href="${contextPath}/LogoutServlet">Salir</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="jumbotron">
			<h4>
				Bienvenido <b>${sessionScope.usuarioActual.nombre}
					${sessionScope.usuarioActual.apellidoPaterno}
					${sessionScope.usuarioActual.apellidoMaterno}</b>
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
							<a class="btn btn-primary" href="#">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.administrador}">
					<div class="col-lg-4">
						<h4>Mantenimiento de Centros de Formación</h4>
						<p>Desde esta opción usted podrá crear, modificar, buscar y
							eliminar los centros de formación.</p>
						<p>
							<a class="btn btn-primary" href="#">Ver detalles &raquo;</a>
						</p>
					</div>

					<div class="col-lg-4">
						<h4>Mantenimiento de Usuarios</h4>
						<p>Desde esta opción usted podrá crear, modificar, buscar y
							eliminar los usuarios.</p>
						<p>
							<a class="btn btn-primary" href="#">Ver detalles &raquo;</a>
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
							<a class="btn btn-primary" href="#">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.docente}">
					<div class="col-lg-4">
						<h4>Registro de Reuniones</h4>
						<p>Desde esta opción usted podrá registrar las reuniones.</p>
						<p>
							<a class="btn btn-primary" href="#">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.estudiante}">
					<div class="col-lg-4">
						<h4>Publicación de Ideas</h4>
						<p>Desde esta opción usted podrá publicar las ideas.</p>
						<p>
							<a class="btn btn-primary" href="#">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.estudiante or usuarioActual.docente}">
					<div class="col-lg-4">
						<h4>Participación de Ideas</h4>
						<p>Desde esta opción usted podrá participar de las ideas.</p>
						<p>
							<a class="btn btn-primary" href="#">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.evaluador}">
					<div class="col-lg-4">
						<h4>Evaluación de Ideas</h4>
						<p>Desde esta opción usted podrá evaluar las ideas.</p>
						<p>
							<a class="btn btn-primary" href="#">Ver detalles &raquo;</a>
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
							<a class="btn btn-primary" href="#">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.administrador}">
					<div class="col-lg-4">
						<h4>Pagos de Centros de Formación</h4>
						<p>Desde esta opción usted podrá consultar los pagos de los
							centros de formación.</p>
						<p>
							<a class="btn btn-primary" href="#">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
			</div>
		</c:if>
		<div class="footer">
			<p>&nbsp;</p>
			<p>&copy; Gestores 2014</p>
		</div>
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
</body>
</html>