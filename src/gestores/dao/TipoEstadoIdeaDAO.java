package gestores.dao;

import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.TipoEstadoIdea;
import gestores.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class TipoEstadoIdeaDAO extends BaseDAO{

	public TipoEstadoIdea insertar(TipoEstadoIdea vo) throws DAOExcepcion {
		String query = "insert into tipoestadoidea(CoESTADO,TxDescripcion) values (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, vo.getIdEstadoIdea());
			stmt.setString(2, vo.getDescripcion());
			
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

	public Collection<TipoEstadoIdea> listar() throws DAOExcepcion {
		Collection<TipoEstadoIdea> t = new ArrayList<TipoEstadoIdea>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select TxDescripcion from TipoEstadoIdea order by CoESTADO";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				TipoEstadoIdea vo = new TipoEstadoIdea();
				vo.setDescripcion(rs.getString("i.TxDescripcion"));
				t.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);			this.cerrarConexion(con);
		}
		return t;
	}

	public TipoEstadoIdea buscarDescripcion(TipoEstadoIdea vo) throws DAOExcepcion {
		String query = "select TxDescripcion from TipoEstadoIdea where CoESTADO,TxDescripcion) values (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, vo.getIdEstadoIdea());
			stmt.setString(2, vo.getDescripcion());
			
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
	
}
