package gestores.dao;

import gestores.bean.Puntaje;
import gestores.enums.EstadoIdea;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Bravo.
 */
public class IdeaDAO extends BaseDAO {

	public List<Idea> listarEvaluacion(Idea idea) throws DAOExcepcion {
		List<Idea> lista = new ArrayList<Idea>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT ide.Co_Idea, ide.No_Titulo, ide.Tx_Archivo, est.No_Usuario AS No_Estudiante, est.No_Ape_Paterno AS No_Ape_Paterno_Est, est.No_Ape_Materno AS No_Ape_Materno_Est, ase.No_Usuario AS No_Asesor, ase.No_Ape_Paterno AS No_Ape_Paterno_Ase, ase.No_Ape_Materno AS No_Ape_Materno_Ase, ide.Co_Estado, ide.Fe_Creacion "
					+ "FROM IDEA ide INNER JOIN USUARIO est "
					+ "ON (ide.Co_Estudiante = est.Co_Usuario) "
					+ "LEFT JOIN USUARIO ase "
					+ "ON (ide.Co_Asesor = ase.Co_Usuario) "
					+ "WHERE ide.No_Titulo LIKE ? "
					+ "AND ide.Co_Estado IN (?, ?, ?)";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + idea.getTitulo() + "%");
			stmt.setString(2, EstadoIdea.Publicada.getCodigo());
			stmt.setString(3, EstadoIdea.Aprobada.getCodigo());
			stmt.setString(4, EstadoIdea.Rechazada.getCodigo());

			rs = stmt.executeQuery();
			while (rs.next()) {
				Idea vo = new Idea();
				vo.setCodigo(rs.getInt(1));
				vo.setTitulo(rs.getString(2));
				vo.setArchivo(rs.getString(3));

				Usuario estudiante = new Usuario();
				estudiante.setNombre(rs.getString(4));
				estudiante.setApellidoPaterno(rs.getString(5));
				estudiante.setApellidoMaterno(rs.getString(6));
				vo.setEstudiante(estudiante);

				Usuario asesor = new Usuario();
				asesor.setNombre(rs.getString(7));
				asesor.setApellidoPaterno(rs.getString(8));
				asesor.setApellidoMaterno(rs.getString(9));
				vo.setAsesor(asesor);

				vo.setEstadoIdea(EstadoIdea.getEstadoIdea(rs.getString(10)));
				vo.setFechaCreacion(rs.getDate(11));
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

	public Idea obtenerEvaluacion(Integer codigo) throws DAOExcepcion {
		Idea vo = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT ide.Co_Idea, ide.No_Titulo, ide.Tx_Descripcion, ide.Tx_Palabras_Clave, ide.Tx_Archivo, ide.Co_Estudiante, est.No_Usuario, est.No_Ape_Paterno, est.No_Ape_Materno, ide.Co_Estado, ide.Fe_Creacion, ide.Co_Asesor "
					+ "FROM IDEA ide INNER JOIN USUARIO est "
					+ "ON (ide.Co_Estudiante = est.Co_Usuario) "
					+ "WHERE ide.Co_Idea = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				vo = new Idea();
				vo.setCodigo(rs.getInt(1));
				vo.setTitulo(rs.getString(2));
				vo.setDescripcion(rs.getString(3));
				vo.setPalabrasClave(rs.getString(4));
				vo.setArchivo(rs.getString(5));

				Usuario estudiante = new Usuario();
				estudiante.setCodigo(rs.getInt(6));
				estudiante.setNombre(rs.getString(7));
				estudiante.setApellidoPaterno(rs.getString(8));
				estudiante.setApellidoMaterno(rs.getString(9));
				vo.setEstudiante(estudiante);

				vo.setEstadoIdea(EstadoIdea.getEstadoIdea(rs.getString(10)));
				vo.setFechaCreacion(rs.getDate(11));

				Usuario asesor = new Usuario();
				asesor.setCodigo(rs.getInt(12));
				vo.setAsesor(asesor);
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

	public Idea actualizarEstado(Idea vo) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "UPDATE IDEA SET Co_Estado = ? WHERE Co_Idea = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getEstadoIdea().getCodigo());
			stmt.setInt(2, vo.getCodigo());

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

	public Idea actualizarAsesor(Idea vo) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "UPDATE IDEA SET Co_Asesor = ? WHERE Co_Idea = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getAsesor().getCodigo());
			stmt.setInt(2, vo.getCodigo());

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

	public boolean esPublicada(Integer codigo) throws DAOExcepcion {
		boolean flagPublicado = false;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Co_Estado FROM IDEA WHERE Co_Idea = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				flagPublicado = EstadoIdea.Publicada.getCodigo().equals(
						rs.getString(1));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return flagPublicado;
	}

	public boolean esAprobada(Integer codigo) throws DAOExcepcion {
		boolean flagAprobado = false;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Co_Estado FROM IDEA WHERE Co_Idea = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				flagAprobado = EstadoIdea.Aprobada.getCodigo().equals(
						rs.getString(1));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return flagAprobado;
	}

	public boolean esAsesorOtraIdea(Idea idea) throws DAOExcepcion {
		boolean flagAsesorOtraIdea = false;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Co_Idea FROM IDEA WHERE Co_Idea <> ? AND Co_Estudiante = ? AND Co_Asesor = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idea.getCodigo());
			stmt.setInt(2, idea.getEstudiante().getCodigo());
			stmt.setInt(3, idea.getAsesor().getCodigo());
			rs = stmt.executeQuery();

			if (rs.next()) {
				flagAsesorOtraIdea = true;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return flagAsesorOtraIdea;
	}

	public boolean esIdeaVotada(Integer codigo) throws DAOExcepcion {
		boolean flagIdeaVotada = false;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Qt_Puntaje FROM USUARIO_PERMITIDO WHERE Co_Idea = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					flagIdeaVotada = true;
					break;
				}
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return flagIdeaVotada;
	}

	public List<Puntaje> listarPuntaje(Integer codigo) throws DAOExcepcion {
		List<Puntaje> lista = new ArrayList<Puntaje>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Qt_Puntaje, COUNT(Co_Usuario) AS Qt_Usuario "
					+ "FROM USUARIO_PERMITIDO "
					+ "WHERE Co_Idea = ? AND Qt_Puntaje > 0 "
					+ "GROUP BY Qt_Puntaje ORDER BY Qt_Puntaje";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codigo);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Puntaje puntaje = new Puntaje();
				puntaje.setValorPuntaje(rs.getInt(1));
				puntaje.setCantidadUsuarios(rs.getInt(2));
				lista.add(puntaje);
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

	public int ObtenerNroIdeasporCentroFormacion(CentroFormacion centroformacion) throws DAOExcepcion{
		int tot_ideas = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT count(*) FROM idea id3 inner join usuario us3 on id3.Co_Estudiante = us3.Co_Usuario "
							+ "where us3.Co_Centro_Formacion = ? "
							+ "group by us3.Co_Centro_Formacion";
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1,  centroformacion.getCodigo());
			rs= stmt.executeQuery();
			tot_ideas = rs.getInt(1);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return tot_ideas;
	}
	
}