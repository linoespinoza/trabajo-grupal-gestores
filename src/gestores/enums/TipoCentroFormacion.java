package gestores.enums;

/**
 * @author Harry Bravo.
 */
public enum TipoCentroFormacion {

	UNIVERSIDAD("UNI", "Universidad"), INSTITUTO("INS", "Instituto");

	private String codigo;
	private String nombre;

	private TipoCentroFormacion(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
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