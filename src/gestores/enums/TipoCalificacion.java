package gestores.enums;

/**
 * @author Harry Bravo.
 */
public enum TipoCalificacion {

	Bueno("BUE"), Medio("MED"), Mejorar("MEJ");

	private String codigo;

	private TipoCalificacion(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public static TipoCalificacion getTipoCalificacion(String codigo) {
		TipoCalificacion tipoCalificacion = null;
		for (TipoCalificacion tipoCalificacionAux : TipoCalificacion.values()) {
			if (tipoCalificacionAux.getCodigo().equals(codigo)) {
				tipoCalificacion = tipoCalificacionAux;
				break;
			}
		}
		return tipoCalificacion;
	}
}