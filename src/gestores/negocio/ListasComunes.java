package gestores.negocio;

import gestores.dao.CentroFormacionDAO;
import gestores.dao.PlanTarifarioDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.PlanTarifario;

import java.util.List;

/**
 * @author Harry Bravo.
 */
public class ListasComunes {

	public List<PlanTarifario> listarPlanTarifario() throws DAOExcepcion {
		PlanTarifarioDAO dao = new PlanTarifarioDAO();
		return dao.listar();
	}

	public List<CentroFormacion> listarCentroFormacion() throws DAOExcepcion {
		CentroFormacionDAO dao = new CentroFormacionDAO();
		return dao.listar();
	}
}