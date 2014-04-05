<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Harry Bravo">
<meta name="description" content="Página de nuevo centro de formación">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<jsp:include page="../../include/cabecera.jsp" flush="true" />
	<div class="container">
			<h3>Mantenimiento de Idea | Nuevo</h3>
			<form name="formulario" role="form" method="post" action="${contextPath}/InsertaIdeaServlet">
				<div class="form-group">
					<label for="titulo">Título</label>
					<input type="text" class="form-control" id="titulo" name="titulo" />
				</div>
				<div class="form-group">
					<label for="descripcion">Descripción</label>
                    <textarea class="form-control" id="descripcion" name="descripcion" rows="5"></textarea>
				</div>
                <div class="form-group">
                    <label for="palabraClave1">Palabra Clave #1</label>
                    <input type="text" class="form-control" id="palabraClave1" name="palabraClave1" />
                </div>
                <div class="form-group">
                    <label for="palabraClave2">Palabra Clave #2</label>
                    <input type="text" class="form-control" id="palabraClave2" name="palabraClave2" />
                </div>
                <div class="form-group">
                    <label for="palabraClave3">Palabra Clave #3</label>
                    <input type="text" class="form-control" id="palabraClave3" name="palabraClave3" />
                </div>
                <div class="form-group">
                    <label for="palabraClave4">Palabra Clave #4</label>
                    <input type="text" class="form-control" id="palabraClave4" name="palabraClave4" />
                </div>
                <div class="form-group">
                    <label for="archivo">Archivo</label>
                    <input type="file" class="form-control" id="archivo" name="archivo" />
                    <p class="help-block">Solo se permiten archivos .jpg, .gif o .png</p>
                </div>       
				<button type="submit" class="btn btn-primary">Crear</button>
			</form>
		<jsp:include page="../../include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
	<script src="${contextPath}/js/app/mantenimiento-idea.js"></script>
</body>
</html>