package gestores.servlet.gestion.registro.reunion;

import gestores.constante.GeneralConstante;
import gestores.constante.ReunionConstante;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
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
 * @author Jeremías Yalta.
 */
@WebServlet("/NuevoReunionServlet")
public class NuevoReunionServlet extends HttpServlet {

	private static final long serialVersionUID = -4191289270682672518L;

	public NuevoReunionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ListasComunes listasComunes = new ListasComunes();
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("reunion");
			Usuario asesor = (Usuario) session.getAttribute("usuarioActual");

			List<Idea> listaIdea = listasComunes.listarIdeaAsesor(asesor
					.getCodigo());

			session.setAttribute("listaIdea", listaIdea);
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ ReunionConstante.PAG_BUSQ_REUNION);
			requestDispatcher.forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ ReunionConstante.PAG_BUSQ_REUNION);
			requestDispatcher.forward(request, response);
			return;
		}
		response.sendRedirect(ReunionConstante.PAG_NUEVO_REUNION);
	}
}