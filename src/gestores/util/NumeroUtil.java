package gestores.util;

import gestores.constante.CentroFormacionConstante;

public class NumeroUtil {

	private NumeroUtil() {
	}

	public static boolean esNumeroRuc(String numero)
			throws NumberFormatException {
		boolean rucFlag = Long.parseLong(numero) > 0L
				&& numero.length() == CentroFormacionConstante.LONGITUD_RUC;
		return rucFlag;
	}
}