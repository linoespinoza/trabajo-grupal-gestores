package gestores.negocio;

import gestores.dao.UsuariosPermitidosDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.UsuariosPermitidos;

import java.util.Collection;

public class GestionUsuariosPermitidos {

	public UsuariosPermitidos insertar_UsuariosPermitidos(UsuariosPermitidos vo) throws DAOExcepcion {
		
		UsuariosPermitidosDAO dao = new UsuariosPermitidosDAO();		 
		return dao.insertar_UsuariosPermitidos(vo);
		
	}

	public Collection<UsuariosPermitidos> listarPuntaje_ideas() throws DAOExcepcion {
		
		UsuariosPermitidosDAO dao = new UsuariosPermitidosDAO();
		return dao.listar_UsuariosPermitidos();
	}
	
	public Collection<UsuariosPermitidos> buscar_Puntaje(int usuario, int idea) throws DAOExcepcion {
		
		UsuariosPermitidosDAO dao = new UsuariosPermitidosDAO();
		return dao.buscarPuntaje_UsuariosPermitidos(usuario,idea);
	}
	
	public UsuariosPermitidos insertar_Puntaje(UsuariosPermitidos vo) throws DAOExcepcion {
		
		UsuariosPermitidosDAO dao = new UsuariosPermitidosDAO(); 
		return dao.insertarPuntaje_UsuariosPermitidos(vo);
	
	}
	
}
