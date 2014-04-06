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

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Jeremías Yalta.
 */
@WebServlet("/InicioReunionServlet")
public class InicioReunionServlet extends HttpServlet {

	private static final long serialVersionUID = -8874254213607101106L;

	public InicioReunionServlet() {
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
		GestionReunion gestionReunion = new GestionReunion();
		try {
			HttpSession session = request.getSession();
			Usuario asesor = (Usuario) session.getAttribute("usuarioActual");

			Idea idea = new Idea();
			idea.setAsesor(asesor);

			Reunion reunion = new Reunion();
			reunion.setIdea(idea);

			List<Reunion> listaReunion = gestionReunion.listar(null, null,
					reunion);

			session.setAttribute("listaTipoCalificacion",
					TipoCalificacion.values());
			session.setAttribute("listaReunion", listaReunion);
			session.removeAttribute("fechaInicio");
			session.removeAttribute("fechaFin");
			session.removeAttribute("reunion");
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
		response.sendRedirect(ReunionConstante.PAG_BUSQ_REUNION);
	}
}