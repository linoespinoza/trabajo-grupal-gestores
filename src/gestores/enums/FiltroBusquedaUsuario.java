package gestores.enums;

/**
 * @author Harry Bravo.
 */
public enum FiltroBusquedaUsuario {
	NOMBRE("NOM", "Nombre"), APELLIDO_PATERNO("APE_PAT", "Apellido Paterno"), APELLIDO_MATERNO(
			"APE_MAT", "Apellido Materno");

	private String codigo;
	private String nombre;

	private FiltroBusquedaUsuario(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}
}