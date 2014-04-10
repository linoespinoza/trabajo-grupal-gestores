package gestores.servlet.reporte.pagos;

import gestores.constante.GeneralConstante;
import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.ReportePago;
import gestores.negocio.GestionPagos;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Marco Chumpitaz
 */
@WebServlet("/GenerarReportePagosServlet")
public class GenerarReportePagosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public GenerarReportePagosServlet() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionPagos negocio = new GestionPagos();
		try {
			
			String nombrecf = null;
			TipoCentroFormacion tipocf = null;
			String mes = null;
			int anio;
			
			if (StringUtils.isNotBlank(request.getParameter("nombre"))){
				nombrecf = request.getParameter("nombre");
			}
			if(StringUtils.isNotBlank(request.getParameter("tipo"))){
				tipocf = TipoCentroFormacion.getTipoCentroFormacion(request.getParameter("tipo"));
			}
			if(StringUtils.isNotBlank(request.getParameter("mes"))){
				mes = request.getParameter("mes");
			}
			
		
			CentroFormacion centrof = new CentroFormacion();
			centrof.setNombre(nombrecf);
			centrof.setTipoCentroFormacion(tipocf);

			ReportePago rpagoCF = new ReportePago();
			rpagoCF.setCentroFormacion(centrof);
			rpagoCF.setMesPago(mes);
			
			if(StringUtils.isNotBlank(request.getParameter("anio"))){
				anio = Integer.parseInt(request.getParameter("anio"));
				rpagoCF.setAnioPago(anio);
			}
			
			
			Collection<ReportePago> listaReportePago = negocio.listaPagos(rpagoCF);
			
			request.setAttribute("listaTipoCentroFormacion", TipoCentroFormacion.values());
			request.setAttribute("listaReportePagos", listaReportePago);
			
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
		}	
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/reporte/pagoCentroFormacion/reportePagos.jsp");
		rd.forward(request, response);
	}

}
