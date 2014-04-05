var obtener = function(codigo) {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.codigo.value = codigo;
	document.formulario.action = rutaContexto + "/ObtieneEvaluacionIdeaServlet";
	document.formulario.submit();
};

var rechazar = function(codigo) {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.action = rutaContexto + "/RechazaIdeaServlet";
	document.formulario.submit();
};

var regresar = function() {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.action = rutaContexto + "/InicioEvaluacionIdeaServlet";
	document.formulario.submit();
};