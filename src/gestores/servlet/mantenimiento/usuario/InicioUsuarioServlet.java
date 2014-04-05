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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Jeremías Yalta.
 */
@WebServlet("/InicioUsuarioServlet")
public class InicioUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -1730025169920311600L;

	public InicioUsuarioServlet() {
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
		GestionUsuario gestionUsuario = new GestionUsuario();
		try {
			HttpSession session = request.getSession();

			Usuario usuario = new Usuario();
			usuario.setNombre("");

			List<Usuario> listaUsuario = gestionUsuario.listar(
					FiltroBusquedaUsuario.NOMBRE, usuario);

			session.setAttribute("listaFiltroBusqueda",
					FiltroBusquedaUsuario.values());
			session.setAttribute("listaTipoUsuario", TipoUsuario.values());
			session.setAttribute("listaUsuario", listaUsuario);
			session.removeAttribute("usuario");
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		response.sendRedirect(UsuarioConstante.PAG_MANT_USUARIO);
	}
}