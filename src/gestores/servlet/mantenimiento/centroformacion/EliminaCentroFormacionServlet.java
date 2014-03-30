package gestores.servlet.mantenimiento.centroformacion;

import gestores.constante.GeneralConstante;
import gestores.exception.DAOExcepcion;
import gestores.negocio.GestionCentroFormacion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Harry Bravo.
 */
@WebServlet("/EliminaCentroFormacionServlet")
public class EliminaCentroFormacionServlet extends HttpServlet {

	private static final long serialVersionUID = -2824916743031642534L;

	public EliminaCentroFormacionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GestionCentroFormacion gestionCentroFormacion = new GestionCentroFormacion();
		try {
			String codigo = request.getParameter("codigo");
			gestionCentroFormacion.eliminar(codigo);
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/InicioCentroFormacionServlet");
		requestDispatcher.forward(request, response);
	}
}