package gestores.servlet.mantenimiento.usuario;

import gestores.constante.GeneralConstante;
import gestores.constante.UsuarioConstante;
import gestores.enums.TipoDocumento;
import gestores.enums.TipoUsuario;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Usuario;
import gestores.negocio.GestionUsuario;

import java.io.IOException;

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
@WebServlet("/InsertaUsuarioServlet")
public class InsertaUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -8828032326784324307L;

	public InsertaUsuarioServlet() {
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
			Usuario usuario = setearDatosEntrada(request);
			session.setAttribute("usuario", usuario);

			gestionUsuario.insertar(usuario);
			session.removeAttribute("listaCentroFormacion");
			session.removeAttribute("listaTipoDocumento");
		} catch (NegocioExcepcion e) {
			request.setAttribute("mensaje", e.getMessage());
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ UsuarioConstante.PAG_NUEVO_USUARIO);
			requestDispatcher.forward(request, response);
			return;
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ UsuarioConstante.PAG_NUEVO_USUARIO);
			requestDispatcher.forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ UsuarioConstante.PAG_NUEVO_USUARIO);
			requestDispatcher.forward(request, response);
			return;
		}
		response.sendRedirect(UsuarioConstante.SER_INI_USUARIO);
	}

	private Usuario setearDatosEntrada(HttpServletRequest request)
			throws Exception {
		CentroFormacion centroFormacion = new CentroFormacion();
		if (StringUtils.isNotBlank(request.getParameter("centroFormacion"))) {
			centroFormacion.setCodigo(request.getParameter("centroFormacion"));
		}

		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setApellidoPaterno(request.getParameter("apellidoPaterno"));
		usuario.setApellidoMaterno(request.getParameter("apellidoMaterno"));
		usuario.setSexo(request.getParameter("sexo"));
		usuario.setTipoDocumento(TipoDocumento.getTipoDocumento(request
				.getParameter("tipoDocumento")));
		usuario.setNumeroDocumento(request.getParameter("numeroDocumento"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setNumeroCelular(request.getParameter("numeroCelular"));
		usuario.setContrasenia(request.getParameter("contrasenia"));
		usuario.setTipoUsuario(TipoUsuario.getTipoUsuario(request
				.getParameter("tipoUsuario")));
		usuario.setCentroFormacion(centroFormacion);

		return usuario;
	}
}