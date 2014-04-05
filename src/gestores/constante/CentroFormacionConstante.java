package gestores.constante;

import java.io.File;

/**
 * @author Harry Bravo.
 */
public class CentroFormacionConstante {

	private CentroFormacionConstante() {
	}

	public static final String SER_INI_CENTRO_FORMACION = "InicioCentroFormacionServlet";
	public static final String PAG_MANT_CENTRO_FORMACION = "jsp/mantenimiento/centroFormacion/mantenimientoCentroFormacion.jsp";
	public static final String PAG_NUEVO_CENTRO_FORMACION = "jsp/mantenimiento/centroFormacion/nuevoCentroFormacion.jsp";
	public static final String PAG_EDITA_CENTRO_FORMACION = "jsp/mantenimiento/centroFormacion/editaCentroFormacion.jsp";

	public static final String DIRECTORIO_LOGO = File.separator + "upload"
			+ File.separator + "logo";
	public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
	public static final int MAX_FILE_SIZE = 1024 * 1024 * 40;
	public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;

	public static final String MSJ_VALID_IMAGEN = "Debe adjuntar un archivo gif, jpg o png";
	public static final String MSJ_VALID_NOMBRE = "Ya existe un centro de formación con el mismo nombre";
	public static final String MSJ_VALID_URL = "Ya existe un centro de formación con la misma url";
	public static final String MSJ_VALID_NO_EXIST_CENTRO_FORMACION = "No existe el centro de formación";
}