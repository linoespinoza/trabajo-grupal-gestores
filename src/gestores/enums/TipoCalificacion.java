package gestores.enums;

/**
 * @author Harry Bravo.
 */
public enum TipoCalificacion {

	BUENO("BUE", "Bueno"), MEDIO("MED", "Medio"), MEJORAR("MEJ", "Mejorar");

	private String codigo;
	private String nombre;

	private TipoCalificacion(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
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