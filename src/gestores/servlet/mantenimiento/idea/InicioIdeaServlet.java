package gestores.servlet.mantenimiento.idea;

import gestores.constante.CentroFormacionConstante;
import gestores.constante.GeneralConstante;
import gestores.constante.IdeaConstante;
import gestores.enums.EstadoIdea;
import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.GestionCentroFormacion;
import gestores.negocio.GestionIdea;
import gestores.negocio.GestionUsuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.EscapeTokenizer;

/**
 * Servlet implementation class InicioIdeaServlet
 */
@WebServlet("/InicioIdeaServlet")
public class InicioIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioIdeaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			iniciar(request, response);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			iniciar(request, response);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void iniciar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DAOExcepcion {
	
		GestionIdea gestionIdea = new GestionIdea();
		
		try {
			HttpSession session = request.getSession();
			Usuario usuarioActual = (Usuario) session.getAttribute("usuarioActual");
			if (usuarioActual == null) {
				request.getRequestDispatcher("error.jsp")
						.forward(request, response);
				return;
			}

			Idea idea = new Idea();
			idea.setTitulo("");
			idea.setDescripcion("");
			idea.setPalabrasClave("");
			idea.setArchivo("");
			idea.setEstudiante(null);
			idea.setEstadoIdea(null);
			
			List<Idea> listaIdea = gestionIdea.listarIdeasPorUsuario(usuarioActual);
			session.setAttribute("listaIdea", listaIdea);
			
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		response.sendRedirect(IdeaConstante.PAG_MANT_IDEA);
	}

}
