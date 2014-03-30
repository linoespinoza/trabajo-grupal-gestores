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
<meta name="description" content="Pagina de nuevo centro de formacion">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<jsp:include page="../../include/cabecera.jsp" flush="true" />
	<div class="container">
		<p>
			<strong>Mantenimiento de Centro de Formación &gt; Nuevo</strong>
		</p>
		<span style="color: red;">${mensaje}</span>
		<form name="formulario" method="post"
			action="${contextPath}/InsertaCentroFormacionServlet"
			class="form-horizontal" enctype="multipart/form-data">
			<input type="hidden" id="rutaContexto" value="${contextPath}">
			<table border="1"
				style="width: 500; height: 104; padding: 0; border-spacing: 0;">
				<tr>
					<td style="width: 160px">Nro. RUC</td>
					<td><label> <input type="number" name="codigo"
							value="${centroFormacion.codigo}" style="width: 120px"
							required="required">
					</label></td>
				</tr>
				<tr>
					<td>Razón Social</td>
					<td><label> <input type="text" name="nombre"
							value="${centroFormacion.nombre}" style="width: 320px"
							required="required">
					</label></td>
				</tr>
				<tr>
					<td>Tipo</td>
					<td><label> <select name="tipo" required="required">
								<option value="">-- Seleccione --</option>
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
					</label></td>
				</tr>
				<tr>
					<td>Url</td>
					<td><label> <input type="url" name="url"
							value="${centroFormacion.url}" style="width: 320px"
							required="required">
					</label></td>
				</tr>
				<tr>
					<td>Plan Tarifario</td>
					<td><label> <select name="planTarifario"
							required="required">
								<option value="">-- Seleccione --</option>
								<c:forEach var="planTarifario" items="${listaPlanTarifario}">
									<c:choose>
										<c:when
											test="${planTarifario.codigo == centroFormacion.planTarifario.codigo}">
											<option value="${planTarifario.codigo}" selected="selected">${planTarifario.nombre}</option>
										</c:when>
										<c:otherwise>
											<option value="${planTarifario.codigo}">${planTarifario.nombre}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select>
					</label></td>
				</tr>
				<tr>
					<td>Logo</td>
					<td><label> <input type="file" name="logo"
							required="required">
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
	<script src="${contextPath}/js/jquery-2.1.0.js" type="text/javascript"
		charset="ISO-8859-1"></script>
	<script src="${contextPath}/js/bootstrap.js" type="text/javascript"
		charset="ISO-8859-1"></script>
	<script src="${contextPath}/js/app/mantenimientoCentroFormacion.js"
		type="text/javascript" charset="ISO-8859-1"></script>
</body>
</html>