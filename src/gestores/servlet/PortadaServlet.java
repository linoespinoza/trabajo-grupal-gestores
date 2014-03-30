package gestores.servlet;

import gestores.modelo.Usuario;

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
@WebServlet("/PortadaServlet")
public class PortadaServlet extends HttpServlet {

	private static final long serialVersionUID = -6304900361372007386L;

	public PortadaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Usuario usuarioActual = (Usuario) session.getAttribute("usuarioActual");
		if (usuarioActual == null) {
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
			return;
		}

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsp/principal.jsp");
		rd.forward(request, response);
	}
}
