package gestores.servlet.mantenimiento.centroformacion;

import gestores.constante.GeneralConstante;
import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.negocio.GestionCentroFormacion;

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
@WebServlet("/InicioCentroFormacionServlet")
public class InicioCentroFormacionServlet extends HttpServlet {

	private static final long serialVersionUID = 7443044373641519929L;

	public InicioCentroFormacionServlet() {
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
		GestionCentroFormacion gestionCentroFormacion = new GestionCentroFormacion();
		try {
			HttpSession session = request.getSession();

			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setNombre("");
			centroFormacion.setTipoCentroFormacion(null);

			List<CentroFormacion> listaCentroFormacion = gestionCentroFormacion
					.listar(centroFormacion);

			session.setAttribute("listaTipoCentroFormacion",
					TipoCentroFormacion.values());
			session.setAttribute("listaCentroFormacion", listaCentroFormacion);
			session.removeAttribute("centroFormacion");
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		response.sendRedirect("jsp/mantenimiento/centroFormacion/mantenimientoCentroFormacion.jsp");
	}
}