package gestores.negocio;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import gestores.dao.IdeaDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;


public class GestionIdea {

	public Idea insertar(Idea idea) throws DAOExcepcion {
		
		IdeaDAO dao = new IdeaDAO();
		
		boolean ideaConTituloExistente = dao.esIdeaConTituloExistente(idea);
		boolean palabrasRepetidas = false;
		String[] palabrasClaves = idea.getPalabrasClave().split(",");
		
		//String = match
		int numeroCoincidencias = 0;
		for (String string : palabrasClaves) {
			
			System.out.println(string + ' ' + StringUtils.containsOnly(idea.getPalabrasClave(), string));
			
				/*if () {
					 numeroCoincidencias++;
				}
				if (numeroCoincidencias > 1) {
					palabrasRepetidas = true;
					break;
				}*/
			System.out.println(numeroCoincidencias);
		}

		if (!ideaConTituloExistente && !palabrasRepetidas) {
			return dao.insertarIdea(idea);
		} else if(ideaConTituloExistente) {
			throw new DAOExcepcion("No puede ingresar una idea con el mismo titulo");	
		} else {
			throw new DAOExcepcion("No puede ingresar una idea con palabras clave repetidas");
		}	
	}
	
	public Idea actualizar(Idea idea) throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		return dao.actualizarIdea(idea);
	}

	public List<Idea> listarIdeasPorUsuario(Usuario estudiante) throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		return dao.listarIdeasPorUsuario(estudiante);
	}
}
