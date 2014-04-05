package gestores.servlet.mantenimiento.usuario;

import gestores.constante.GeneralConstante;
import gestores.constante.UsuarioConstante;
import gestores.enums.TipoDocumento;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Usuario;
import gestores.negocio.GestionUsuario;
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
@WebServlet("/EditaUsuarioServlet")
public class EditaUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -4946639447137471749L;

	public EditaUsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GestionUsuario gestionUsuario = new GestionUsuario();
		ListasComunes listasComunes = new ListasComunes();
		try {
			HttpSession session = request.getSession();
			int codigo = Integer.parseInt(request.getParameter("codigo"));

			List<CentroFormacion> listaCentroFormacion = listasComunes
					.listarCentroFormacion();
			Usuario usuario = gestionUsuario.obtener(codigo);

			session.setAttribute("usuario", usuario);
			session.setAttribute("listaCentroFormacion", listaCentroFormacion);
			session.setAttribute("listaTipoDocumento", TipoDocumento.values());
		} catch (NegocioExcepcion e) {
			request.setAttribute("mensaje", e.getMessage());
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ UsuarioConstante.PAG_MANT_USUARIO);
			requestDispatcher.forward(request, response);
			return;
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ UsuarioConstante.PAG_MANT_USUARIO);
			requestDispatcher.forward(request, response);
			return;
		}
		response.sendRedirect(UsuarioConstante.PAG_EDITA_USUARIO);
	}
}