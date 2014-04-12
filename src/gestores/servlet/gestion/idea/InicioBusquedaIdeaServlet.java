package gestores.servlet.gestion.idea;

import gestores.constante.BusquedaIdeaConstante;
import gestores.constante.GeneralConstante;
//import gestores.exception.DAOExcepcion;
//import gestores.modelo.Idea;
//import gestores.negocio.GestionIdea;

import gestores.modelo.Idea;
import gestores.modelo.Usuario;

import java.io.IOException;
//import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InicioBusquedaIdeaServlet
 */
@WebServlet("/InicioBusquedaIdeaServlet")
public class InicioBusquedaIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioBusquedaIdeaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		iniciar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		iniciar(request, response);
	}

	private void iniciar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
/*			String centro="";
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuarioActual");
			centro =  usuario.getCentroFormacion().getNombre();
			request.setAttribute("CENTRO", centro);
*/			
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		response.sendRedirect(BusquedaIdeaConstante.PAG_BUSQUEDA_IDEA);
	}
	
}
