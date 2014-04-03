package gestores.servlet.mantenimiento.centroformacion;

import gestores.constante.GeneralConstante;
import gestores.exception.DAOExcepcion;
import gestores.modelo.PlanTarifario;
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
@WebServlet("/NuevoCentroFormacionServlet")
public class NuevoCentroFormacionServlet extends HttpServlet {

	private static final long serialVersionUID = -2824916743031642534L;

	public NuevoCentroFormacionServlet() {
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
			session.removeAttribute("centroFormacion");

			List<PlanTarifario> listaPlanTarifario = listasComunes.listar();

			session.setAttribute("listaPlanTarifario", listaPlanTarifario);
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/jsp/mantenimiento/centroFormacion/mantenimientoCentroFormacion.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		response.sendRedirect("jsp/mantenimiento/centroFormacion/nuevoCentroFormacion.jsp");
	}
}