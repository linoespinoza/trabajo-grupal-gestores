package gestores.constante;

import java.io.File;

public class IdeaConstante {
	
	private IdeaConstante() {
	}

	public static final String SER_INI_IDEA = "InicioIdeaServlet";
	public static final String PAG_MANT_IDEA = "jsp/mantenimiento/idea/mantenimiento-idea.jsp";
	public static final String PAG_NUEVO_IDEA = "jsp/mantenimiento/idea/nueva-idea.jsp";
	public static final String PAG_EDITA_IDEA = "jsp/mantenimiento/idea/editar-idea.jsp";

	public static final String DIRECTORIO_IMAGEN_IDEA = File.separator + "upload"
			+ File.separator + "archivo";
	public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
	public static final int MAX_FILE_SIZE = 1024 * 1024 * 40;
	public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;

	public static final String MSJ_VALID_PALABRAS_CLAVES = "La idea no puede tener palabras claves iguales";
	public static final String MSJ_VALID_TITULO = "Ya existe una idea con el mismo título";
	public static final String MSJ_VALID_NO_EXIST_IDEA = "No existe la idea";
}
