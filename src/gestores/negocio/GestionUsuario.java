package gestores.negocio;

import gestores.constante.UsuarioConstante;
import gestores.dao.UsuarioDAO;
import gestores.enums.FiltroBusquedaUsuario;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Usuario;
import gestores.util.NumeroUtil;

import java.util.Collection;
import java.util.List;

/**
 * @author Jerem�as Yalta.
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
		if (!NumeroUtil.esNumeroCelular(usuario.getNumeroCelular())) {
			throw new NegocioExcepcion(UsuarioConstante.MSJ_VALID_NRO_CELULAR);
		}
		if (dao.esRegistradoTipoDocumento(usuario.getCodigo(), usuario
				.getTipoDocumento().getCodigo(), usuario.getNumeroDocumento())) {
			throw new NegocioExcepcion(UsuarioConstante.MSJ_VALID_DOCUMENTO);
		}
		if (dao.esRegistradoEmail(usuario.getCodigo(), usuario.getEmail())) {
			throw new NegocioExcepcion(UsuarioConstante.MSJ_VALID_EMAIL);
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
		if (!NumeroUtil.esNumeroCelular(usuario.getNumeroCelular())) {
			throw new NegocioExcepcion(UsuarioConstante.MSJ_VALID_NRO_CELULAR);
		}
		if (dao.esRegistradoTipoDocumento(usuario.getCodigo(), usuario
				.getTipoDocumento().getCodigo(), usuario.getNumeroDocumento())) {
			throw new NegocioExcepcion(UsuarioConstante.MSJ_VALID_DOCUMENTO);
		}
		if (dao.esRegistradoEmail(usuario.getCodigo(), usuario.getEmail())) {
			throw new NegocioExcepcion(UsuarioConstante.MSJ_VALID_EMAIL);
		}
		return dao.actualizar(usuario);
	}

	public Usuario autenticar(String email, String contrasenia)
			throws DAOExcepcion, NegocioExcepcion {
		UsuarioDAO dao = new UsuarioDAO();

		Usuario usuario = dao.autenticar(email, contrasenia);

		if (usuario == null) {
			throw new NegocioExcepcion(UsuarioConstante.MSJ_VALID_AUTENTICACION);
		}
		return usuario;
	}

	/*
	 * Alex Valencia
	 */
	public Collection<Usuario> buscarNombre_Usuario(int codigo)
			throws DAOExcepcion {

		UsuarioDAO dao = new UsuarioDAO();
		return dao.buscarNombre_Usuario(codigo);
	}
}