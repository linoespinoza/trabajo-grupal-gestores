/**
 * @author Alex VAlencia 
 */
var validarSoloNumeros = function() {
	if ((event.keyCode < 48) || (event.keyCode > 57)) 
		event.returnValue = false;
};
var validarSoloLetras = function() {
	if (((event.keyCode > 0) && (event.keyCode < 65)) || ((event.keyCode > 122) && (event.keyCode < 127))){
		 alert('No ingrese numeros ni caracteres especiales');
		 event.returnValue = false;
	 }
};

//var participar = function(codigo) {
var participar = function() {
	var rutaContexto = document.formulario.rutaContexto.value;
	//document.formulario.codigo.value = codigo;
	document.formulario.action = rutaContexto + "/VotacionIdeaServlet";
	document.formulario.submit();
};

var regresar = function() {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.action = rutaContexto + "/InicioParticipacionServlet";
	document.formulario.submit();
};