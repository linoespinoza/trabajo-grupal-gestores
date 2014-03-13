package gestores.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.TipoEstadoIdea;
import gestores.modelo.Usuario;
import gestores.util.ConexionBD;

public class IdeaDAO extends BaseDAO {
	
	public Idea insertar(Idea vo) throws DAOExcepcion {
		String query = "insert into idea(idIdea,NoTitulo, TxDescripcion,TxReferencia,FeCreacion,FePublicacion,TipoEstado_CoEstado,Usuario_idEstudiante,Usuario_idAsesor) values (?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			//stmt.setInt(1, vo.getCategoria().getIdCategoria());
			stmt.setInt(1, vo.getIdIdea());
			stmt.setString(2, vo.getTitulo());
			stmt.setString(3, vo.getDescripcion());
			stmt.setString(4, vo.getReferencia());
			stmt.setDate(5, (Date) vo.getFechaCreacion());
			stmt.setDate(6, (Date) vo.getFechaPublicacion());
			stmt.setInt(7, vo.getTipoEstado().getIdEstadoIdea());
			stmt.setInt(8, vo.getUsuarioEstudiante().getIdUsuario());
			stmt.setInt(9, vo.getUsuarioAsesor().getIdUsuario());
			
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

	public Collection<Idea> listar() throws DAOExcepcion {
		Collection<Idea> i = new ArrayList<Idea>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			//String query = "select i.idIdea,i.noTitulo,i.TxDescripcion,i.TxReferencia,i.FeCreacion,i.FePublicacion,i.TIPOESTADO_CoESTADO,t.TxDescripcion,i.USUARIO_idESTUDIANTE,i.USUARIO_idASESOR from idea i inner join tipoestadoidea t on (i.TIPOESTADO_CoESTADO = t.CoESTADO);";
			String query = "select i.idIdea,i.noTitulo,i.TxDescripcion,i.TxReferencia,i.FeCreacion,i.FePublicacion,i.TIPOESTADO_CoESTADO,i.USUARIO_idESTUDIANTE,i.USUARIO_idASESOR from idea i;";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Idea vo = new Idea();
				vo.setIdIdea(rs.getInt("i.idIdea"));
				vo.setTitulo(rs.getString("i.noTitulo"));
				vo.setDescripcion(rs.getString("i.TxDescripcion"));
				vo.setReferencia(rs.getString("i.TxReferencia"));
				vo.setFechaCreacion(rs.getDate("i.FeCreacion"));
				vo.setFechaPublicacion(rs.getDate("i.FePublicacion"));
				
				TipoEstadoIdea tipo = new TipoEstadoIdea();
				tipo.setIdEstadoIdea(rs.getInt("i.TIPOESTADO_CoESTADO"));
				vo.setTipoEstado(tipo);

				Usuario user1 = new Usuario();
				user1.setIdUsuario(rs.getInt("i.USUARIO_idESTUDIANTE"));
				vo.setUsuarioEstudiante(user1);
				
				Usuario user2 = new Usuario();
				user2.setIdUsuario(rs.getInt("i.USUARIO_idASESOR"));
				vo.setUsuarioAsesor(user2);
							
				i.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);			this.cerrarConexion(con);
		}
		return i;
	}
	
}
