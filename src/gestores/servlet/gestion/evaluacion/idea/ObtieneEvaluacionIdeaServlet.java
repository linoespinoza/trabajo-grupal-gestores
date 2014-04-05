package gestores.servlet.gestion.evaluacion.idea;

import gestores.bean.Puntaje;
import gestores.constante.EvaluacionIdeaConstante;
import gestores.constante.GeneralConstante;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.EvaluacionIdea;
import gestores.negocio.ListasComunes;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Harry Bravo.
 */
@WebServlet("/ObtieneEvaluacionIdeaServlet")
public class ObtieneEvaluacionIdeaServlet extends HttpServlet {

	private static final long serialVersionUID = -4946639447137471749L;

	public ObtieneEvaluacionIdeaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EvaluacionIdea evaluacionIdea = new EvaluacionIdea();
		ListasComunes listasComunes = new ListasComunes();
		try {
			HttpSession session = request.getSession();
			Usuario evaluador = (Usuario) session.getAttribute("usuarioActual");

			int codigo = Integer.parseInt(request.getParameter("codigo"));

			List<Usuario> listaDocente = listasComunes.listarDocente(evaluador
					.getCentroFormacion().getCodigo());
			List<Puntaje> listaPuntaje = evaluacionIdea
					.listarResumenPuntaje(codigo);
			Idea idea = evaluacionIdea.obtenerEvaluacion(codigo);

			session.setAttribute("idea", idea);
			session.setAttribute("listaDocente", listaDocente);
			session.setAttribute("listaPuntaje", listaPuntaje);
		} catch (NegocioExcepcion e) {
			request.setAttribute("mensaje", e.getMessage());
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ EvaluacionIdeaConstante.PAG_BUSQ_EVALUACION_IDEA);
			requestDispatcher.forward(request, response);
			return;
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ EvaluacionIdeaConstante.PAG_BUSQ_EVALUACION_IDEA);
			requestDispatcher.forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ EvaluacionIdeaConstante.PAG_BUSQ_EVALUACION_IDEA);
			requestDispatcher.forward(request, response);
			return;
		}
		response.sendRedirect(EvaluacionIdeaConstante.PAG_EVALUACION_IDEA);
	}
}