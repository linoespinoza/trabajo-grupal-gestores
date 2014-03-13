package gestores.negocio;

import gestores.dao.TipoEstadoIdeaDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.TipoEstadoIdea;

import java.util.Collection;

public class GestionTipoEstadoIdea {

	public TipoEstadoIdea insertar(TipoEstadoIdea vo) throws DAOExcepcion {
		
		TipoEstadoIdeaDAO dao = new TipoEstadoIdeaDAO();
		
//		boolean existe = dao.buscarIdea(vo.getNombre());
		
//		if (! existe) {
			 
			return dao.insertar(vo);
//		} else {
//			throw new DAOExcepcion("Ya existe esa Idea");
//		}
		
	}
	
	public Collection<TipoEstadoIdea> listar() throws DAOExcepcion {
		
		TipoEstadoIdeaDAO dao = new TipoEstadoIdeaDAO();
		return dao.listar();
	}
	
}
