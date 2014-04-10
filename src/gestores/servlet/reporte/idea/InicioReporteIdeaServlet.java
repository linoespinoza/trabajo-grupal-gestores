package gestores.servlet.reporte.idea;

import gestores.constante.GeneralConstante;
import gestores.enums.EstadoIdea;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.GestionEvaluador;

import java.io.IOException;
import java.util.Collection;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Marco Chumpitaz
 */
@WebServlet("/InicioReporteIdeaServlet")
public class InicioReporteIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public InicioReporteIdeaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		iniciari(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		iniciari(request, response);
	}
	
	private void iniciari(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	
		GestionEvaluador negocioev = new GestionEvaluador();
		
		try {
			HttpSession session = request.getSession();
			Usuario usuarioActual = (Usuario) session.getAttribute("usuarioActual");
			
			Collection<Idea> listado = negocioev.listar(usuarioActual);

			session.setAttribute("listaEstadoIdea", EstadoIdea.values());
			session.setAttribute("listax", listado);
			
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}
		response.sendRedirect("jsp/reporte/idea/reporteIdeas.jsp");
	}
}
