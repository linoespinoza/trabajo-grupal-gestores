package gestores.util;

import gestores.constante.CentroFormacionConstante;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Harry Bravo.
 */
public class ArchivoUtil {

	private ArchivoUtil() {
	}

	public static ServletFileUpload obtenerUpload(HttpServletRequest request) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(CentroFormacionConstante.MEMORY_THRESHOLD);
		factory.setRepository(new File(FileUtils.getTempDirectoryPath()));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(CentroFormacionConstante.MAX_FILE_SIZE);
		upload.setSizeMax(CentroFormacionConstante.MAX_REQUEST_SIZE);
		return upload;
	}

	public static void crearDirectorio(String directorio) {
		File directorioFile = new File(directorio);
		if (!directorioFile.exists()) {
			directorioFile.mkdirs();
		}
	}

	public static boolean esImagen(String archivo) {
		return StringUtils.endsWithIgnoreCase(archivo, ".gif")
				|| StringUtils.endsWithIgnoreCase(archivo, ".jpg")
				|| StringUtils.endsWithIgnoreCase(archivo, ".png");
	}
}