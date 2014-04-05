package gestores.constante;

import gestores.enums.TipoDocumento;

/**
 * @author Harry Bravo.
 */
public class GeneralConstante {

	private GeneralConstante() {
	}

	public static final String ERROR_GENERAL = "Hubo un error en el sistema. Contáctese con el administrador.";
	public static final String ERROR_CONEXION_BASE_DATOS = "No se pudo conectar con la base de datos.";

	public static final String MSJ_VALID_DNI = "El dni debe ser un número positivo de "
			+ TipoDocumento.DNI.getLongitud() + " digitos";
	public static final String MSJ_VALID_RUC = "El ruc debe ser un número positivo de "
			+ TipoDocumento.RUC.getLongitud() + " digitos";
	public static final String MSJ_VALID_PASAPORTE = "El pasaporte debe ser alfanumérico de "
			+ TipoDocumento.PASAPORTE.getLongitud() + " digitos";
	public static final String MSJ_VALID_CARNET_EXTRANJERIA = "El carnet de extranjería debe ser alfanumérico de "
			+ TipoDocumento.CARNET_EXTRANJERIA.getLongitud() + " digitos";
	public static final String MSJ_VALID_PARTIDA_NACIMIENTO = "La partida de nacimiento debe ser alfanumérico de "
			+ TipoDocumento.PARTIDA_NACIMIENTO.getLongitud() + " digitos";
}