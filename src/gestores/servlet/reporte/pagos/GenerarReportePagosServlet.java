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
import javax.servlet.http.HttpSession;

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
		try {
			HttpSession session = request.getSession();

			String nombrecf = request.getParameter("nombre");
			String tipocf = request.getParameter("tipo");
			String mes = request.getParameter("mes");
			int anio = Integer.parseInt(request.getParameter("anio"));
			
			CentroFormacion centrof = new CentroFormacion();
			centrof.setNombre(nombrecf);
			centrof.setTipoCentroFormacion(TipoCentroFormacion.getTipoCentroFormacion(tipocf));
			
			ReportePago rpagoCF = new ReportePago();
			rpagoCF.setCentroFormacion(centrof);
			rpagoCF.setAnioPago(anio);
			
			if (StringUtils.isNotBlank(mes)) {
				rpagoCF.setMesPago(mes);
			}
		
			GestionPagos negocio = new GestionPagos();
			Collection<ReportePago> listaReportePago = negocio.listaPagos(rpagoCF);
			
			session.setAttribute("listaTipoCentroFormacion", TipoCentroFormacion.values());
			session.setAttribute("listaReportePagos", listaReportePago);
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
