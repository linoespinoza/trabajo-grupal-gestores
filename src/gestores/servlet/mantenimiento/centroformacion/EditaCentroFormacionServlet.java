package gestores.servlet.mantenimiento.centroformacion;

import gestores.constante.CentroFormacionConstante;
import gestores.constante.GeneralConstante;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.PlanTarifario;
import gestores.negocio.GestionCentroFormacion;
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
@WebServlet("/EditaCentroFormacionServlet")
public class EditaCentroFormacionServlet extends HttpServlet {

	private static final long serialVersionUID = -466456771940665303L;

	public EditaCentroFormacionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GestionCentroFormacion gestionCentroFormacion = new GestionCentroFormacion();
		ListasComunes listasComunes = new ListasComunes();
		try {
			HttpSession session = request.getSession();
			String codigo = request.getParameter("codigo");

			List<PlanTarifario> listaPlanTarifario = listasComunes.listar();
			CentroFormacion centroFormacion = gestionCentroFormacion
					.obtener(codigo);

			session.setAttribute("centroFormacion", centroFormacion);
			session.setAttribute("listaPlanTarifario", listaPlanTarifario);
			session.setAttribute("directorioLogo",
					CentroFormacionConstante.DIRECTORIO_LOGO);
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/jsp/mantenimiento/centroFormacion/mantenimientoCentroFormacion.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		response.sendRedirect("jsp/mantenimiento/centroFormacion/editaCentroFormacion.jsp");
	}
}