package gestores.servlet.gestion.idea;

import gestores.constante.ParticipacionIdeaConstante;
import gestores.exception.DAOExcepcion;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import gestores.constante.ParticipacionIdeaConstante;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.GestionIdea;


/**
 * Servlet implementation class InsertaParticipacionServlet
 */
@WebServlet("/InsertaParticipacionServlet")
public class InsertaParticipacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertaParticipacionServlet() {
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
		// TODO Auto-generated method stub
/*		String MSG="";
		try{
			System.out.println("InsertarParticipacion Try");
		} catch (DAOExcepcion e) {
			MSG=ParticipacionIdeaConstante.ERR_BASE_DATOS_IDEA;
			request.setAttribute("MENSAJE", MSG);
			
			System.out.println(ParticipacionIdeaConstante.ERR_BASE_DATOS_CONEXION_IDEA);
			e.printStackTrace();
		}*/
		
	}

}
