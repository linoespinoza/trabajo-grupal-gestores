package gestores.negocio;

import gestores.dao.CobroDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.ReportePago;

import java.util.Collection;


/**
 * @author Marco Chumpitaz.
 */

public class GestionCobro {

	public Collection<ReportePago> listar() throws DAOExcepcion {
		
		CobroDAO dao = new CobroDAO();
		return dao.listar();		
	}

}
