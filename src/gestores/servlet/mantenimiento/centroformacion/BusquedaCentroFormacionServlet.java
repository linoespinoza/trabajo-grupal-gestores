package gestores.servlet.mantenimiento.centroformacion;

import gestores.constante.CentroFormacionConstante;
import gestores.constante.GeneralConstante;
import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.negocio.GestionCentroFormacion;

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
@WebServlet("/BusquedaCentroFormacionServlet")
public class BusquedaCentroFormacionServlet extends HttpServlet {

	private static final long serialVersionUID = 342356583686473095L;

	public BusquedaCentroFormacionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GestionCentroFormacion gestionCentroFormacion = new GestionCentroFormacion();
		try {
			HttpSession session = request.getSession();

			String nombre = request.getParameter("nombre");
			String tipo = request.getParameter("tipo");

			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setNombre(nombre);
			centroFormacion.setTipoCentroFormacion(TipoCentroFormacion
					.getTipoCentroFormacion(tipo));

			request.setAttribute("centroFormacion", centroFormacion);

			List<CentroFormacion> listaCentroFormacion = gestionCentroFormacion
					.listar(centroFormacion);

			session.setAttribute("listaCentroFormacion", listaCentroFormacion);
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/"
				+ CentroFormacionConstante.PAG_MANT_CENTRO_FORMACION);
		requestDispatcher.forward(request, response);
	}
}