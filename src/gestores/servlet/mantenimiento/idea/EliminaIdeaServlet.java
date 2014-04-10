package gestores.servlet.mantenimiento.idea;

import gestores.constante.GeneralConstante;
import gestores.constante.IdeaConstante;
import gestores.exception.DAOExcepcion;
import gestores.negocio.GestionIdea;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EliminaIdeaServlet
 */
@WebServlet("/EliminaIdeaServlet")
public class EliminaIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaIdeaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestionIdea gestionIdea = new GestionIdea();
		try {
			String codigo = request.getParameter("codigo");
			gestionIdea.eliminar(codigo);
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/"
				+ IdeaConstante.SER_INI_IDEA);
		requestDispatcher.forward(request, response);
	}

}
