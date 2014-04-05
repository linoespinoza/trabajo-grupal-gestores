var inicializar = function() {
	var sexoUsuario = document.formulario.sexoUsuario.value;
	var radioSexo = document.formulario.sexo;

	if (sexoUsuario == "") {
		radioSexo[0].checked = true;
	} else {
		for (var index = 0; index < radioSexo.length; index++) {
			if (radioSexo[index].value == sexoUsuario) {
				radioSexo[index].checked = true;
				break;
			}
		}
	}
	iniciarCambioLongitud();
	iniciarOcultaCentroFormacion();
};

var iniciarCambioLongitud = function() {
	var tipoDocumento = document.formulario.tipoDocumento;
	var numeroDocumento = document.formulario.numeroDocumento;

	if (tipoDocumento.value == "") {
		numeroDocumento.readOnly = true;
	} else {
		numeroDocumento.readOnly = false;
		numeroDocumento.maxLength = tipoDocumento.options[tipoDocumento.selectedIndex].dataset.longitud;
	}
};

var cambiarLongitud = function() {
	var tipoDocumento = document.formulario.tipoDocumento;
	var numeroDocumento = document.formulario.numeroDocumento;

	numeroDocumento.value = "";
	if (tipoDocumento.value == "") {
		numeroDocumento.readOnly = true;
	} else {
		numeroDocumento.readOnly = false;
		numeroDocumento.maxLength = tipoDocumento.options[tipoDocumento.selectedIndex].dataset.longitud;
	}
};

var iniciarOcultaCentroFormacion = function() {
	var centroFormacionTr = document.getElementById("centroFormacionTr");
	var centroFormacion = document.formulario.centroFormacion;
	var tipoUsuario = document.formulario.tipoUsuario;

	if (tipoUsuario.value == "" || tipoUsuario.value == "ADM") {
		centroFormacionTr.style.display = "none";
		centroFormacion.required = false;
	} else {
		centroFormacionTr.style.display = "";
		centroFormacion.required = true;
	}
};

var ocultarCentroFormacion = function() {
	var centroFormacionTr = document.getElementById("centroFormacionTr");
	var centroFormacion = document.formulario.centroFormacion;
	var tipoUsuario = document.formulario.tipoUsuario;

	centroFormacion.value = "";
	if (tipoUsuario.value == "" || tipoUsuario.value == "ADM") {
		centroFormacionTr.style.display = "none";
		centroFormacion.required = false;
	} else {
		centroFormacionTr.style.display = "";
		centroFormacion.required = true;
	}
};

var crear = function() {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.action = rutaContexto + "/NuevoUsuarioServlet";
	document.formulario.submit();
};

var editar = function(codigo) {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.codigo.value = codigo;
	document.formulario.action = rutaContexto + "/EditaUsuarioServlet";
	document.formulario.submit();
};

var eliminar = function(codigo) {
	if (confirm("¿Está seguro que desea eliminar el registro?")) {
		var rutaContexto = document.formulario.rutaContexto.value;
		document.formulario.codigo.value = codigo;
		document.formulario.action = rutaContexto + "/EliminaUsuarioServlet";
		document.formulario.submit();
	}
};

var regresar = function() {
	var rutaContexto = document.formulario.rutaContexto.value;
	document.formulario.action = rutaContexto + "/InicioUsuarioServlet";
	document.formulario.submit();
};