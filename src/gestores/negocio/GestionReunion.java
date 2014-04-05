package gestores.negocio;

import gestores.dao.ReunionDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Reunion;

import java.util.Date;
import java.util.List;

/**
 * @author Jeremías Yalta.
 */
public class GestionReunion {

	public List<Reunion> listar(Date fechaInicio, Date fechaFin, Reunion reunion)
			throws DAOExcepcion {
		ReunionDAO dao = new ReunionDAO();
		return dao.listar(fechaInicio, fechaFin, reunion);
	}

	public Reunion insertar(Reunion reunion) throws DAOExcepcion {
		ReunionDAO dao = new ReunionDAO();

		boolean registradaMismoDiaFlag = dao.esRegistradaMismoDia(reunion);
		if (!registradaMismoDiaFlag) {
			return dao.insertar(reunion);
		} else {
			throw new DAOExcepcion(
					"No puede registrar mï¿½s de una reuniï¿½n el mismo dï¿½a");
		}
	}
}
