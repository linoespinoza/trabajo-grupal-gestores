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
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Jeremías Yalta.
 */
@WebServlet("/BusquedaReunionServlet")
public class BusquedaReunionServlet extends HttpServlet {

	private static final long serialVersionUID = 2593174025067961044L;

	public BusquedaReunionServlet() {
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
			Usuario asesor = (Usuario) session.getAttribute("usuarioActual");

			Date fechaInicio = null;
			Date fechaFin = null;

			if (StringUtils.isNotBlank(request.getParameter("fechaInicio"))
					&& StringUtils.isNotBlank(request.getParameter("fechaFin"))) {
				fechaInicio = FechaUtil.parsearFecha(request
						.getParameter("fechaInicio"));
				fechaFin = FechaUtil.parsearFecha(request
						.getParameter("fechaFin"));
				session.setAttribute("fechaInicio",
						FechaUtil.formatearFecha(fechaInicio));
				session.setAttribute("fechaFin",
						FechaUtil.formatearFecha(fechaFin));
			} else {
				session.removeAttribute("fechaInicio");
				session.removeAttribute("fechaFin");
			}
			String tipoCalificacion = request.getParameter("tipoCalificacion");

			Idea idea = new Idea();
			idea.setAsesor(asesor);

			Reunion reunion = new Reunion();
			reunion.setIdea(idea);
			reunion.setTipoCalificacion(TipoCalificacion
					.getTipoCalificacion(tipoCalificacion));
			session.setAttribute("reunion", reunion);

			List<Reunion> listaReunion = gestionReunion.listar(fechaInicio,
					fechaFin, reunion);

			session.setAttribute("listaReunion", listaReunion);
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
				+ ReunionConstante.PAG_BUSQ_REUNION);
		requestDispatcher.forward(request, response);
	}
}