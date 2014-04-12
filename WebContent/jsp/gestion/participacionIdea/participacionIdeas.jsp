 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Alex Valencia">
<meta name="description" content="Participaci&oacute;n de Ideas Publicadas">
<title>Participaci&oacute;n de Ideas Publicadas</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet" media="screen">
</head>
<body>
	<jsp:include page="/jsp/include/cabecera.jsp" flush="true" />
	<div class="container"> 
		<p><strong>Participaci&oacute;n de Ideas Publicadas &gt; Buscar</strong></p>	
		<form name="formulario" method="post" action="${contextPath}/ParticipacionIdeaServlet" class="form-horizontal">
			<p>Buscar: 
				<label>
				<input type="text" name="search" title="Solo ingrese letras o numeros, sin espacios ni caracteres especiales" 
				onkeypress="validarSoloLetras()" oncopy="return false" onpaste="return false" required autofocus>
				</label>
				<label>				
				<button type="submit" id="botonEnviar">Buscar</button>
 				</label>
 				<strong>Centro de Formaci&oacute;n : ${CENTRO}</strong>
		  	</p>
			<div class="table-responsive">
				<table border="1" width="550" height="65" border="1" cellpadding="0" cellspacing="0" class="table table-hover">
					<tr>
				   		<th width="70" scope="col">C&oacute;digo</th>
				     	<th width="70" scope="col">T&iacute;tulo</th>
				    	<th width="1000" scope="col">Descripci&oacute;n</th>
				    	<th width="1000" scope="col">Palabras Clave</th>
				    	<th width="1000" scope="col">Archivo</th>
				    	<th width="1000" scope="col">Estudiante</th>
				    	<th width="350" scope="col">Estado de la Idea</th>
<!-- 				    	<th width="550" scope="col">Fecha Creaci&oacute;n</th> -->
				    	<th width="550" scope="col">Fecha Publicaci&oacute;n</th>
<!-- 				    	<th width="1000" scope="col">Asesor</th>	 		  -->
						<th width="110' scope="col">Acciones</th>
		 			</tr>
			  		<c:forEach items="${ParticipacionIdeas}" var="participacion">
						<tr>
							<td>${participacion.codigo}</td>
							<td>${participacion.titulo}</td>
							<td>${participacion.descripcion}</td>
							<td>${participacion.palabrasClave}</td>
							<td>${participacion.archivo}</td>
							<td>${participacion.estadoIdea.getNombre()}</td> 
							<td>${participacion.estudiante.getNombre()} ${participacion.estudiante.getApellidoPaterno()} ${participacion.estudiante.getApellidoMaterno()}</td>
<%-- 							<td>${idea.fechaCreacion}</td> --%>
							<td>${participacion.fechaPublicacion}</td>
<%-- 							<td>${idea.asesor.getNombre()} ${idea.asesor.getApellidoPaterno()} ${idea.asesor.getApellidoMaterno()}</td> --%>
							<td><a href="javascript: void(0);"
								onclick="participar();">Participar</a>
<!-- 							<td><a href="javascript: void(0);" 
								onclick="participar('${idea.codigo}');">Participar</a> -->
						</tr>
					</c:forEach>
				</table>
				<p>&nbsp;</p>
			</div>
		</form>
		<%
		String msg = (String)request.getAttribute("MENSAJE");
		if (msg != null) {
			out.println(msg);
		}
		%>
		<jsp:include page="/jsp/include/pie.jsp" flush="true" />
	</div>
	<script src="${contextPath}/js/jquery-2.1.0.js"></script>
	<script src="${contextPath}/js/bootstrap.js"></script>
	<script src="${contextPath}/js/app/participacionIdea.js"></script>
</body>

</html>