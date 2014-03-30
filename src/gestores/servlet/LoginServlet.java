package gestores.servlet;

import gestores.exception.DAOExcepcion;
import gestores.exception.LoginExcepcion;
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

/**
 * @author Harry Bravo.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 2700361414490186248L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String email = request.getParameter("email");
			String contrasenia = request.getParameter("contrasenia");

			GestionUsuario gestionUsuario = new GestionUsuario();
			Usuario usuario = gestionUsuario.autenticar(email, contrasenia);

			session.setAttribute("usuarioActual", usuario);
			response.sendRedirect("PortadaServlet");
			return;
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					"Hubo un error al procesar la operación: " + e.getMessage());
			e.printStackTrace();
		} catch (LoginExcepcion e) {
			request.setAttribute("mensaje",
					"Usuario y/o contraseña incorrectos");
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request, response);
	}
}