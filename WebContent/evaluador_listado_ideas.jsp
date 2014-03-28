<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
  	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  	<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
 
  	<link rel="stylesheet" href="/resources/demos/style.css" />
 
  	<style>
	    .datepicker{
         }
  	</style>
 
  	<script>
  		$(function()  {
		    $( ".datepicker" ).datepicker({
		    	dateFormat: "yy-mm-dd",
		        firstDay: 1,
		        dayNamesMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
		        dayNamesShort: ["Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"],
		        monthNames: 
		            ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
		            "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
		        monthNamesShort: 
		            ["Ene", "Feb", "Mar", "Abr", "May", "Jun",
		            "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"]
		    });
		    }); 	
 	</script>
    
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title>SGI: Gestión de Innovación</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-3.1.1.css" rel="stylesheet" media="screen">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
        
	 <div class="container"> 

		<p><strong>Buscar Ideas</strong></p>
		
		<form id="form1" name="form1" method="post" action="EvaluadorListadoIdeasServlet" class="form-horizontal" role="form">
			<p>
				<label>
		  			<select class="form-control" name="criterio" >
  						<option>Titulo</option>
  						<option>Descripcion</option>
  						<option>Palabras_clave</option>
  					</select>
  				</label>
  				<label>
		    		<input type="text" name="txtcriterio"/>
		    	</label>
		    	<label>	Estado:
		  			<select class="form-control" name="estado">
  						<option>Todos</option>
  						<option>Creada</option>
  						<option>Publicada</option>
  						<option>Aprobada</option>
  						<option>Rechazada</option>
  					</select>
  				</label>
  			</p>
  			<p>
  				<label>
  					Fecha de creación desde	 <input type="text" class="datepicker" name="desde"/>
  				</label>
  				<label>
					hasta  <input type="text" class="datepicker" name="hasta"/>
				</label>
				<label>	  
		    		<input type="submit" name="button" id="button" value="Buscar" />   
		    	</label>
			</p>
		</form>
		<div class="table-responsive">
		<table width="1300" height="20" border="1" cellpadding="0" cellspacing="0" class="table table-hover">
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
		
		<%@page import="java.util.*, gestores.modelo.Idea" %>
		<%
		Collection<Idea> arreglo = (ArrayList<Idea>)request.getAttribute("listax");
		if(arreglo != null) { 
		int i = 1;
		for(Idea x : arreglo) {
		%>  
		  <tr>
		    <%-- <td><%=i++ %></td> --%>
		    <td><% out.print(x.getTitulo()); %></td>
		    <td><% out.print(x.getDescripcion()); %></td>
		    <td><% out.print(x.getPalabrasClave()); %></td>
		    <td><% out.print(x.getArchivo()); %></td>
		    <td><% out.print(x.getEstudiante().getNombre() + " " + x.getEstudiante().getApellidoPaterno() + " " +x.getEstudiante().getApellidoMaterno()); %></td>
		    <td><% out.print(x.getAsesor().getNombre() + " " + x.getAsesor().getApellidoPaterno() + " " +x.getAsesor().getApellidoMaterno()); %></td>
		    <td><% out.print(x.getEstadoIdea().toString()); %></td>
		    <td><% out.print(x.getFechaCreacion()); %></td>
		    
		   </tr>
		<% }  
		  } %>
		  
		</table>
		</div>

 		<!-- Site footer -->
	   <div class="footer">
	   	 <p>&nbsp;</p>
	     <p>&copy; by Marco Chumpitaz </p>
	   </div>
	   
	 </div> <!-- /container -->
    
   


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap-3.1.1.js"></script>
  </body>
</html>
