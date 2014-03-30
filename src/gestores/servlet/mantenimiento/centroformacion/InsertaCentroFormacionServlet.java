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

/**
 * @author Harry Bravo.
 */
@WebServlet("/InsertaCentroFormacionServlet")
public class InsertaCentroFormacionServlet extends HttpServlet {

	private static final long serialVersionUID = -2824916743031642534L;

	public InsertaCentroFormacionServlet() {
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
			String nombreArchivo = "";

			if (ServletFileUpload.isMultipartContent(request)) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(CentroFormacionConstante.MEMORY_THRESHOLD);
				factory.setRepository(new File(FileUtils.getTempDirectoryPath()));

				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setFileSizeMax(CentroFormacionConstante.MAX_FILE_SIZE);
				upload.setSizeMax(CentroFormacionConstante.MAX_REQUEST_SIZE);

				File directorioLogo = new File(getServletContext().getRealPath(
						CentroFormacionConstante.DIRECTORIO_LOGO));
				if (!directorioLogo.exists()) {
					directorioLogo.mkdirs();
				}

				List<FileItem> items = upload.parseRequest(request);

				if (items != null && !items.isEmpty()) {
					CentroFormacion centroFormacion = new CentroFormacion();
					centroFormacion.setCodigo(items.get(0).getString());
					centroFormacion.setNombre(items.get(1).getString());
					centroFormacion.setTipoCentroFormacion(TipoCentroFormacion
							.getTipoCentroFormacion(items.get(2).getString()));
					centroFormacion.setUrl(items.get(3).getString());

					PlanTarifario planTarifario = new PlanTarifario();
					planTarifario.setCodigo(Integer.parseInt(items.get(4)
							.getString()));
					centroFormacion.setPlanTarifario(planTarifario);

					session.setAttribute("centroFormacion", centroFormacion);

					if (!NumeroUtil.esNumeroRuc(centroFormacion.getCodigo())) {
						request.setAttribute("mensaje",
								GeneralConstante.ERROR_RUC);
						RequestDispatcher requestDispatcher = request
								.getRequestDispatcher("/jsp/mantenimiento/centroFormacion/nuevoCentroFormacion.jsp");
						requestDispatcher.forward(request, response);
						return;
					}

					if (!items.get(5).isFormField()) {
						nombreArchivo = new File(items.get(5).getName())
								.getName();
						centroFormacion.setLogo(nombreArchivo);
						File archivo = new File(
								getServletContext()
										.getRealPath(
												CentroFormacionConstante.DIRECTORIO_LOGO)
										+ File.separator + nombreArchivo);
						items.get(5).write(archivo);
					}
					gestionCentroFormacion.insertar(centroFormacion);
				}
			}
			session.removeAttribute("listaPlanTarifario");
		} catch (DAOExcepcion e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_GENERAL);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/jsp/mantenimiento/centroFormacion/nuevoCentroFormacion.jsp");
			requestDispatcher.forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("mensaje", GeneralConstante.ERROR_UPLOAD);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/jsp/mantenimiento/centroFormacion/nuevoCentroFormacion.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		response.sendRedirect("InicioCentroFormacionServlet");
	}
}