package gestores.servlet.mantenimiento.usuario;

import gestores.constante.GeneralConstante;
import gestores.constante.UsuarioConstante;
import gestores.exception.DAOExcepcion;
import gestores.negocio.GestionUsuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jeremías Yalta.
 */
@WebServlet("/EliminaUsuarioServlet")
public class EliminaUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 9003186291231676725L;

	public EliminaUsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GestionUsuario gestionUsuario = new GestionUsuario();
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			gestionUsuario.eliminar(codigo);
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/"
				+ UsuarioConstante.SER_INI_USUARIO);
		requestDispatcher.forward(request, response);
	}
}