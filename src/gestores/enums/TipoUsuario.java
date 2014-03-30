package gestores.enums;

/**
 * @author Harry Bravo.
 */
public enum TipoUsuario {

	Estudiante("EST"), Docente("DOC"), Evaluador("EVA"), Administrador("ADM");

	private String codigo;

	private TipoUsuario(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
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