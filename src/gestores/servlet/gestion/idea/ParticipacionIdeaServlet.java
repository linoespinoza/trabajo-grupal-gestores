package gestores.servlet.gestion.idea;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gestores.constante.ParticipacionIdeaConstante;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.GestionIdea;

/**
 * Servlet implementation class Busqueda
 */
@WebServlet("/ParticipacionIdeaServlet")
public class ParticipacionIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParticipacionIdeaServlet() {
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
		String MSG="";
		//String codigoCE="";
		//String centro="";
		//String tipo="";
		System.out.println("ParticipacionServlet");
		try {
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuarioActual");
			String codigoCE = usuario.getCentroFormacion().getCodigo();
			String centro =  usuario.getCentroFormacion().getNombre();
			System.out.println("ParticipacionServlet Try");
			GestionIdea negocio = new GestionIdea();
			String cadena = request.getParameter("search");
			String estado = "PUB";
			System.out.println("ParticipacionServlet cadena = " + cadena);
			System.out.println("ParticipacionServlet estado = " + estado);
			System.out.println("ParticipacionServlet RUC = " + codigoCE);
			System.out.println("ParticipacionServlet centro = " + centro);
			List<Idea> listado;
			listado = negocio.buscarParticipacionIdea(cadena,codigoCE);
			if ((listado.size())>0){
				System.out.println("Mayor que 0 "+ listado.size());
				request.setAttribute("ParticipacionIdeas", listado);
			}else{
				System.out.println("Igual a 0" + listado.size());
				MSG=ParticipacionIdeaConstante.SIN_REGISTROS_IDEA;
				request.setAttribute("MENSAJE", MSG);
			}
			request.setAttribute("CENTRO", centro);
//codigo al final 
		} catch (DAOExcepcion e) {
			MSG=ParticipacionIdeaConstante.ERR_BASE_DATOS_IDEA;
			request.setAttribute("MENSAJE", MSG);
			
			System.out.println(ParticipacionIdeaConstante.ERR_BASE_DATOS_CONEXION_IDEA);
			e.printStackTrace();
		}
		System.out.println("ParticipacionServlet regresa participacionIdeas.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/" + ParticipacionIdeaConstante.PAG_PARTICIPACION_IDEA);
		rd.forward(request, response);
	}

}
