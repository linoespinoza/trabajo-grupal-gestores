<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Marco Chumpitaz">
<meta name="description" content="Página de mantenimiento de centro de formación">
<title>Sistema de Gestión de Innovación</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet"	media="screen">
<link href="${contextPath}/css/app/comun.css" rel="stylesheet"	media="screen">
 </head>
 <body>
     <jsp:include page="../../include/cabecera.jsp" flush="true" />
	 <div class="container"> 
		<p><strong>Reporte  &gt; Ideas</strong></p>
		<span style="color: red;">${mensaje}</span>
		<form id="form1" name="form1" method="post" action="${contextPath}/GenerarReporteIdeaServlet" class="form-horizontal" >
			<p>
				<label>
		  			<select class="form-control" name="criterio" >
  						<option>Titulo</option>
  						<option>Descripcion</option>
  						<option>Palabras_clave</option>
  					</select>
  				</label>
  				<label> <input type="text" name="txtcriterio"/>	</label>
		    	Estado: <label>	
		  			<select class="form-control" name="estado">
  						<option value="">Todos</option>
						<c:forEach var="estadoIdea" items="${listaEstadoIdea}">
								<c:choose>
									<c:when
										test="${estadoIdea.codigo eq Idea.EstadoIdea.codigo}">
										<option value="${estadoIdea.codigo}"
										selected="selected">${estadoIdea.nombre}</option>
									</c:when>
									<c:otherwise>
									<option value="${estadoIdea.codigo}">${estadoIdea.nombre}
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
  					</select>
  				</label>
  			</p>
  			<p>
  				Rango de Fecha <label> <input type="date" name="desde" value="${fechaInicio}"></label>
  								<label><input type="date" name="hasta" value="${fechaFin}"></label>
  				<label><input type="submit" name="button" id="button" value="Buscar" /></label>
			</p>
		</form>
		<div class="table-responsive">
		<table border="1"
					style="width: 1300; height: 20; padding: 0; border-spacing: 0;"
					class="table table-hover">
		  <tr>
		    <th width="100" scope="col">Titulo</th>
		    <th width="350" scope="col">Descripción</th>
		    <th width="100" scope="col">Palabras claves</th>
		    <th width="100" scope="col">Archivo</th>
		    <th width="400" scope="col">Estudiante</th>
		    <th width="400" scope="col">Asesor</th>
		    <th width="100" scope="col">Estado</th>
		    <th width="150" scope="col">Fecha creación</th>
		  </tr>
			<c:forEach var="ideaN" items="${listax}">
						<tr>
						<td>${ideaN.titulo}</td>
						 	<td>${ideaN.descripcion}</td>
							<td>${ideaN.palabrasClave}</td>
							<td><a href="${contextPath}/upload/archivo/${ideaN.archivo}" target="_blank">${ideaN.archivo}</a></td>  
							<td>${ideaN.estudiante.nombre} ${ideaN.estudiante.apellidoPaterno} ${ideaN.estudiante.apellidoMaterno}</td>
							<td>${ideaN.asesor.nombre} ${ideaN.asesor.apellidoPaterno} ${ideaN.asesor.apellidoMaterno}</td>
							<td>${ideaN.estadoIdea.nombre} 
							<td>${ideaN.fechaCreacion}</td>
							
						</tr>
			</c:forEach>
		</table>
		</div>
		<jsp:include page="../../include/pie.jsp" flush="true" />
	</div> 	
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
	<script src="${contextPath}/js/app/registroReunion.js"></script>
  </body>
</html>