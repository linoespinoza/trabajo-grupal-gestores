package gestores.servlet.reporte.pagos;

import gestores.constante.GeneralConstante;
import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.ReportePago;
import gestores.negocio.GestionPagos;

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
@WebServlet("/InicioReportePagosServlet")
public class InicioReportePagosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InicioReportePagosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		iniciarp(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		iniciarp(request, response);
	}

	private void iniciarp(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GestionPagos gPagos = new GestionPagos(); 
		try {
			HttpSession session = request.getSession();

			Collection<ReportePago> listaReportePago = gPagos.listar();
			
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
		response.sendRedirect("jsp/reporte/pagoCentroFormacion/reportePagos.jsp");
	}
}
