package gestores.servlet.gestion.evaluacion.idea;

import gestores.constante.EvaluacionIdeaConstante;
import gestores.constante.GeneralConstante;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.EvaluacionIdea;

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
@WebServlet("/BusquedaEvaluacionIdeaServlet")
public class BusquedaEvaluacionIdeaServlet extends HttpServlet {

	private static final long serialVersionUID = -8754149547933617876L;

	public BusquedaEvaluacionIdeaServlet() {
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
			Usuario evaluador = (Usuario) session.getAttribute("usuarioActual");

			Idea idea = new Idea();
			idea.setTitulo(request.getParameter("titulo"));
			request.setAttribute("idea", idea);

			List<Idea> listaIdea = evaluacionIdea.listarEvaluacion(idea,
					evaluador);

			session.setAttribute("listaIdea", listaIdea);
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/"
				+ EvaluacionIdeaConstante.PAG_BUSQ_EVALUACION_IDEA);
		requestDispatcher.forward(request, response);
	}
}