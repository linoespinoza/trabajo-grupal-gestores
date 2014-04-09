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
		<p><strong>Reporte  &gt; Pagos Centro de Formación</strong></p>
		<span style="color: red;">${mensaje}</span>
		<form id="form1" name="form1" method="post" action="${contextPath}/GenerarReportePagosServlet" class="form-horizontal" >
			<p> 
				Nombre <label><input type="text" name="nombre" value="${nombre}"/></label>
				Tipo <label> 
					<select	name="tipo">
						<option value="">Todos</option>
						<c:forEach var="tipoCentroFormacion"
							items="${listaTipoCentroFormacion}">
							<c:choose>
								<c:when
									test="${tipoCentroFormacion.codigo eq centroFormacion.tipoCentroFormacion.codigo}">
									<option value="${tipoCentroFormacion.codigo}" selected="selected">${tipoCentroFormacion.nombre}</option>
								</c:when>
								<c:otherwise>
									<option value="${tipoCentroFormacion.codigo}">${tipoCentroFormacion.nombre}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</label>
			</p>
  			<p>
  				<!-- Mes <label><input type="month" name="mes"></label> -->
  				Mes <label> 
  						<select class="form-control" name="mes" >
		  					<option value="">Todos</option>
		  					<option value="Enero">Enero</option>
  							<option value="Febrero">Febrero</option>
  							<option value="Marzo">Marzo</option>
  							<option value="Abril">Abril</option>
  							<option value="Mayo">Mayo</option>
  							<option value="Junio">Junio</option>
  							<option value="Julio">Julio</option>
  							<option value="Agosto">Agosto</option>
  							<option value="Setiembre">Setiembre</option>
  							<option value="Octubre">Octubre</option>
  							<option value="Noviembre">Noviembre</option>
  							<option value="Diciembre">Diciembre</option>
  						</select>
  					</label>
  				Año <label><input type="number" min="2010" max="2050" step="1" name="anio"></label>
  				<label><input type="submit" name="button" id="button" value="Buscar" /></label>
  		</form>
		<div class="table-responsive">
		<table border="1" style="width: 800; height: 20; padding: 0; border-spacing: 0;" class="table table-hover">
		  <tr>
		    <th width="300" scope="col">Nombre</th>
		    <th width="80" scope="col" style="text-align: center;">Tipo</th>
		    <th width="120" scope="col" style="text-align: center;">Plan Tarifario</th>
		    <th width="90" scope="col" style="text-align: center;">Mes de Pago</th>
		    <th width="70" scope="col"style="text-align: center;">Año</th>
		    <th style="text-align: center;" width="100" scope="col">Monto Mensual(S/.)</th>
		  </tr>
			<c:forEach var="pago" items="${listaReportePagos}">
						<tr>
							<td>${pago.centroFormacion.nombre}</td>
						 	<td align="center">${pago.centroFormacion.tipoCentroFormacion.nombre}</td>
							<td align="center">${pago.planTarifario.nombre}</td>
							<td align="center">${pago.mesPago}</td>
							<td align="center">${pago.anioPago}</td>
							<td align="right">${pago.montoMensual}</td>
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