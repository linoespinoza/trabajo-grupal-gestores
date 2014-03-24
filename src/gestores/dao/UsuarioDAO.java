package gestores.dao;

import gestores.exception.DAOExcepcion;
import gestores.modelo.Usuario;
import gestores.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class UsuarioDAO extends BaseDAO {
	
	public Collection<Usuario> buscarNombre_usuario(int codigo) throws DAOExcepcion {
		Collection<Usuario> u = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select * from Usuario where co_Usuario = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1,codigo);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario vo = new Usuario();
				vo.setNombre(rs.getString("No_Usuario"));
				vo.setApellidoPaterno(rs.getString("No_Ape_Paterno"));
				vo.setApellidoMaterno(rs.getString("No_Ape_Materno"));
				u.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);			
			this.cerrarConexion(con);
		}
		return u;
	}
	
}
