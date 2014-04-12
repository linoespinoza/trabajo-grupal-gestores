<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Alex Valencia">
<meta name="description" content="Página de nuevo centro de formación">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"
	media="screen">
</head>
<body>
	<jsp:include page="../../include/cabecera.jsp" flush="true" />
	<div class="container">
			<h3>PARTICIPAR DE IDEA PUBLICADA</h3>
			<form name="formulario" role="form" method="post" action="${contextPath}/InsertaParticipacionServlet">
				<div class="form-group">
					<label for="titulo">Idea</label>
					<input type="text" class="form-control" id="titulo" name="titulo" value="${participacion.titulo}"  readonly/>
				</div>
				<div class="form-group">
					<label for="descripcion">Descripción</label>
                    <input class="form-control" id="descripcion" name="descripcion" value="${participacion.descripcion}"readonly/>
				</div>
                <div class="form-group">
                    <label for="archivo">Archivo</label>
                    <input type="text" class="form-control" id="archivo" name="archivo" value="${participacion.archivo}" readonly/>
                </div>
                <div class="form-group">
                    <label>Puntaje</label>
                    
		            <input type = "radio" name = "uno" id = "uno" value = "1" />
		          	<label for = "uno"> 1 </label>
		            
		            <input type = "radio" name = "dos" id = "dos" value = "2" />
		          	<label for = "dos"> 2 </label>
		          	
		            <input type = "radio" name = "tres" id = "tres" value = "3" />
		          	<label for = "uno"> 3 </label>
		          	
                    <input type = "radio" name = "cuatro" id = "cuatro" value = "4" />
		          	<label for = "uno"> 4 </label>
		          	
                    <input type = "radio" name = "cinco" id = "cinco" value = "5" />
		          	<label for = "uno"> 5 </label>
                
                </div>
                <div class="form-group">
                    <label for="comentario">Comentario</label>
                    <textarea class="form-control" id="comentario" name="comentario" rows="5" readonly></textarea>
                </div>
                <div class="form-group">
                    <label for="newcomentario">Ingresar Comentario</label>
                    <textarea class="form-control" id="newcomentario" name="newcomentario" rows="5"></textarea>
                </div>
				<button type="submit" class="btn btn-primary">Agregar Comentario</button>
				<button type="submit" class="btn btn-primary">Regresar</button>
			</form>
		<jsp:include page="../../include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
	<script src="${contextPath}/js/app/participacionIdea.js"></script>
</body>
</html>