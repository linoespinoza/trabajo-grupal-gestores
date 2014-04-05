package gestores.util;

import gestores.constante.GeneralConstante;
import gestores.enums.TipoDocumento;

import org.apache.commons.lang3.StringUtils;

public class NumeroUtil {

	private NumeroUtil() {
	}

	public static boolean esNumeroCelular(String numero) {
		return StringUtils.isNumeric(numero) && Long.parseLong(numero) > 0L
				&& numero.length() == 9;
	}

	public static boolean esDni(String numero) {
		return StringUtils.isNumeric(numero) && Long.parseLong(numero) > 0L
				&& numero.length() == TipoDocumento.DNI.getLongitud();
	}

	public static boolean esRuc(String numero) {
		return StringUtils.isNumeric(numero) && Long.parseLong(numero) > 0L
				&& numero.length() == TipoDocumento.RUC.getLongitud();
	}

	public static boolean esPasaporte(String numero) {
		return esAlfanumericoSinTildeEspacio(numero)
				&& numero.length() == TipoDocumento.PASAPORTE.getLongitud();
	}

	public static boolean esCarnetExtranjeria(String numero) {
		return esAlfanumericoSinTildeEspacio(numero)
				&& numero.length() == TipoDocumento.CARNET_EXTRANJERIA
						.getLongitud();
	}

	public static boolean esPartidaNacimiento(String numero) {
		return esAlfanumericoSinTildeEspacio(numero)
				&& numero.length() == TipoDocumento.PARTIDA_NACIMIENTO
						.getLongitud();
	}

	public static boolean esDocumentoValido(TipoDocumento tipoDocumento,
			String numeroDocumento) {
		boolean documentoValidoFlag = false;
		if (tipoDocumento.equals(TipoDocumento.DNI)) {
			documentoValidoFlag = esDni(numeroDocumento);
		} else if (tipoDocumento.equals(TipoDocumento.RUC)) {
			documentoValidoFlag = esRuc(numeroDocumento);
		} else if (tipoDocumento.equals(TipoDocumento.PASAPORTE)) {
			documentoValidoFlag = esPasaporte(numeroDocumento);
		} else if (tipoDocumento.equals(TipoDocumento.CARNET_EXTRANJERIA)) {
			documentoValidoFlag = esCarnetExtranjeria(numeroDocumento);
		} else if (tipoDocumento.equals(TipoDocumento.PARTIDA_NACIMIENTO)) {
			documentoValidoFlag = esPartidaNacimiento(numeroDocumento);
		}
		return documentoValidoFlag;
	}

	public static String obtenerMensajeDocumentoValido(
			TipoDocumento tipoDocumento) {
		String mensaje = "";
		if (tipoDocumento.equals(TipoDocumento.DNI)) {
			mensaje = GeneralConstante.MSJ_VALID_DNI;
		} else if (tipoDocumento.equals(TipoDocumento.RUC)) {
			mensaje = GeneralConstante.MSJ_VALID_RUC;
		} else if (tipoDocumento.equals(TipoDocumento.PASAPORTE)) {
			mensaje = GeneralConstante.MSJ_VALID_PASAPORTE;
		} else if (tipoDocumento.equals(TipoDocumento.CARNET_EXTRANJERIA)) {
			mensaje = GeneralConstante.MSJ_VALID_CARNET_EXTRANJERIA;
		} else if (tipoDocumento.equals(TipoDocumento.PARTIDA_NACIMIENTO)) {
			mensaje = GeneralConstante.MSJ_VALID_PARTIDA_NACIMIENTO;
		}
		return mensaje;
	}

	public static boolean esAlfanumericoSinTildeEspacio(String cadena) {
		return cadena.matches("[a-zA-Z0-9-]*[a-zA-Z-]+[a-zA-Z0-9-]*");
	}
}