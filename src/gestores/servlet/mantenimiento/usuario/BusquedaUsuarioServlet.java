package gestores.servlet.mantenimiento.usuario;

import gestores.constante.GeneralConstante;
import gestores.constante.UsuarioConstante;
import gestores.enums.FiltroBusquedaUsuario;
import gestores.enums.TipoUsuario;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Usuario;
import gestores.negocio.GestionUsuario;

import java.io.IOException;
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
@WebServlet("/BusquedaUsuarioServlet")
public class BusquedaUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 3723572656248331721L;

	public BusquedaUsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GestionUsuario gestionUsuario = new GestionUsuario();
		try {
			HttpSession session = request.getSession();

			String codigoFiltro = request.getParameter("codigoFiltro");
			String nombre = request.getParameter("nombre");
			String tipo = request.getParameter("tipo");

			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			if (StringUtils.isNotBlank(tipo)) {
				usuario.setTipoUsuario(TipoUsuario.getTipoUsuario(tipo));
			}
			request.setAttribute("codigoFiltro", codigoFiltro);
			request.setAttribute("usuario", usuario);

			List<Usuario> listaUsuario = gestionUsuario.listar(
					FiltroBusquedaUsuario
							.getFiltroBusquedaUsuario(codigoFiltro), usuario);

			session.setAttribute("listaUsuario", listaUsuario);
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/"
				+ UsuarioConstante.PAG_MANT_USUARIO);
		requestDispatcher.forward(request, response);
	}
}