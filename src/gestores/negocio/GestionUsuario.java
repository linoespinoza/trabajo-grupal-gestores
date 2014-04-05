package gestores.negocio;

import gestores.dao.UsuarioDAO;
import gestores.enums.FiltroBusquedaUsuario;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Usuario;
import gestores.util.NumeroUtil;

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

	public int insertar(Usuario usuario) throws DAOExcepcion, NegocioExcepcion {
		UsuarioDAO dao = new UsuarioDAO();

		if (!NumeroUtil.esDocumentoValido(usuario.getTipoDocumento(),
				usuario.getNumeroDocumento())) {
			throw new NegocioExcepcion(
					NumeroUtil.obtenerMensajeDocumentoValido(usuario
							.getTipoDocumento()));
		}
		if (dao.esRegistradoTipoDocumento(usuario.getCodigo(), usuario
				.getTipoDocumento().getCodigo(), usuario.getNumeroDocumento())) {
			throw new NegocioExcepcion("");
		}
		if (dao.esRegistradoEmail(usuario.getCodigo(), usuario.getEmail())) {
			throw new NegocioExcepcion("");
		}
		return dao.insertar(usuario);
	}

	public Usuario obtener(Integer codigo) throws DAOExcepcion,
			NegocioExcepcion {
		UsuarioDAO dao = new UsuarioDAO();

		Usuario usuario = dao.obtener(codigo);
		if (usuario == null) {
			throw new NegocioExcepcion("");
		}
		return usuario;
	}

	public int eliminar(Integer codigo) throws DAOExcepcion {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.eliminar(codigo);
	}

	public int actualizar(Usuario usuario) throws DAOExcepcion,
			NegocioExcepcion {
		UsuarioDAO dao = new UsuarioDAO();

		if (!NumeroUtil.esDocumentoValido(usuario.getTipoDocumento(),
				usuario.getNumeroDocumento())) {
			throw new NegocioExcepcion(
					NumeroUtil.obtenerMensajeDocumentoValido(usuario
							.getTipoDocumento()));
		}
		if (dao.esRegistradoTipoDocumento(usuario.getCodigo(), usuario
				.getTipoDocumento().getCodigo(), usuario.getNumeroDocumento())) {
			throw new NegocioExcepcion("");
		}
		if (dao.esRegistradoEmail(usuario.getCodigo(), usuario.getEmail())) {
			throw new NegocioExcepcion("");
		}
		return dao.actualizar(usuario);
	}

	public Usuario autenticar(String email, String contrasenia)
			throws DAOExcepcion, NegocioExcepcion {
		UsuarioDAO dao = new UsuarioDAO();

		Usuario usuario = dao.autenticar(email, contrasenia);

		if (usuario == null) {
			throw new NegocioExcepcion("Usuario y/o contraseña incorrectos");
		}
		return usuario;
	}
}