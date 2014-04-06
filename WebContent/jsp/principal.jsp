<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Harry Bravo">
<meta name="description" content="P�gina principal">
<title>Sistema de Gesti�n de Innovaci�n</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<jsp:include page="include/cabecera.jsp" flush="true" />
	<div class="container">
		<div class="jumbotron">
			<h4>
				Bienvenido <b>${usuarioActual.nombreCompleto}</b> <br> Tipo de
				usuario: <b>${usuarioActual.tipoUsuario.nombre}</b><br>
				<c:if test="${not empty usuarioActual.centroFormacion.nombre}">
					Centro de formaci�n: <b>${usuarioActual.centroFormacion.nombre}</b>
				</c:if>
			</h4>
		</div>
		<c:if
			test="${usuarioActual.estudiante or usuarioActual.administrador}">
			<div class="row">
				<c:if test="${usuarioActual.estudiante}">
					<div class="col-lg-4">
						<h4>Mantenimiento de Ideas</h4>
						<p>Desde esta opci�n usted podr� crear, modificar, buscar y
							eliminar las ideas.</p>
						<p>
							<a href="${contextPath}/InicioIdeaServlet"
								class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.administrador}">
					<div class="col-lg-4">
						<h4>Mantenimiento de Centros de Formaci�n</h4>
						<p>Desde esta opci�n usted podr� crear, modificar, buscar y
							eliminar los centros de formaci�n.</p>
						<p>
							<a href="${contextPath}/InicioCentroFormacionServlet"
								class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>

					<div class="col-lg-4">
						<h4>Mantenimiento de Usuarios</h4>
						<p>Desde esta opci�n usted podr� crear, modificar, buscar y
							eliminar los usuarios.</p>
						<p>
							<a href="${contextPath}/InicioUsuarioServlet"
								class="btn btn-primary">Ver detalles &raquo;</a>
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
						<h4>B�squeda de Ideas</h4>
						<p>Desde esta opci�n usted podr� consultar las ideas.</p>
						<p>
							<a href="${contextPath}/InicioBusquedaIdeaServlet"
								class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.docente}">
					<div class="col-lg-4">
						<h4>Registro de Reuniones</h4>
						<p>Desde esta opci�n usted podr� registrar las reuniones.</p>
						<p>
							<a href="${contextPath}/InicioReunionServlet"
								class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.estudiante}">
					<div class="col-lg-4">
						<h4>Publicaci�n de Ideas</h4>
						<p>Desde esta opci�n usted podr� publicar las ideas.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.estudiante or usuarioActual.docente}">
					<div class="col-lg-4">
						<h4>Participaci�n de Ideas</h4>
						<p>Desde esta opci�n usted podr� participar de las ideas.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.evaluador}">
					<div class="col-lg-4">
						<h4>Evaluaci�n de Ideas</h4>
						<p>Desde esta opci�n usted podr� evaluar las ideas.</p>
						<p>
							<a href="${contextPath}/InicioEvaluacionIdeaServlet"
								class="btn btn-primary">Ver detalles &raquo;</a>
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
						<p>Desde esta opci�n usted podr� ver el reporte de las ideas.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
				<c:if test="${usuarioActual.administrador}">
					<div class="col-lg-4">
						<h4>Pagos de Centros de Formaci�n</h4>
						<p>Desde esta opci�n usted podr� consultar los pagos de los
							centros de formaci�n.</p>
						<p>
							<a href="#" class="btn btn-primary">Ver detalles &raquo;</a>
						</p>
					</div>
				</c:if>
			</div>
		</c:if>
		<jsp:include page="include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
</body>
</html>