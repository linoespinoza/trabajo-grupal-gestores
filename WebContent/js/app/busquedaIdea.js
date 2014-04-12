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
		