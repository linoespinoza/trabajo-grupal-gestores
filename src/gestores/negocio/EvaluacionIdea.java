package gestores.negocio;

import gestores.bean.Puntaje;
import gestores.constante.EvaluacionIdeaConstante;
import gestores.dao.IdeaDAO;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Bravo.
 */
public class EvaluacionIdea {

	public List<Idea> listarEvaluacion(Idea idea, Usuario evaluador)
			throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		return dao.listarEvaluacion(idea, evaluador);
	}

	public Idea obtenerEvaluacion(Integer codigo) throws DAOExcepcion,
			NegocioExcepcion {
		IdeaDAO dao = new IdeaDAO();

		Idea idea = dao.obtenerEvaluacion(codigo);
		if (idea == null) {
			throw new NegocioExcepcion(
					EvaluacionIdeaConstante.MSJ_VALID_NO_EXIST_IDEA);
		}
		return idea;
	}

	public int actualizarEstado(Idea idea) throws DAOExcepcion,
			NegocioExcepcion {
		IdeaDAO dao = new IdeaDAO();

		if (!dao.esPublicada(idea.getCodigo())) {
			throw new NegocioExcepcion(
					EvaluacionIdeaConstante.MSJ_VALID_NO_PUBLICADA);
		}
		if (!dao.esIdeaVotada(idea.getCodigo())) {
			throw new NegocioExcepcion(
					EvaluacionIdeaConstante.MSJ_VALID_NO_VOTADA);
		}
		return dao.actualizarEstado(idea);
	}

	public int asignarAsesor(Idea idea) throws DAOExcepcion, NegocioExcepcion {
		IdeaDAO dao = new IdeaDAO();

		if (!dao.esAprobada(idea.getCodigo())) {
			throw new NegocioExcepcion(
					EvaluacionIdeaConstante.MSJ_VALID_NO_APROBADA);
		}
		if (dao.esAsesorOtraIdea(idea)) {
			throw new NegocioExcepcion(
					EvaluacionIdeaConstante.MSJ_VALID_NO_ASIGNADA);
		}
		return dao.actualizarAsesor(idea);
	}

	public List<Puntaje> listarResumenPuntaje(Integer codigo)
			throws DAOExcepcion {
		IdeaDAO dao = new IdeaDAO();
		List<Puntaje> listaPuntaje = new ArrayList<Puntaje>();
		List<Puntaje> listaPuntajeAux = dao.listarPuntaje(codigo);

		for (int valorPuntaje = 1; valorPuntaje <= 5; valorPuntaje++) {
			boolean puntajeEncontrado = false;

			for (Puntaje puntajeAux : listaPuntajeAux) {
				if (puntajeAux.getValorPuntaje().equals(valorPuntaje)) {
					listaPuntaje.add(puntajeAux);
					puntajeEncontrado = true;
					break;
				}
			}

			if (!puntajeEncontrado) {
				Puntaje puntajeAux = new Puntaje();
				puntajeAux.setValorPuntaje(valorPuntaje);
				puntajeAux.setCantidadUsuarios(0);
				listaPuntaje.add(puntajeAux);
			}
		}
		return listaPuntaje;
	}
}