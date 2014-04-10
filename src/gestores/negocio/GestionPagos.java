package gestores.negocio;

import gestores.dao.PagosDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.ReportePago;

import java.util.Collection;
/**
 * @author Marco Chumpitaz.
 */
public class GestionPagos {
	
	public Collection<ReportePago> listaPagos(ReportePago rpago) throws DAOExcepcion {
		PagosDAO dao = new PagosDAO();
		return dao.listaPagos(rpago);		
	}

	public Collection<ReportePago> listar() throws DAOExcepcion {
		PagosDAO dao = new PagosDAO();
		return dao.listar();		
	}

}
