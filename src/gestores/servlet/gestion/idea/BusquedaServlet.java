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

import gestores.constante.BusquedaIdeaConstante;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.GestionIdea;

/**
 * Servlet implementation class Busqueda
 */
@WebServlet("/BusquedaServlet")
public class BusquedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaServlet() {
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
		String codigoCE="";
		String centro="";
		String tipo="";
		System.out.println("BusquedaServlet");
		try {
			
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuarioActual");
			codigoCE = usuario.getCentroFormacion().getCodigo();
			centro =  usuario.getCentroFormacion().getNombre();
			System.out.println("BusquedaServlet Try");
			GestionIdea negocio = new GestionIdea();
			String cadena = request.getParameter("search");
			String estado = request.getParameter("state");
			System.out.println("BusquedaServlet RUC = "+codigoCE);
			System.out.println("BusquedaServlet centro = "+centro);
			List<Idea> listado;
			listado = negocio.buscarCadenaIdea(cadena,estado,codigoCE);
			if ((listado.size())>0){
				//System.out.println(listado.size());
				request.setAttribute("BusquedaIdeas", listado);
			}else{
				//System.out.println(listado.size());
				MSG=BusquedaIdeaConstante.SIN_REGISTROS_IDEA;
				request.setAttribute("MENSAJE", MSG);
			}
			request.setAttribute("CENTRO", centro);
//codigo al final 
		} catch (DAOExcepcion e) {
			MSG=BusquedaIdeaConstante.ERR_BASE_DATOS_IDEA;
			request.setAttribute("MENSAJE", MSG);
			
			System.out.println(BusquedaIdeaConstante.ERR_BASE_DATOS_CONEXION_IDEA);
			e.printStackTrace();
		}
		System.out.println("BusquedaServlet regresa busquedaIdeas.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/" + BusquedaIdeaConstante.PAG_BUSQUEDA_IDEA);
		rd.forward(request, response);
	}

}
