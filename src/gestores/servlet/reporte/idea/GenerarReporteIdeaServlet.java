package gestores.servlet.reporte.idea;

import gestores.constante.GeneralConstante;
import gestores.enums.EstadoIdea;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.GestionEvaluador;
import gestores.util.FechaUtil;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Marco Chumpitaz
 */
@WebServlet("/GenerarReporteIdeaServlet")
public class GenerarReporteIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public GenerarReporteIdeaServlet() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			Usuario usuarioActual = (Usuario) session.getAttribute("usuarioActual");
			
			String criterio = request.getParameter("criterio");
			String criterio_txt = request.getParameter("txtcriterio");
			String estado = request.getParameter("estado");
			
			Date fecha_ini = null;
			Date fecha_fin = null;
			
			if (StringUtils.isNotBlank(request.getParameter("desde")) && StringUtils.isNotBlank(request.getParameter("hasta"))) {
				fecha_ini = FechaUtil.parsearFecha(request.getParameter("desde"));
				fecha_fin = FechaUtil.parsearFecha(request.getParameter("hasta"));
				session.setAttribute("fechaInicio", FechaUtil.formatearFecha(fecha_ini));
				session.setAttribute("fechaFin", FechaUtil.formatearFecha(fecha_fin));
			} else {
				session.removeAttribute("fechaInicio");
				session.removeAttribute("fechaFin");
			}			
			
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
		
			if (StringUtils.isNotBlank(estado)) {
				ideab.setEstadoIdea(EstadoIdea.getEstadoIdea(estado));
			}
		
			GestionEvaluador negocio = new GestionEvaluador();
		
			List<Idea> lista = negocio.listaIdeasporCF(usuarioActual, ideab, fecha_ini, fecha_fin);
			
			request.setAttribute("listaEstadoIdea",
					EstadoIdea.values());
				
			request.setAttribute("listax", lista);
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}	
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/reporte/idea/reporteIdeas.jsp");
		rd.forward(request, response);
		
	}

}
