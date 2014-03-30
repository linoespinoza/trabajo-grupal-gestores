package gestores.negocio;

import gestores.dao.PlanTarifarioDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.PlanTarifario;

import java.util.List;

/**
 * @author Harry Bravo.
 */
public class ListasComunes {

	public List<PlanTarifario> listar() throws DAOExcepcion {
		PlanTarifarioDAO dao = new PlanTarifarioDAO();
		return dao.listar();
	}
}