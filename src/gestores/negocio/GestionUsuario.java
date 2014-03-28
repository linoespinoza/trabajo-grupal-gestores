package gestores.negocio;

import gestores.dao.UsuarioDAO;
import gestores.enums.FiltroBusquedaUsuario;
import gestores.exception.DAOExcepcion;
import gestores.exception.LoginExcepcion;
import gestores.modelo.Usuario;

import java.util.List;

/**
 * @author Jeremías Yalta.
 */
public class GestionUsuario {

	public List<Usuario> listar(FiltroBusquedaUsuario filtroBusquedaUsuario,
			Usuario usuario) throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.listar(filtroBusquedaUsuario, usuario);
	}

	public Usuario insertar(Usuario usuario) throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.insertar(usuario);
	}

	public Usuario obtener(Integer codigo) throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.obtener(codigo);
	}

	public void eliminar(Integer codigo) throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		dao.eliminar(codigo);
	}

	public Usuario actualizar(Usuario usuario) throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.actualizar(usuario);
	}

	public Usuario autenticar(String email, String contrasenia)
			throws DAOExcepcion, LoginExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.autenticar(email, contrasenia);
	}
}