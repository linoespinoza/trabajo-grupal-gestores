package gestores.servlet.gestion.evaluacion.idea;

import gestores.constante.EvaluacionIdeaConstante;
import gestores.constante.GeneralConstante;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.EvaluacionIdea;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Harry Bravo.
 */
@WebServlet("/InicioEvaluacionIdeaServlet")
public class InicioEvaluacionIdeaServlet extends HttpServlet {

	private static final long serialVersionUID = -1730025169920311600L;

	public InicioEvaluacionIdeaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		iniciar(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		iniciar(request, response);
	}

	private void iniciar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EvaluacionIdea evaluacionIdea = new EvaluacionIdea();
		try {
			HttpSession session = request.getSession();
			Usuario evaluador = (Usuario) session.getAttribute("usuarioActual");

			Idea idea = new Idea();
			idea.setTitulo("");

			List<Idea> listaIdea = evaluacionIdea.listarEvaluacion(idea,
					evaluador);
			session.setAttribute("listaIdea", listaIdea);
			session.setAttribute("directorioArchivo",
					EvaluacionIdeaConstante.DIRECTORIO_ARCHIVO);
			session.removeAttribute("idea");
			session.removeAttribute("listaDocente");
			session.removeAttribute("listaPuntaje");
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		response.sendRedirect(EvaluacionIdeaConstante.PAG_BUSQ_EVALUACION_IDEA);
	}
}