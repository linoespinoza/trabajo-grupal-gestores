<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Página de Nueva Idea">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="${contextPath}/css/app/comun.css" rel="stylesheet" media="screen">
</head>
<body>
	<jsp:include page="../../include/cabecera.jsp" flush="true" />
	<div class="container">
		<form id="formIdea" name="formulario" role="form" method="post" action="${contextPath}/InsertaIdeaServlet" 
        enctype="multipart/form-data">
            <legend>Mantenimiento de Idea | Nuevo</legend>
            
            <fieldset>
                <c:forEach items="${requestScope.mensaje}" var="value" varStatus="i">
                    <p>${value}</p>
            </c:forEach>
            </fieldset>
            
            <input type="hidden" name="rutaContexto" value="${contextPath}">
            <div class="form-group">
				<label for="titulo">Título de la Idea</label>
				<input type="text" class="form-control" id="titulo" name="titulo" value="${idea.titulo}" />
			</div>
			<div class="form-group">
				<label for="descripcion">Descripción de la Idea</label>
                <textarea class="form-control" id="descripcion" name="descripcion" rows="5">${idea.descripcion}</textarea>
			</div>
            <div class="form-group">
                <label for="palabraClave1">Palabra Clave #1</label>
                <c:set var="palabrasClavePartes" value="${fn:split(idea.palabrasClave, ',')}" />
                <input type="text" class="form-control" id="palabraClave1" name="palabraClave1" value="${palabrasClavePartes[0]}" />
            </div>
            <div class="form-group">
                <label for="palabraClave2">Palabra Clave #2</label>
                <input type="text" class="form-control" id="palabraClave2" name="palabraClave2" value="${palabrasClavePartes[1]}"/>
            </div>
            <div class="form-group">
                <label for="palabraClave3">Palabra Clave #3</label>
                <input type="text" class="form-control" id="palabraClave3" name="palabraClave3" value="${palabrasClavePartes[2]}" />
            </div>
            <div class="form-group">
                <label for="palabraClave4">Palabra Clave #4</label>
                <input type="text" class="form-control" id="palabraClave4" name="palabraClave4" value="${palabrasClavePartes[3]}"/>
            </div>
            <div class="form-group">
                <label for="archivo">Adjunte un archivo</label>
                <input type="file" class="form-control" id="archivo" name="archivo" />
                <p class="help-block"></p>
            </div>       
			<button type="submit" class="btn btn-primary">Crear</button>
		</form>
		<jsp:include page="../../include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
    <script src="${contextPath}/js/jquery.validate.min.js"></script>
	<script src="${contextPath}/js/app/mantenimiento-idea.js" charset="utf-8"></script>
</body>
</html>