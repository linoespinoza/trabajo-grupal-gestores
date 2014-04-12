package gestores.negocio;

import gestores.constante.IdeaConstante;
import gestores.dao.IdeaDAO;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;

import java.util.List;

public class GestionIdea {

	/**
	 * @author Lino Espinoza
	 */
	public Idea insertar(Idea idea) throws DAOExcepcion, NegocioExcepcion {

		IdeaDAO dao = new IdeaDAO();

		if (!idea.getPalabrasClave().equals(null)) {
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

			if (flag) {
				throw new NegocioExcepcion(
						IdeaConstante.MSJ_VALID_PALABRAS_CLAVES);
			}
		}

		if (dao.esIdeaConTituloExistente(idea)) {
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

	/**
	 * @author Alex Valencia
	 */
	public List<Idea> listar_Idea() throws DAOExcepcion {

		IdeaDAO dao = new IdeaDAO();
		return dao.listar_Idea();
	}

	/**
	 * @author Alex Valencia
	 */
	public List<Idea> buscarNombreIdea(int codigo) throws DAOExcepcion {

		IdeaDAO dao = new IdeaDAO();
		return dao.buscarNombreIdea(codigo);
	}

	/**
	 * @author Alex Valencia
	 */
	public List<Idea> buscarCadenaIdea(String cadena, String estado,
			String codigoCE) throws DAOExcepcion {

		IdeaDAO dao = new IdeaDAO();
		return dao.buscarCadenaIdea(cadena, estado, codigoCE);
	}

	/**
	 * @author Alex Valencia
	 */
	public List<Idea> buscarParticipacionIdea(String cadena, String codigoCE)
			throws DAOExcepcion {

		IdeaDAO dao = new IdeaDAO();
		return dao.buscarParticipacionIdea(cadena, codigoCE);
	}
}