package gestores.servlet.mantenimiento.idea;

import gestores.constante.GeneralConstante;
import gestores.constante.IdeaConstante;
import gestores.enums.EstadoIdea;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.GestionIdea;
import gestores.util.ArchivoUtil;
import gestores.util.FechaUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ActualizaIdeaServlet
 */
@WebServlet("/ActualizaIdeaServlet")
public class ActualizaIdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizaIdeaServlet() {
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
		
		GestionIdea gestionIdea = new GestionIdea();
		List<String> mensaje = new ArrayList<String>();
		
		try {
			HttpSession session = request.getSession();
			Idea idea = setearDatosEntrada(request);
			session.setAttribute("idea", idea);
			gestionIdea.actualizar(idea);
			
		} catch (NegocioExcepcion e) {
			mensaje.add(e.getMessage());
			request.setAttribute("mensaje", mensaje);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ IdeaConstante.PAG_EDITA_IDEA);
			requestDispatcher.forward(request, response);
			return;
		} catch (DAOExcepcion e) {
			mensaje.add(GeneralConstante.ERROR_CONEXION_BASE_DATOS);
			request.setAttribute("mensaje", mensaje);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ IdeaConstante.PAG_EDITA_IDEA);
			requestDispatcher.forward(request, response);
			return;
		} catch (Exception e) { 
			mensaje.add(GeneralConstante.ERROR_GENERAL);
			request.setAttribute("mensaje", mensaje);
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/"
							+ IdeaConstante.PAG_EDITA_IDEA);
			requestDispatcher.forward(request, response);
			return;
		}
		
		//request.setAttribute("mensaje", mensaje.size());
		
		//System.out.println(mensaje.size());
		response.sendRedirect(IdeaConstante.SER_INI_IDEA);
	}
	
	private Idea setearDatosEntrada(HttpServletRequest request) throws Exception {
		
		Idea idea = null;
		String nombreArchivo = null;
		String directorioArchivoIdea = getServletContext().getRealPath(IdeaConstante.DIRECTORIO_IMAGEN_IDEA);
		
		if (ServletFileUpload.isMultipartContent(request)) {
			ServletFileUpload upload = ArchivoUtil.obtenerUpload(request);
			ArchivoUtil.crearDirectorio(directorioArchivoIdea);
			
			List<FileItem> items = upload.parseRequest(request);
			
			if (items != null && !items.isEmpty()) {
				if (StringUtils.isNotBlank(items.get(8).getName())) {
					nombreArchivo = new File(items.get(8).getName()).getName();

					System.out.println(nombreArchivo);
					File archivo = new File(directorioArchivoIdea + File.separator
							+ nombreArchivo);
					items.get(8).write(archivo);
				}
				
				HttpSession session = request.getSession();
				Usuario estudiante = (Usuario) session.getAttribute("usuarioActual");
				
				idea = new Idea();
				idea.setCodigo(Integer.parseInt(items.get(1).getString()));
				idea.setTitulo(items.get(2).getString());
				idea.setDescripcion(items.get(3).getString());
				idea.setPalabrasClave(items.get(4).getString()+','+
						items.get(5).getString()+','+items.get(6).getString()+','+items.get(7).getString());
				idea.setArchivo(nombreArchivo);
				idea.setFechaCreacion(FechaUtil.parsearFechaHora("2014-04-05 10:30:45"));
				idea.setEstudiante(estudiante);
				idea.setEstadoIdea(EstadoIdea.CREADA);
			}
		}
		return idea;
	}

}
