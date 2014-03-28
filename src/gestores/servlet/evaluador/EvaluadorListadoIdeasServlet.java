package gestores.servlet.evaluador;

import gestores.enums.EstadoIdea;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.GestionEvaluador;
import gestores.util.FechaUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;



/**
 * Servlet implementation class EvaluadorListadoIdeasServlet
 */
@WebServlet("/EvaluadorListadoIdeasServlet")
public class EvaluadorListadoIdeasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EvaluadorListadoIdeasServlet() {
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
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		String criterio = request.getParameter("criterio");
		String criterio_txt = request.getParameter("txtcriterio");
		String desde = request.getParameter("desde");
		String hasta = request.getParameter("hasta");
		String estado = request.getParameter("estado");
		Date fecha_ini = null;//formatter.parse(desde);
		Date fecha_fin = null;//formatter.parse(hasta);
		
		Idea ideab = new Idea();
		switch(criterio) {
			case "Titulo":
				ideab.setTitulo(criterio_txt);
			break;
			case "Descripcion":
				ideab.setDescripcion(criterio_txt);
				break;
			case "Palabras_clave":
				ideab.setPalabrasClave(criterio_txt);
				break;
		}
		
		
		switch(estado) {
			case "Creada":
				ideab.setEstadoIdea(EstadoIdea.Creada);	
			break;
			case "Aprobada":
				ideab.setEstadoIdea(EstadoIdea.Aprobada);	
			break;
			case "Rechazada":
				ideab.setEstadoIdea(EstadoIdea.Rechazada);	
			break;
			case "Publicada":
				ideab.setEstadoIdea(EstadoIdea.Publicada);	
			break;
		}
		
		CentroFormacion centroFormacion = new CentroFormacion(); 
		centroFormacion.setCodigo("10334522659");
		
		Usuario evaluador  = new Usuario();
		evaluador.setCentroFormacion(centroFormacion);
		
		GestionEvaluador negocio = new GestionEvaluador();
		
		try {
		List<Idea> lista = negocio.listaIdeasporCF(evaluador, ideab, fecha_ini, fecha_fin);
			
		// Guardar en el ambiente de request
			request.setAttribute("listax", lista);
			
		RequestDispatcher rd = request.getRequestDispatcher("evaluador_listado_ideas.jsp");
		rd.forward(request, response);
		} catch (gestores.exception.DAOExcepcion e) {
			System.out.println(e.getMessage());
		}
	}
}