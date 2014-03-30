package gestores.enums;

/**
 * @author Harry Bravo.
 */
public enum EstadoIdea {

	CREADA("CRE", "Creada"), PUBLICADA("PUB", "Publicada"), APROBADA("APR",
			"Aprobada"), RECHAZADA("REC", "Rechazada");

	private String codigo;
	private String nombre;

	private EstadoIdea(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public static EstadoIdea getEstadoIdea(String codigo) {
		EstadoIdea estadoIdea = null;
		for (EstadoIdea estadoIdeaAux : EstadoIdea.values()) {
			if (estadoIdeaAux.getCodigo().equals(codigo)) {
				estadoIdea = estadoIdeaAux;
				break;
			}
		}
		return estadoIdea;
	}
}