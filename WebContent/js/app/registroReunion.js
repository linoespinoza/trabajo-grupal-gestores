var crear = function() {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.action = rutaContexto + "/NuevoReunionServlet";
	document.formulario.submit();
};

var regresar = function() {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.action = rutaContexto + "/InicioReunionServlet";
	document.formulario.submit();
};