$(function(){
	if ($('#formIdea').length > 0) {
		$('#formIdea').validate({
	        rules: {
	            titulo: {
	            	required: true
	            },
	            descripcion: {
	                required: true
	            },
	            palabraClave1: {
	            	required: true
	            },
	            palabraClave2: {
	            	required: true
	            },
	            palabraClave3: {
	            	required: true
	            },
	            palabraClave4: {
	            	required: true
	            }
	        },
	        messages: {
	            titulo: {
	                required: "Debe ingresar un título"
	            },
	            descripcion: {
	                required: "Debe ingresar una descripción"
	            },
	            palabraClave1: {
	            	required: "Debe ingresar una palabra clave"
	            },
	            palabraClave2: {
	            	required: "Debe ingresar una palabra clave"
	            },
	            palabraClave3: {
	            	required: "Debe ingresar una palabra clave"
	            },
	            palabraClave4: {
	            	required: "Debe ingresar una palabra clave"
	            }
	        },
	        highlight: function(element) {
	            $(element).closest('.form-group').addClass('has-error');
	        },
	        unhighlight: function(element) {
	            $(element).closest('.form-group').removeClass('has-error');
	        }
	    });
	}
});


var crear = function() {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.action = rutaContexto + "/NuevoIdeaServlet";
	document.formulario.submit();
};

var editar = function(codigo) {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.codigo.value = codigo;
	document.formulario.action = rutaContexto + "/EditaIdeaServlet";
	
	//console.log(rutaContexto);
	document.formulario.submit();
};

var eliminar = function(codigo) {
	if (confirm("¿Está seguro que desea eliminar el registro?")) {
		var rutaContexto = document.formulario.rutaContexto.value;
		document.formulario.codigo.value = codigo;
		document.formulario.action = rutaContexto
				+ "/EliminaIdeaServlet";
		document.formulario.submit();
	}
};

var regresar = function() {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.action = rutaContexto + "/InicioIdeaServlet";
	document.formulario.submit();
};