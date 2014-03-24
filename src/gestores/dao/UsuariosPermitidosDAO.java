package gestores.dao;

import gestores.exception.DAOExcepcion;
import gestores.modelo.UsuariosPermitidos;
import gestores.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class UsuariosPermitidosDAO extends BaseDAO {

	public UsuariosPermitidos insertar_UsuariosPermitidos(UsuariosPermitidos vo) throws DAOExcepcion {
		
		String query = "insert into Usuario_Permitido(co_Usuario,co_Idea,Qt_Puntaje) values (?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, vo.getCoUsuario());
			stmt.setInt(2, vo.getCoIdea());
			//stmt.setInt(3, vo.getPuntaje());
			stmt.setInt(3, 0);
			
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

	public UsuariosPermitidos insertarPuntaje_UsuariosPermitidos(UsuariosPermitidos vo) throws DAOExcepcion {
		
		String query_u = "update Usuario_Permitido set Qt_Puntaje = ? where co_Usuario = ? and co_Idea = ? and Qt_Puntaje = 0;";
		Connection con_u = null;
		PreparedStatement stmt_u = null;
		ResultSet rs_u = null;
		try {
			con_u = ConexionBD.obtenerConexion();
			stmt_u = con_u.prepareStatement(query_u);

			stmt_u.setInt(1, vo.getPuntaje());
			stmt_u.setInt(2, vo.getCoUsuario());
			stmt_u.setInt(3, vo.getCoIdea());
			
			int i = stmt_u.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs_u);
			this.cerrarStatement(stmt_u);
			this.cerrarConexion(con_u);
		}
		return vo;
		
	}
	
	public Collection<UsuariosPermitidos> listar_UsuariosPermitidos() throws DAOExcepcion {
		
		Collection<UsuariosPermitidos> up = new ArrayList<UsuariosPermitidos>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select * from Usuario_Permitido;";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				UsuariosPermitidos vo = new UsuariosPermitidos();
				vo.setCoUsuario(rs.getInt("co_Usuario"));
				vo.setCoIdea(rs.getInt("co_Idea"));
				vo.setPuntaje(rs.getInt("Qt_Puntaje"));
							
				up.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return up;
	}
	
	public Collection<UsuariosPermitidos> buscarPuntaje_UsuariosPermitidos(int cousuario,int coidea) throws DAOExcepcion {
		Collection<UsuariosPermitidos> up = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select * from Usuario_Permitido where co_Usuario = ? and co_idea = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1,cousuario);
			stmt.setInt(2,coidea);
			rs = stmt.executeQuery();
			while (rs.next()) {
				UsuariosPermitidos vo = new UsuariosPermitidos();
				vo.setPuntaje(rs.getInt("Qt_Puntaje"));
				up.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);			
			this.cerrarConexion(con);
		}
		return up;
	}
	
}
