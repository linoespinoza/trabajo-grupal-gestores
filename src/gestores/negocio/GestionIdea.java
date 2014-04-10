package gestores.negocio;

import gestores.constante.IdeaConstante;
import gestores.dao.IdeaDAO;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;

import java.util.Collection;
import java.util.List;

public class GestionIdea {

	/**
	 * @author Lino Espinoza
	 */
	public Idea insertar(Idea idea) throws DAOExcepcion, NegocioExcepcion {

		IdeaDAO dao = new IdeaDAO();
		
		if(!idea.getPalabrasClave().equals(null)){
			String[] palabrasClaves = idea.getPalabrasClave().split(",");
			String palabrasAux = palabrasClaves[0];
			Integer cont = 0;
			boolean flag = false;
			
			for (int i = 0; i < palabrasClaves.length; i++) {
				if (palabrasAux.equals(palabrasClaves[i])) {
					cont++;
				}
	
				if (cont > 1) {
					flag = true;
					break;
				}
			}
			
			if(flag) {
				throw new NegocioExcepcion(IdeaConstante.MSJ_VALID_PALABRAS_CLAVES);
			}
		}
		
		if(dao.esIdeaConTituloExistente(idea)) {
			throw new NegocioExcepcion(IdeaConstante.MSJ_VALID_TITULO);
		}
		
		return dao.insertarIdea(idea);
	}

	/**
	 * @author Lino Espinoza
	 */
	public Idea actualizar(Idea idea) throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		return dao.actualizarIdea(idea);
	}
	
	/**
	 * @author Lino Espinoza
	 */
	public int eliminar(String codigo) throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		return dao.eliminar(codigo);
	}
	
	/**
	 * @author Lino Espinoza
	 */

	public List<Idea> listarIdeasPorUsuario(Usuario estudiante)
			throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		return dao.listarIdeasPorUsuario(estudiante);
	}

	/**
	 * @author Alex Valencia
	 */
	public Collection<Idea> listar_Idea() throws DAOExcepcion {

		IdeaDAO dao = new IdeaDAO();
		return dao.listar_Idea();
	}

	/**
	 * @author Alex Valencia
	 */
	public Collection<Idea> buscarNombre_Idea(int codigo) throws DAOExcepcion {

		IdeaDAO dao = new IdeaDAO();
		return dao.buscarNombre_Idea(codigo);
	}

	/**
	 * @author Alex Valencia
	 */
	public Collection<Idea> buscarCadena_Idea(String cadena)
			throws DAOExcepcion {

		IdeaDAO dao = new IdeaDAO();
		return dao.buscarCadena_Idea(cadena);
	}
	
	/**
	 * @author Lino Espinoza
	 */

	public Idea obtener(String codigo) throws DAOExcepcion, NegocioExcepcion {
		IdeaDAO dao = new IdeaDAO();

		Idea idea = dao.obtener(codigo);
		if (idea == null) {
			throw new NegocioExcepcion(IdeaConstante.MSJ_VALID_NO_EXIST_IDEA);
		}
		return idea;
	}
}
