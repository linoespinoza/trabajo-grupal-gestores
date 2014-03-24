
package gestores.negocio;

import java.util.Collection;

import gestores.dao.IdeaDAO;
import gestores.modelo.Idea;
import gestores.exception.DAOExcepcion;


public class GestionIdeas {

	public Idea insertar_idea(Idea vo) throws DAOExcepcion {
		
		IdeaDAO dao = new IdeaDAO();
//		boolean existe = dao.buscarIdea(vo.getNombre());	
//		if (! existe) {		 
			return dao.insertar_idea(vo);
//		} else {
//			throw new DAOExcepcion("Ya existe esa Idea");
//		}	
	}
	
	public Collection<Idea> listar_idea() throws DAOExcepcion {
		
		IdeaDAO dao = new IdeaDAO();
		return dao.listar_idea();
	}
	
	public Collection<Idea> buscarNombre_idea(int codigo) throws DAOExcepcion {
		
		IdeaDAO dao = new IdeaDAO();
		return dao.buscarNombre_idea(codigo);
	}
	
	public Collection<Idea> buscarCadena_idea(String cadena) throws DAOExcepcion {
		
		IdeaDAO dao = new IdeaDAO();
		return dao.buscarCadena_idea(cadena);
	}
}
