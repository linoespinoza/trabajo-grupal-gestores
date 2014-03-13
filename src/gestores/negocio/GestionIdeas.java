
package gestores.negocio;

import java.util.Collection;


import gestores.dao.IdeaDAO;
import gestores.modelo.Idea;
import gestores.exception.DAOExcepcion;


public class GestionIdeas {

	public Idea insertar(Idea vo) throws DAOExcepcion {
		
		IdeaDAO dao = new IdeaDAO();
		
//		boolean existe = dao.buscarIdea(vo.getNombre());
		
//		if (! existe) {
			 
			return dao.insertar(vo);
//		} else {
//			throw new DAOExcepcion("Ya existe esa Idea");
//		}
		
	}
	
	public Collection<Idea> listar() throws DAOExcepcion {
		
		IdeaDAO dao = new IdeaDAO();
		return dao.listar();
	}
	
}
