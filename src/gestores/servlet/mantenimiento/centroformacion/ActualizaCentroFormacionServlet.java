package gestores.servlet.mantenimiento.centroformacion;

import gestores.constante.CentroFormacionConstante;
import gestores.constante.GeneralConstante;
import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.PlanTarifario;
import gestores.negocio.GestionCentroFormacion;
import gestores.util.NumeroUtil;

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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
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

			if (centroFormacion != null) {
				if (!NumeroUtil.esNumeroRuc(centroFormacion.getCodigo())) {
					session.setAttribute("centroFormacion", centroFormacion);

					request.setAttribute("mensaje", GeneralConstante.ERROR_RUC);
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("/jsp/mantenimiento/centroFormacion/nuevoCentroFormacion.jsp");
					requestDispatcher.forward(request, response);
					return;
				}
				gestionCentroFormacion.actualizar(centroFormacion);
			}
			session.removeAttribute("listaPlanTarifario");
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/jsp/mantenimiento/centroFormacion/editaCentroFormacion.jsp");
			requestDispatcher.forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_UPLOAD);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/jsp/mantenimiento/centroFormacion/editaCentroFormacion.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		response.sendRedirect("InicioCentroFormacionServlet");
	}

	private CentroFormacion setearDatosEntrada(HttpServletRequest request)
			throws Exception {
		CentroFormacion centroFormacion = null;
		String nombreArchivo = null;

		if (ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(CentroFormacionConstante.MEMORY_THRESHOLD);
			factory.setRepository(new File(FileUtils.getTempDirectoryPath()));

			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(CentroFormacionConstante.MAX_FILE_SIZE);
			upload.setSizeMax(CentroFormacionConstante.MAX_REQUEST_SIZE);

			File directorioLogo = new File(request.getServletContext()
					.getRealPath(CentroFormacionConstante.DIRECTORIO_LOGO));
			if (!directorioLogo.exists()) {
				directorioLogo.mkdirs();
			}
			List<FileItem> items = upload.parseRequest(request);

			if (items != null && !items.isEmpty()) {
				if (StringUtils.isNotBlank(items.get(5).getName())) {
					nombreArchivo = new File(items.get(5).getName()).getName();

					File archivo = new File(request.getServletContext()
							.getRealPath(
									CentroFormacionConstante.DIRECTORIO_LOGO)
							+ File.separator + nombreArchivo);
					items.get(5).write(archivo);
				}

				PlanTarifario planTarifario = new PlanTarifario();
				planTarifario.setCodigo(Integer.parseInt(items.get(4)
						.getString()));

				centroFormacion = new CentroFormacion();
				centroFormacion.setCodigo(items.get(0).getString());
				centroFormacion.setNombre(items.get(1).getString());
				centroFormacion.setTipoCentroFormacion(TipoCentroFormacion
						.getTipoCentroFormacion(items.get(2).getString()));
				centroFormacion.setUrl(items.get(3).getString());
				centroFormacion.setPlanTarifario(planTarifario);
				centroFormacion.setLogo(nombreArchivo);
			}
		}
		return centroFormacion;
	}
}