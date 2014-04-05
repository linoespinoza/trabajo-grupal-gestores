package gestores.servlet.gestion.evaluacion.idea;

import gestores.constante.EvaluacionIdeaConstante;
import gestores.constante.GeneralConstante;
import gestores.enums.EstadoIdea;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Idea;
import gestores.negocio.EvaluacionIdea;

import java.io.IOException;

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
@WebServlet("/ApruebaIdeaServlet")
public class ApruebaIdeaServlet extends HttpServlet {

	private static final long serialVersionUID = 1439075737137979464L;

	public ApruebaIdeaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EvaluacionIdea evaluacionIdea = new EvaluacionIdea();
		try {
			HttpSession session = request.getSession();
			Idea idea = setearDatosEntrada(request);

			evaluacionIdea.actualizarEstado(idea);
			idea = evaluacionIdea.obtenerEvaluacion(idea.getCodigo());

			session.setAttribute("idea", idea);
		} catch (NegocioExcepcion e) {
			request.setAttribute("mensaje", e.getMessage());
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/"
				+ EvaluacionIdeaConstante.PAG_EVALUACION_IDEA);
		requestDispatcher.forward(request, response);
	}

	private Idea setearDatosEntrada(HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		Idea idea = (Idea) session.getAttribute("idea");
		idea.setEstadoIdea(EstadoIdea.APROBADA);

		return idea;
	}
}