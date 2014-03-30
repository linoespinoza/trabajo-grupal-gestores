package gestores.enums;

/**
 * @author Harry Bravo
 */
public enum TipoDocumento {
	DNI("DNI", "Documento Nacional de Identidad", 8), RUC("RUC",
			"Registro Único de Contribuyentes", 11), CARNET_EXTRANJERIA("CEX",
			"Carnet de Extranjería", 12), PASAPORTE("PAS", "Pasaporte", 12), PARTIDA_NACIMIENTO(
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