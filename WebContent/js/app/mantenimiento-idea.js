var crear = function() {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.action = rutaContexto + "/NuevoIdeaServlet";
	document.formulario.submit();
};

var editar = function(codigo) {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.codigo.value = codigo;
	document.formulario.action = rutaContexto + "/EditaIdeaServlet";
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