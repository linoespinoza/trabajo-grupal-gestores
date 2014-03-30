package gestores.dao;

import gestores.enums.FiltroBusquedaUsuario;
import gestores.enums.TipoDocumento;
import gestores.enums.TipoUsuario;
import gestores.exception.DAOExcepcion;
import gestores.exception.LoginExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Usuario;
import gestores.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeremías Yalta.
 */
public class UsuarioDAO extends BaseDAO {

	public Usuario autenticar(String email, String contrasenia)
			throws DAOExcepcion, LoginExcepcion {
		Usuario usuario = null;
		CentroFormacion centroFormacion = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Co_Usuario, No_Usuario, No_Ape_Paterno, No_Ape_Materno, Tx_Email, Nu_Celular, Co_Tipo_Usuario, Co_Centro_Formacion "
					+ "FROM USUARIO "
					+ "WHERE Tx_Email = ? AND Tx_Contrasenia = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			stmt.setString(1, email);
			stmt.setString(2, contrasenia);

			rs = stmt.executeQuery();
			if (rs.next()) {

				usuario = new Usuario();
				usuario.setCodigo(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellidoPaterno(rs.getString(3));
				usuario.setApellidoMaterno(rs.getString(4));
				usuario.setEmail(rs.getString(5));
				usuario.setNumeroCelular(rs.getString(6));
				usuario.setTipoUsuario(TipoUsuario.getTipoUsuario(rs
						.getString(7)));

				centroFormacion = new CentroFormacion();
				centroFormacion.setCodigo(rs.getString(8));
				usuario.setCentroFormacion(centroFormacion);
			} else {
				throw new LoginExcepcion("No existe usuario");
			}
		} catch (LoginExcepcion e) {
			System.err.println(e.getMessage());
			throw new LoginExcepcion(e.getMessage());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return usuario;
	}

	public List<Usuario> listar(FiltroBusquedaUsuario filtroBusquedaUsuario,
			Usuario usuario) throws DAOExcepcion {
		List<Usuario> lista = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String condicion = "";
			if (filtroBusquedaUsuario.equals(FiltroBusquedaUsuario.NOMBRE)) {
				condicion = "usu.No_Usuario LIKE ? ";
			} else if (filtroBusquedaUsuario
					.equals(FiltroBusquedaUsuario.APELLIDO_PATERNO)) {
				condicion = "usu.No_Ape_Paterno LIKE ? ";
			} else if (filtroBusquedaUsuario
					.equals(FiltroBusquedaUsuario.APELLIDO_MATERNO)) {
				condicion = "usu.No_Ape_Materno LIKE ? ";
			}

			if (usuario.getTipoUsuario() != null) {
				condicion += "AND usu.Co_Tipo_Usuario = ?";
			}
			String query = "SELECT usu.Co_Usuario, usu.No_Usuario, usu.No_Ape_Paterno, usu.No_Ape_Materno, usu.Tx_Email, usu.Nu_Celular, usu.Co_Tipo_Usuario, cfo.No_Centro_Formacion "
					+ "FROM USUARIO usu LEFT JOIN CENTRO_FORMACION cfo "
					+ "ON (usu.Co_Centro_Formacion = cfo.Co_Centro_Formacion) "
					+ "WHERE " + condicion;

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			if (filtroBusquedaUsuario.equals(FiltroBusquedaUsuario.NOMBRE)) {
				stmt.setString(1, "%" + usuario.getNombre() + "%");
			} else if (filtroBusquedaUsuario
					.equals(FiltroBusquedaUsuario.APELLIDO_MATERNO)) {
				stmt.setString(1, "%" + usuario.getApellidoPaterno() + "%");
			} else if (filtroBusquedaUsuario
					.equals(FiltroBusquedaUsuario.APELLIDO_PATERNO)) {
				stmt.setString(1, "%" + usuario.getApellidoMaterno() + "%");
			}

			if (usuario.getTipoUsuario() != null) {
				stmt.setString(2, usuario.getTipoUsuario().getCodigo());
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario vo = new Usuario();
				vo.setCodigo(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setApellidoPaterno(rs.getString(3));
				vo.setApellidoMaterno(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setNumeroCelular(rs.getString(6));
				vo.setTipoUsuario(TipoUsuario.getTipoUsuario(rs.getString(7)));

				CentroFormacion centroFormacion = new CentroFormacion();
				centroFormacion.setNombre(rs.getString(8));
				vo.setCentroFormacion(centroFormacion);
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return lista;
	}

	public Usuario insertar(Usuario vo) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "INSERT INTO USUARIO (No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getApellidoPaterno());
			stmt.setString(3, vo.getApellidoMaterno());
			stmt.setString(4, vo.getSexo());
			stmt.setString(5, vo.getTipoDocumento().getCodigo());
			stmt.setString(6, vo.getNumeroDocumento());
			stmt.setString(7, vo.getEmail());
			stmt.setString(8, vo.getNumeroCelular());
			stmt.setString(9, vo.getContrasenia());
			stmt.setString(10, vo.getTipoUsuario().getCodigo());
			stmt.setString(11, vo.getCentroFormacion().getCodigo());

			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public Usuario obtener(Integer codigo) throws DAOExcepcion {
		Usuario vo = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Co_Usuario, No_Usuario, No_Ape_Paterno, No_Ape_Materno, Fl_Sexo, Co_Tipo_Documento, Nu_Documento, Tx_Email, Nu_Celular, Tx_Contrasenia, Co_Tipo_Usuario, Co_Centro_Formacion "
					+ "FROM USUARIO WHERE Co_Usuario = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				vo = new Usuario();
				vo.setCodigo(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setApellidoPaterno(rs.getString(3));
				vo.setApellidoMaterno(rs.getString(4));
				vo.setSexo(rs.getString(5));
				vo.setTipoDocumento(TipoDocumento.getTipoDocumento(rs
						.getString(6)));
				vo.setNumeroDocumento(rs.getString(7));
				vo.setEmail(rs.getString(8));
				vo.setNumeroCelular(rs.getString(9));
				vo.setContrasenia(rs.getString(10));
				vo.setTipoUsuario(TipoUsuario.getTipoUsuario(rs.getString(11)));

				CentroFormacion centroFormacion = new CentroFormacion();
				centroFormacion.setCodigo(rs.getString(12));
				vo.setCentroFormacion(centroFormacion);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public void eliminar(Integer codigo) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "DELETE FROM USUARIO WHERE Co_Usuario = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codigo);
			int i = stmt.executeUpdate();

			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public Usuario actualizar(Usuario vo) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "UPDATE USUARIO SET No_Usuario = ?, No_Ape_Paterno = ?, No_Ape_Materno = ?, Fl_Sexo = ?, Co_Tipo_Documento = ?, Nu_Documento = ?, Tx_Email = ?, Nu_Celular = ?, Co_Tipo_Usuario = ?, Co_Centro_Formacion = ? "
					+ "WHERE Co_Usuario = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getApellidoPaterno());
			stmt.setString(3, vo.getApellidoMaterno());
			stmt.setString(4, vo.getSexo());
			stmt.setString(5, vo.getTipoDocumento().getCodigo());
			stmt.setString(6, vo.getNumeroDocumento());
			stmt.setString(7, vo.getEmail());
			stmt.setString(8, vo.getNumeroCelular());
			stmt.setString(9, vo.getTipoUsuario().getCodigo());
			stmt.setString(10, vo.getCentroFormacion().getCodigo());
			stmt.setInt(11, vo.getCodigo());

			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
}