<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Jeremías Yalta">
<meta name="description" content="Página de nueva reunión">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<jsp:include page="../../include/cabecera.jsp" flush="true" />
	<div class="container">
		<p>
			<strong>Registro de Reunión &gt; Nuevo</strong>
		</p>
		<span style="color: red;">${mensaje}</span>
		<form name="formulario" method="post"
			action="${contextPath}/InsertaReunionServlet" class="form-horizontal">
			<input type="hidden" name="rutaContexto" value="${contextPath}">
			<table border="1"
				style="width: 500; height: 104; padding: 0; border-spacing: 0;">
				<tr>
					<td style="width: 160px">Idea</td>
					<td><label> <select name="idea" required="required">
								<option value="">-- Seleccione --</option>
								<c:forEach var="idea" items="${listaIdea}">
									<c:choose>
										<c:when test="${idea.codigo eq reunion.idea.codigo}">
											<option value="${idea.codigo}" selected="selected">${idea.titulo}</option>
										</c:when>
										<c:otherwise>
											<option value="${idea.codigo}">${idea.titulo}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></label></td>
				</tr>
				<tr>
					<td>Fecha de Reunión</td>
					<td><label> <input type="datetime-local" name="fecha"
							value="${reunion.fechaReunionFormateada}" required="required">
					</label></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Observacion</td>
					<td><label> <textarea name="observacion"
								required="required" maxlength="200" rows="3" cols="40">${reunion.observacion}</textarea>
					</label></td>
				</tr>
				<tr>
					<td>Calificación</td>
					<td><label> <select name="tipoCalificacion"
							required="required">
								<option value="">-- Seleccione --</option>
								<c:forEach var="tipoCalificacion"
									items="${listaTipoCalificacion}">
									<c:choose>
										<c:when
											test="${tipoCalificacion.codigo eq reunion.tipoCalificacion.codigo}">
											<option value="${tipoCalificacion.codigo}"
												selected="selected">${tipoCalificacion.nombre}</option>
										</c:when>
										<c:otherwise>
											<option value="${tipoCalificacion.codigo}">${tipoCalificacion.nombre}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select>
					</label></td>
				</tr>
				<tr>
					<td colspan="2"><label><input type="submit"
							value="Guardar"></label> <label><input type="button"
							value="Regresar" onclick="regresar();"></label></td>
				</tr>
			</table>
			<p>&nbsp;</p>
		</form>
		<jsp:include page="../../include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
	<script src="${contextPath}/js/app/registroReunion.js"></script>
</body>
</html>