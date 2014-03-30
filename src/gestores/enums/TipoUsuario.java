package gestores.enums;

/**
 * @author Harry Bravo.
 */
public enum TipoUsuario {

	ESTUDIANTE("EST", "Estudiante"), DOCENTE("DOC", "Docente"), EVALUADOR(
			"EVA", "Evaluador"), ADMINISTRADOR("ADM", "Administrador");

	private String codigo;
	private String nombre;

	private TipoUsuario(String codigo, String nombre) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public static TipoUsuario getTipoUsuario(String codigo) {
		TipoUsuario tipoUsuario = null;
		for (TipoUsuario tipoUsuarioAux : TipoUsuario.values()) {
			if (tipoUsuarioAux.getCodigo().equals(codigo)) {
				tipoUsuario = tipoUsuarioAux;
				break;
			}
		}
		return tipoUsuario;
	}
}