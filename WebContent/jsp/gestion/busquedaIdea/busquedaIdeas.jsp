 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Alex Valencia">
<meta name="description" content="B&uacute;squeda de Ideas por Palabras">
<title>B&uacute;squeda de Ideas por Palabras</title>
<link href="${contextPath}/css/bootstrap.css" rel="stylesheet" media="screen">
</head>
<body>
	<jsp:include page="/jsp/include/cabecera.jsp" flush="true" />
	<div class="container"> 
		<p><strong>B&uacute;squeda de Ideas &gt; Buscar</strong></p>	
		<form name="formulario" method="post" action="${contextPath}/BusquedaServlet" class="form-horizontal">
			<p>Buscar: 
				<label>
				<input type="text" name="search" title="Solo ingrese letras o numeros, sin espacios ni caracteres especiales" 
				onkeypress="validarSoloLetras()" oncopy="return false" onpaste="return false" required autofocus>
				</label>
				<label>
					<select name="state" required="required"> 
						<option value="">-- Seleccione --</option>
						<option value="APR">APROBADA</option>
						<option value="PUB">PUBLICADA</option>
						<option value="REC">RECHAZADA</option>
						<option value="*">TODAS</option>
					</select>
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
				    	<th width="550" scope="col">Fecha Creaci&oacute;n</th>
				    	<th width="550" scope="col">Fecha Publicaci&oacute;n</th>
				    	<th width="1000" scope="col">Asesor</th>	 		 
		 			</tr>
			  		<c:forEach items="${BusquedaIdeas}" var="idea">
						<tr>
							<td>${idea.codigo}</td>
							<td>${idea.titulo}</td>
							<td>${idea.descripcion}</td>
							<td>${idea.palabrasClave}</td>
							<td>${idea.archivo}</td>
							<td>${idea.estadoIdea.getNombre()}</td> 
							<td>${idea.estudiante.getNombre()} ${idea.estudiante.getApellidoPaterno()} ${idea.estudiante.getApellidoMaterno()}</td>
							<td>${idea.fechaCreacion}</td>
							<td>${idea.fechaPublicacion}</td>
							<td>${idea.asesor.getNombre()} ${idea.asesor.getApellidoPaterno()} ${idea.asesor.getApellidoMaterno()}</td>
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
	<script src="${contextPath}/js/app/busquedaIdea.js"></script>
</body>

</html>