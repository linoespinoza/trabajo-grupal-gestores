package gestores.constante;

public class ReunionConstante {

	private ReunionConstante() {
	}

	public static final String SER_INI_REUNION = "InicioReunionServlet";
	public static final String PAG_BUSQ_REUNION = "jsp/gestion/registroReunion/busquedaReunion.jsp";
	public static final String PAG_NUEVO_REUNION = "jsp/gestion/registroReunion/nuevoReunion.jsp";

	public static final String MSJ_VALID_REUNION = "No puede registrar más de una reunión el mismo día";
	public static final String MSJ_VALID_RANGO_FECHA = "La fecha inicial debe ser menor que la fecha final";
}