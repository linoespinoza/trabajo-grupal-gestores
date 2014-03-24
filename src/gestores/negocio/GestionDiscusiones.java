package gestores.negocio;

import java.util.Collection;

import gestores.dao.DiscusionDAO;
import gestores.dao.UsuarioDAO;
import gestores.modelo.Discusion;
import gestores.modelo.Usuario;
import gestores.exception.DAOExcepcion;


public class GestionDiscusiones {

	public Discusion insertar(Discusion vo) throws DAOExcepcion {
		
		DiscusionDAO dao = new DiscusionDAO();
		
//		boolean existe = dao.buscarIdea(vo.getNombre());
		
//		if (! existe) {
			 
			return dao.insertar(vo);
//		} else {
//			throw new DAOExcepcion("Ya existe esa Idea");
//		}
		
	}
	
	public Collection<Discusion> listar() throws DAOExcepcion {
		
		DiscusionDAO dao = new DiscusionDAO();
		return dao.listar();
	}
	
}