package gestores.negocio;

import gestores.dao.IdeaDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class GestionIdea {

	public Idea insertar(Idea idea) throws DAOExcepcion {

		IdeaDAO dao = new IdeaDAO();

		boolean ideaConTituloExistente = dao.esIdeaConTituloExistente(idea);
		boolean palabrasRepetidas = false;
		String[] palabrasClaves = idea.getPalabrasClave().split(",");

		// String = match
		int numeroCoincidencias = 0;
		for (String string : palabrasClaves) {

			System.out
					.println(string
							+ ' '
							+ StringUtils.containsOnly(idea.getPalabrasClave(),
									string));

			/*
			 * if () { numeroCoincidencias++; } if (numeroCoincidencias > 1) {
			 * palabrasRepetidas = true; break; }
			 */
			System.out.println(numeroCoincidencias);
		}

		if (!ideaConTituloExistente && !palabrasRepetidas) {
			return dao.insertarIdea(idea);
		} else if (ideaConTituloExistente) {
			throw new DAOExcepcion(
					"No puede ingresar una idea con el mismo titulo");
		} else {
			throw new DAOExcepcion(
					"No puede ingresar una idea con palabras clave repetidas");
		}
	}

	public Idea actualizar(Idea idea) throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		return dao.actualizarIdea(idea);
	}

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
}
