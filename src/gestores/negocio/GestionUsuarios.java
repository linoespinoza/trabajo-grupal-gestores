package gestores.negocio;

import gestores.dao.UsuarioDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Usuario;

import java.util.Collection;

public class GestionUsuarios {
	
	public Collection<Usuario> buscarNombre_Usuario(int codigo) throws DAOExcepcion {
		
		UsuarioDAO dao = new UsuarioDAO();
		return dao.buscarNombre_usuario(codigo);
	}
	
}