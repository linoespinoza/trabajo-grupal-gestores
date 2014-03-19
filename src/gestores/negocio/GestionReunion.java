package gestores.negocio;

import gestores.dao.ReunionDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Reunion;

import java.util.Date;
import java.util.List;

/**
 * @author Jerem�as Yalta.
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
					"No puede registrar m�s de una reuni�n el mismo d�a");
		}
	}
}
