package gestores.constante;

import java.io.File;

public class CentroFormacionConstante {

	private CentroFormacionConstante() {
	}

	public static final String DIRECTORIO_LOGO = File.separator + "upload"
			+ File.separator + "logo";
	public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	public static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	public static final int LONGITUD_RUC = 11;
}