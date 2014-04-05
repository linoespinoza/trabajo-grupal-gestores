package gestores.servlet.gestion.evaluacion.idea;

import gestores.constante.EvaluacionIdeaConstante;
import gestores.constante.GeneralConstante;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
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
@WebServlet("/AsignaAsesorServlet")
public class AsignaAsesorServlet extends HttpServlet {

	private static final long serialVersionUID = 5461323966544146782L;

	public AsignaAsesorServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EvaluacionIdea evaluacionIdea = new EvaluacionIdea();
		try {
			Idea idea = setearDatosEntrada(request);

			evaluacionIdea.asignarAsesor(idea);
		} catch (NegocioExcepcion e) {
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

		Usuario asesor = new Usuario();
		asesor.setCodigo(Integer.parseInt(request.getParameter("asesor")));

		Idea idea = (Idea) session.getAttribute("idea");
		idea.setAsesor(asesor);

		return idea;
	}
}