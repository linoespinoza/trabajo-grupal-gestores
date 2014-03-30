package gestores.enums;

/**
 * @author Harry Bravo.
 */
public enum TipoCentroFormacion {

	Universidad("UNI"), Instituto("INS");

	private String codigo;

	private TipoCentroFormacion(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public static TipoCentroFormacion getTipoCentroFormacion(String codigo) {
		TipoCentroFormacion tipoCentroFormacion = null;
		for (TipoCentroFormacion tipoCentroFormacionAux : TipoCentroFormacion
				.values()) {
			if (tipoCentroFormacionAux.getCodigo().equals(codigo)) {
				tipoCentroFormacion = tipoCentroFormacionAux;
				break;
			}
		}
		return tipoCentroFormacion;
	}
}