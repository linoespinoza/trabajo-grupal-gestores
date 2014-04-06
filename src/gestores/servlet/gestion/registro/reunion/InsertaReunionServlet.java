package gestores.servlet.gestion.registro.reunion;

import gestores.constante.GeneralConstante;
import gestores.constante.ReunionConstante;
import gestores.enums.TipoCalificacion;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Reunion;
import gestores.modelo.Usuario;
import gestores.negocio.GestionReunion;
import gestores.util.FechaUtil;

import java.io.IOException;

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
@WebServlet("/InsertaReunionServlet")
public class InsertaReunionServlet extends HttpServlet {

	private static final long serialVersionUID = 919605033001572570L;

	public InsertaReunionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GestionReunion gestionReunion = new GestionReunion();
		try {
			HttpSession session = request.getSession();
			Reunion reunion = setearDatosEntrada(request);
			session.setAttribute("reunion", reunion);

			gestionReunion.insertar(reunion);
			session.removeAttribute("listaIdea");
		} catch (NegocioExcepcion e) {
			request.setAttribute("mensaje", e.getMessage());
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ ReunionConstante.PAG_NUEVO_REUNION);
			requestDispatcher.forward(request, response);
			return;
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ ReunionConstante.PAG_NUEVO_REUNION);
			requestDispatcher.forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ ReunionConstante.PAG_NUEVO_REUNION);
			requestDispatcher.forward(request, response);
			return;
		}
		response.sendRedirect(ReunionConstante.SER_INI_REUNION);
	}

	private Reunion setearDatosEntrada(HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession();
		Usuario asesor = (Usuario) session.getAttribute("usuarioActual");

		Idea idea = new Idea();
		idea.setCodigo(Integer.parseInt(request.getParameter("idea")));
		idea.setAsesor(asesor);

		Reunion reunion = new Reunion();
		reunion.setIdea(idea);
		reunion.setFechaReunion(FechaUtil.parsearFechaHora(request
				.getParameter("fecha")));
		reunion.setObservacion(request.getParameter("observacion"));
		reunion.setTipoCalificacion(TipoCalificacion
				.getTipoCalificacion(request.getParameter("tipoCalificacion")));

		return reunion;
	}
}