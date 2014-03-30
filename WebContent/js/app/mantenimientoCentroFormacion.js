var crear = function() {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.action = rutaContexto + "/NuevoCentroFormacionServlet";
	document.formulario.submit();
};

var editar = function(codigo) {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.codigo.value = codigo;
	document.formulario.action = rutaContexto + "/EditaCentroFormacionServlet";
	document.formulario.submit();
};

var eliminar = function(codigo) {
	if (confirm("¿Está seguro que desea eliminar?")) {
		var rutaContexto = document.formulario.rutaContexto.value;
		document.formulario.codigo.value = codigo;
		document.formulario.action = rutaContexto
				+ "/EliminaCentroFormacionServlet";
		document.formulario.submit();
	}
};

var regresar = function() {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.action = rutaContexto + "/InicioCentroFormacionServlet";
	document.formulario.submit();
};