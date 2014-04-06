package gestores.servlet.mantenimiento.centroformacion;

import gestores.constante.CentroFormacionConstante;
import gestores.constante.GeneralConstante;
import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.PlanTarifario;
import gestores.negocio.GestionCentroFormacion;
import gestores.util.ArchivoUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Harry Bravo.
 */
@WebServlet("/ActualizaCentroFormacionServlet")
public class ActualizaCentroFormacionServlet extends HttpServlet {

	private static final long serialVersionUID = 7677590493795656067L;

	public ActualizaCentroFormacionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GestionCentroFormacion gestionCentroFormacion = new GestionCentroFormacion();
		try {
			HttpSession session = request.getSession();
			CentroFormacion centroFormacion = setearDatosEntrada(request);
			session.setAttribute("centroFormacion", centroFormacion);

			gestionCentroFormacion.actualizar(centroFormacion);
			session.removeAttribute("listaPlanTarifario");
		} catch (NegocioExcepcion e) {
			request.setAttribute("mensaje", e.getMessage());
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ CentroFormacionConstante.PAG_EDITA_CENTRO_FORMACION);
			requestDispatcher.forward(request, response);
			return;
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje",
					GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ CentroFormacionConstante.PAG_EDITA_CENTRO_FORMACION);
			requestDispatcher.forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ CentroFormacionConstante.PAG_EDITA_CENTRO_FORMACION);
			requestDispatcher.forward(request, response);
			return;
		}
		response.sendRedirect(CentroFormacionConstante.SER_INI_CENTRO_FORMACION);
	}

	private CentroFormacion setearDatosEntrada(HttpServletRequest request)
			throws Exception {
		CentroFormacion centroFormacion = null;
		String nombreArchivo = null;
		String directorioLogo = getServletContext().getRealPath(
				CentroFormacionConstante.DIRECTORIO_LOGO);

		if (ServletFileUpload.isMultipartContent(request)) {
			ServletFileUpload upload = ArchivoUtil.obtenerUpload(request);
			ArchivoUtil.crearDirectorio(directorioLogo);

			List<FileItem> items = upload.parseRequest(request);

			if (items != null && !items.isEmpty()) {
				if (StringUtils.isNotBlank(items.get(6).getName())) {
					nombreArchivo = new File(items.get(6).getName()).getName();

					File archivo = new File(directorioLogo + File.separator
							+ nombreArchivo);
					items.get(6).write(archivo);
				}

				PlanTarifario planTarifario = new PlanTarifario();
				planTarifario.setCodigo(Integer.parseInt(items.get(5)
						.getString()));

				centroFormacion = new CentroFormacion();
				centroFormacion.setCodigo(items.get(1).getString());
				centroFormacion.setNombre(items.get(2).getString());
				centroFormacion.setTipoCentroFormacion(TipoCentroFormacion
						.getTipoCentroFormacion(items.get(3).getString()));
				centroFormacion.setUrl(items.get(4).getString());
				centroFormacion.setPlanTarifario(planTarifario);
				centroFormacion.setLogo(nombreArchivo);
			}
		}
		return centroFormacion;
	}
}