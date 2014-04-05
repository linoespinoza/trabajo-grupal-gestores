package gestores.servlet.mantenimiento.usuario;

import gestores.constante.GeneralConstante;
import gestores.constante.UsuarioConstante;
import gestores.enums.TipoDocumento;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
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
@WebServlet("/NuevoUsuarioServlet")
public class NuevoUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 2991379571049678703L;

	public NuevoUsuarioServlet() {
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
			session.removeAttribute("usuario");

			List<CentroFormacion> listaCentroFormacion = listasComunes
					.listarCentroFormacion();

			session.setAttribute("listaCentroFormacion", listaCentroFormacion);
			session.setAttribute("listaTipoDocumento", TipoDocumento.values());
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ UsuarioConstante.PAG_MANT_USUARIO);
			requestDispatcher.forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ UsuarioConstante.PAG_MANT_USUARIO);
			requestDispatcher.forward(request, response);
			return;
		}
		response.sendRedirect(UsuarioConstante.PAG_NUEVO_USUARIO);
	}
}