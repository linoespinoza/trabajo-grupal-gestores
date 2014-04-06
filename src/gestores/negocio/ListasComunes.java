package gestores.negocio;

import gestores.dao.CentroFormacionDAO;
import gestores.dao.IdeaDAO;
import gestores.dao.PlanTarifarioDAO;
import gestores.dao.UsuarioDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Idea;
import gestores.modelo.PlanTarifario;
import gestores.modelo.Usuario;

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

	public List<Usuario> listarDocente(String codigoCentroFormacion)
			throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.listarDocente(codigoCentroFormacion);
	}

	public List<Idea> listarIdeaAsesor(Integer codigoAsesor)
			throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		return dao.listar(codigoAsesor);
	}
}