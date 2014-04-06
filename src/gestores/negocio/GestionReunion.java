package gestores.negocio;

import gestores.constante.ReunionConstante;
import gestores.dao.ReunionDAO;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Reunion;

import java.util.Date;
import java.util.List;

/**
 * @author Jeremías Yalta.
 */
public class GestionReunion {

	public List<Reunion> listar(Date fechaInicio, Date fechaFin, Reunion reunion)
			throws DAOExcepcion, NegocioExcepcion {
		ReunionDAO dao = new ReunionDAO();
		if (fechaInicio != null && fechaFin != null
				&& fechaInicio.after(fechaFin)) {
			throw new NegocioExcepcion(ReunionConstante.MSJ_VALID_RANGO_FECHA);
		}
		return dao.listar(fechaInicio, fechaFin, reunion);
	}

	public int insertar(Reunion reunion) throws DAOExcepcion, NegocioExcepcion {
		ReunionDAO dao = new ReunionDAO();

		if (dao.esRegistradaMismoDia(reunion)) {
			throw new NegocioExcepcion(ReunionConstante.MSJ_VALID_REUNION);
		}
		return dao.insertar(reunion);
	}
}