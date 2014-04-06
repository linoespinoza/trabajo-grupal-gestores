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
<meta name="description" content="Página de evaluación de idea">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<jsp:include page="../../include/cabecera.jsp" flush="true" />
	<div class="container">
		<p>
			<strong>Evaluación de Idea &gt; Evaluar</strong>
		</p>
		<span style="color: red;">${mensaje}</span>

		<c:set var="accion" value="/ApruebaIdeaServlet" />
		<c:if test="${idea.aprobada}">
			<c:set var="accion" value="/AsignaAsesorServlet" />
		</c:if>

		<form name="formulario" method="post" action="${contextPath}${accion}"
			class="form-horizontal">
			<input type="hidden" name="rutaContexto" value="${contextPath}">
			<table border="1"
				style="width: 500; height: 104; padding: 0; border-spacing: 0;">
				<tr>
					<td style="width: 160px">Título</td>
					<td>${idea.titulo}</td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Descripción</td>
					<td>${idea.descripcion}</td>
				</tr>
				<tr>
					<td>Palabras Clave</td>
					<td>${idea.palabrasClave}</td>
				</tr>
				<tr>
					<td>Archivo</td>
					<td><a
						href="${contextPath}${directorioArchivo}/${idea.archivo}"
						target="_blank">${idea.archivo}</a></td>
				</tr>
				<tr>
					<td>Estudiante</td>
					<td>${idea.estudiante.nombreCompleto}</td>
				</tr>
				<tr>
					<td>Fecha de Creación</td>
					<td><fmt:formatDate value="${idea.fechaCreacion}"
							pattern="dd/MM/yyyy HH:mm" /></td>
				</tr>
				<c:if test="${idea.aprobada}">
					<tr>
						<td>Asesor</td>
						<td><label> <select name="asesor" required="required">
									<option value="">-- Seleccione --</option>
									<c:forEach var="asesor" items="${listaDocente}">
										<option value="${asesor.codigo}">${asesor.nombreCompleto}</option>
									</c:forEach>
							</select>
						</label></td>
					</tr>
				</c:if>
				<tr>
					<td style="vertical-align: top;">Votación</td>
					<td>
						<table border="1" style="width: 100%;">
							<tr>
								<td>Puntaje</td>
								<td>Cantidad Usuarios</td>
							</tr>
							<c:forEach var="puntaje" items="${listaPuntaje}">
								<tr>
									<td>${puntaje.valorPuntaje}</td>
									<td>${puntaje.cantidadUsuarios}</td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2"><c:if test="${idea.publicada}">
							<label><input type="submit" value="Aprobar"></label>
							<label><input type="button" value="Rechazar"
								onclick="rechazar();"></label>
						</c:if> <c:if test="${idea.aprobada}">
							<label><input type="submit" value="Asignar"></label>
						</c:if> <label><input type="button" value="Regresar"
							onclick="regresar();"></label></td>
				</tr>
			</table>
			<p>&nbsp;</p>
		</form>
		<jsp:include page="../../include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
	<script src="${contextPath}/js/app/evaluacionIdea.js"></script>
</body>
</html>