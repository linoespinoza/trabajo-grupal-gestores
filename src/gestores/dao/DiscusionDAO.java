package gestores.dao;

import gestores.exception.DAOExcepcion;
import gestores.modelo.Discusion;
import gestores.util.ConexionBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class DiscusionDAO extends BaseDAO {

	public Discusion insertar(Discusion vo) throws DAOExcepcion {
		String query = "insert into discucion_idea(co_Discucion,Co_Idea,Co_Usuario,Tx_Comentario,Fe_Creacion) values (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, vo.getCoDiscusion());
			stmt.setInt(2, vo.getCoIdea());
			stmt.setInt(3, vo.getCoUsuario());
			stmt.setString(4, vo.getComentario());
			stmt.setDate(5, (Date) vo.getFechaCreacion());
			
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

	public Collection<Discusion> listar() throws DAOExcepcion {
		Collection<Discusion> d = new ArrayList<Discusion>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select * from discucion_idea;";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Discusion vo = new Discusion();
				vo.setCoDiscusion(rs.getInt("co_Discucion"));
				vo.setCoIdea(rs.getInt("co_Idea"));
				vo.setCoUsuario(rs.getInt("co_Usuario"));
				vo.setComentario(rs.getString("Tx_Comentario"));
				vo.setFechaCreacion(rs.getDate("Fe_Creacion"));
							
				d.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);			
			this.cerrarConexion(con);
		}
		return d;
	}
	
}
