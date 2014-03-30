package gestores.enums;

/**
 * @author Harry Bravo.
 */
public enum EstadoIdea {

	Creada("CRE"), Publicada("PUB"), Aprobada("APR"), Rechazada("REC");

	private String codigo;

	private EstadoIdea(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
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