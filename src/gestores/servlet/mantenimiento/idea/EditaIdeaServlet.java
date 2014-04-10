package gestores.servlet.mantenimiento.idea;

import gestores.constante.GeneralConstante;
import gestores.constante.IdeaConstante;
import gestores.modelo.Idea;
import gestores.negocio.GestionIdea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditaIdeaServlet
 */
@WebServlet("/EditaIdeaServlet")
public class EditaIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditaIdeaServlet() {
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
		// TODO Auto-generated method stub
		GestionIdea gestionIdea = new GestionIdea();
		List<String> mensaje = new ArrayList<String>();
		
		try {
			HttpSession session = request.getSession();
			String codigo = request.getParameter("codigo");
			
			Idea idea = gestionIdea.obtener(codigo);
			
			session.setAttribute("idea",idea);
			
		} catch (Exception e) {
			mensaje.add(GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ IdeaConstante.PAG_MANT_IDEA);
			//requestDispatcher.forward(request, response);
			return;
		}
		
		request.setAttribute("mensaje", mensaje.size());
		response.sendRedirect(IdeaConstante.PAG_EDITA_IDEA);
	}

}
