package gestores.enums;

/**
 * @author Harry Bravo.
 */
public enum FiltroBusquedaUsuario {
	Nombre("Nombre"), ApellidoPaterno("Apellido Paterno"), ApellidoMaterno(
			"Apellido Materno");

	private String valor;

	private FiltroBusquedaUsuario(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
