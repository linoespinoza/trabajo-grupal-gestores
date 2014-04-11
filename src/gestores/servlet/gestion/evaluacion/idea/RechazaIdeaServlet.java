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
@WebServlet("/RechazaIdeaServlet")
public class RechazaIdeaServlet extends HttpServlet {

	private static final long serialVersionUID = 4898648414941583935L;

	public RechazaIdeaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EvaluacionIdea evaluacionIdea = new EvaluacionIdea();
		Idea ideaBD = null;
		try {
			Idea idea = setearDatosEntrada(request);
			ideaBD = evaluacionIdea.obtenerEvaluacion(idea.getCodigo());

			evaluacionIdea.actualizarEstado(idea);
		} catch (NegocioExcepcion e) {
			session.setAttribute("idea", ideaBD);
			request.setAttribute("mensaje", e.getMessage());
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ EvaluacionIdeaConstante.PAG_EVALUACION_IDEA);
			requestDispatcher.forward(request, response);
			return;
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ EvaluacionIdeaConstante.PAG_EVALUACION_IDEA);
			requestDispatcher.forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ EvaluacionIdeaConstante.PAG_EVALUACION_IDEA);
			requestDispatcher.forward(request, response);
			return;
		}
		response.sendRedirect(EvaluacionIdeaConstante.SER_INI_EVALUACION_IDEA);
	}

	private Idea setearDatosEntrada(HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		Idea idea = (Idea) session.getAttribute("idea");
		idea.setEstadoIdea(EstadoIdea.RECHAZADA);

		return idea;
	}
}