<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Jeremías Yalta">
<meta name="description" content="Página de nuevo usuario">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
</head>
<body onload="inicializar();">
	<jsp:include page="../../include/cabecera.jsp" flush="true" />
	<div class="container">
		<p>
			<strong>Mantenimiento de Usuario &gt; Nuevo</strong>
		</p>
		<span style="color: red;">${mensaje}</span>
		<form name="formulario" method="post"
			action="${contextPath}/InsertaUsuarioServlet" class="form-horizontal">
			<input type="hidden" name="rutaContexto" value="${contextPath}">
			<input type="hidden" name="sexoUsuario" value="${usuario.sexo}">
			<table border="1"
				style="width: 500; height: 104; padding: 0; border-spacing: 0;">
				<tr>
					<td style="width: 160px">Nombre</td>
					<td><label> <input type="text" name="nombre"
							value="${usuario.nombre}" style="width: 200px"
							required="required" maxlength="20">
					</label></td>
				</tr>
				<tr>
					<td>Apellido Paterno</td>
					<td><label> <input type="text" name="apellidoPaterno"
							value="${usuario.apellidoPaterno}" style="width: 200px"
							required="required" maxlength="20">
					</label></td>
				</tr>
				<tr>
					<td>Apellido Materno</td>
					<td><label> <input type="text" name="apellidoMaterno"
							value="${usuario.apellidoMaterno}" style="width: 200px"
							required="required" maxlength="20">
					</label></td>
				</tr>
				<tr>
					<td>Sexo</td>
					<td><label> <input type="radio" name="sexo" value="M">
							Masculino
					</label><label> <input type="radio" name="sexo" value="F">
							Femenino
					</label></td>
				</tr>
				<tr>
					<td>Tipo de Documento</td>
					<td><label> <select name="tipoDocumento"
							required="required" onchange="cambiarLongitud();">
								<option value="">-- Seleccione --</option>
								<c:forEach var="tipoDocumento" items="${listaTipoDocumento}">
									<c:choose>
										<c:when
											test="${tipoDocumento.codigo eq usuario.tipoDocumento.codigo}">
											<option value="${tipoDocumento.codigo}"
												data-longitud="${tipoDocumento.longitud}"
												selected="selected">${tipoDocumento.nombre}</option>
										</c:when>
										<c:otherwise>
											<option value="${tipoDocumento.codigo}"
												data-longitud="${tipoDocumento.longitud}">${tipoDocumento.nombre}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select>
					</label></td>
				</tr>
				<tr>
					<td>Nro. Documento</td>
					<td><label> <input type="text" name="numeroDocumento"
							value="${usuario.numeroDocumento}" style="width: 150px"
							required="required">
					</label></td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><label> <input type="email" name="email"
							value="${usuario.email}" style="width: 320px" required="required"
							maxlength="45">
					</label></td>
				</tr>
				<tr>
					<td>Nro. Celular</td>
					<td><label> <input type="text" name="numeroCelular"
							value="${usuario.numeroCelular}" style="width: 150px"
							required="required" maxlength="9">
					</label></td>
				</tr>
				<tr>
					<td>Contraseña</td>
					<td><label> <input type="password" name="contrasenia"
							value="${usuario.contrasenia}" style="width: 150px"
							required="required" maxlength="12">
					</label></td>
				</tr>
				<tr>
					<td>Tipo de Usuario</td>
					<td><label> <select name="tipoUsuario"
							required="required" onchange="ocultarCentroFormacion();">
								<option value="">-- Seleccione --</option>
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
					</label></td>
				</tr>
				<tr id="centroFormacionTr">
					<td>Centro de Formación</td>
					<td><label> <select name="centroFormacion">
								<option value="">-- Seleccione --</option>
								<c:forEach var="centroFormacion" items="${listaCentroFormacion}">
									<c:choose>
										<c:when
											test="${centroFormacion.codigo eq usuario.centroFormacion.codigo}">
											<option value="${centroFormacion.codigo}" selected="selected">${centroFormacion.nombre}</option>
										</c:when>
										<c:otherwise>
											<option value="${centroFormacion.codigo}">${centroFormacion.nombre}</option>
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
	<script src="${contextPath}/js/app/mantenimientoUsuario.js"></script>
</body>
</html>