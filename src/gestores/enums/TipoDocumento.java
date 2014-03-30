package gestores.enums;

/**
 * @author Harry Bravo
 */
public enum TipoDocumento {
	Dni("DNI", "Documento Nacional de Identidad", 8), Ruc("RUC",
			"Registro Único de Contribuyentes", 11), CarnetExtranjeria("CEX",
			"Carnet de Extranjería", 12), Pasaporte("PAS", "Pasaporte", 12), PartidaNacimiento(
			"PNA", "Partida de Nacimiento", 15);

	private String codigo;
	private String nombre;
	private int longitud;

	private TipoDocumento(String codigo, String nombre, int longitud) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.longitud = longitud;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getLongitud() {
		return longitud;
	}

	public static TipoDocumento getTipoDocumento(String codigo) {
		TipoDocumento tipoDocumento = null;
		for (TipoDocumento tipoDocumentoAux : TipoDocumento.values()) {
			if (tipoDocumentoAux.getCodigo().equals(codigo)) {
				tipoDocumento = tipoDocumentoAux;
				break;
			}
		}
		return tipoDocumento;
	}
}