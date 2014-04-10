package gestores.constante;

import java.io.File;

public class EvaluacionIdeaConstante {

	private EvaluacionIdeaConstante() {
	}

	public static final String SER_INI_EVALUACION_IDEA = "InicioEvaluacionIdeaServlet";
	public static final String SER_OBT_EVALUACION_IDEA = "ObtieneEvaluacionIdeaServlet";
	public static final String PAG_BUSQ_EVALUACION_IDEA = "jsp/gestion/evaluacionIdea/busquedaEvaluacionIdea.jsp";
	public static final String PAG_EVALUACION_IDEA = "jsp/gestion/evaluacionIdea/evaluacionIdea.jsp";

	public static final String DIRECTORIO_ARCHIVO = File.separator + "upload"
			+ File.separator + "archivo";

	public static final String MSJ_VALID_NO_PUBLICADA = "No puede aprobar o rechazar la idea si no ha sido publicada";
	public static final String MSJ_VALID_NO_VOTADA = "No puede aprobar o rechazar la idea si no fue votada";
	public static final String MSJ_VALID_NO_APROBADA = "No puede asignar asesor si la idea no está aprobada";
	public static final String MSJ_VALID_NO_ASIGNADA = "No puede asignar asesor ya que es asesor de otra idea para el mismo estudiante";
	public static final String MSJ_VALID_NO_EXIST_IDEA = "No existe la idea";
}