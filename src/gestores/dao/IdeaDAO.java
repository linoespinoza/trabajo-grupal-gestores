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
import gestores.util.ConexionBD;

public class IdeaDAO extends BaseDAO {
	
	public Idea insertar_idea(Idea vo) throws DAOExcepcion {
		String query = "insert into idea(co_Idea,No_Titulo,Tx_Descripcion,Tx_Palabras_Clave,Tx_Archivo,Co_Estudiante,Co_Estado,Fe_Creacion,Fe_Publicacion,Co_Asesor) values (?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, vo.getCoIdea());
			stmt.setString(2, vo.getTitulo());
			stmt.setString(3, vo.getDescripcion());
			stmt.setString(4, vo.getPalabras());
			stmt.setString(5, vo.getArchivo());
			//stmt.setInt(6, vo.getUsuarioEstudiante().getIdUsuario());
			stmt.setInt(6, vo.getCoEstudiante());
			stmt.setString(7, vo.getCoEstado());
			stmt.setDate(8, (Date) vo.getFechaCreacion());
			stmt.setDate(9, (Date) vo.getFechaPublicacion());
			//stmt.setInt(10, vo.getUsuarioAsesor().getIdUsuario());
			stmt.setInt(10, vo.getCoAsesor());
			
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

	public Collection<Idea> listar_idea() throws DAOExcepcion {
		Collection<Idea> i = new ArrayList<Idea>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select co_Idea,no_Titulo,Tx_Descripcion,Tx_Palabras_clave,Tx_Archivo,Co_Estudiante,Co_Estado,Fe_Creacion,Fe_Publicacion,Co_Asesor from idea;";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Idea vo = new Idea();
				vo.setCoIdea(rs.getInt("co_Idea"));
				vo.setTitulo(rs.getString("no_Titulo"));
				vo.setDescripcion(rs.getString("Tx_Descripcion"));
				vo.setPalabras(rs.getString("Tx_Palabras_clave"));
				vo.setArchivo(rs.getString("Tx_Archivo"));
				vo.setCoEstudiante(rs.getInt("Co_Estudiante"));
				vo.setCoEstado(rs.getString("Co_Estado"));
				vo.setFechaCreacion(rs.getDate("Fe_Creacion"));
				vo.setFechaPublicacion(rs.getDate("Fe_Publicacion"));
				vo.setCoAsesor(rs.getInt("Co_Asesor"));
				
				/*Usuario user2 = new Usuario();
				user2.setIdUsuario(rs.getInt("USUARIO_idASESOR"));
				vo.setUsuarioAsesor(user2);*/
							
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
	
	public Collection<Idea> buscarCadena_idea(String cadena) throws DAOExcepcion {
		Collection<Idea> i = new ArrayList<Idea>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			//String query = "select co_Idea,no_Titulo,Tx_Descripcion,Tx_Palabras_clave,Tx_Archivo,Co_Estudiante,Co_Estado,Fe_Creacion,Fe_Publicacion,Co_Asesor from idea where no_Titulo like ? or tx_Descripcion like ? or tx_Palabras like ?;";
			String query = "select * from idea where no_Titulo like ? or tx_Descripcion like ? or tx_Palabras_clave like ?;";
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + cadena + "%");
			stmt.setString(2, "%" + cadena + "%");
			stmt.setString(3, "%" + cadena + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Idea vo = new Idea();
				vo.setCoIdea(rs.getInt("co_Idea"));
				vo.setTitulo(rs.getString("no_Titulo"));
				vo.setDescripcion(rs.getString("Tx_Descripcion"));
				vo.setPalabras(rs.getString("Tx_Palabras_clave"));
				vo.setArchivo(rs.getString("Tx_Archivo"));
				vo.setCoEstudiante(rs.getInt("Co_Estudiante"));
				vo.setCoEstado(rs.getString("Co_Estado"));
				vo.setFechaCreacion(rs.getDate("Fe_Creacion"));
				vo.setFechaPublicacion(rs.getDate("Fe_Publicacion"));
				vo.setCoAsesor(rs.getInt("Co_Asesor"));
				
				/*Usuario user2 = new Usuario();
				user2.setIdUsuario(rs.getInt("USUARIO_idASESOR"));
				vo.setUsuarioAsesor(user2);*/
							
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
	
	public Collection<Idea> buscarNombre_idea(int codigo) throws DAOExcepcion {
		Collection<Idea> i = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "select * from Idea where co_Idea like ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + codigo + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Idea vo = new Idea();
				vo.setTitulo(rs.getString("No_Titulo"));
				i.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);			
			this.cerrarConexion(con);
		}
		return i;
	}
	
}
