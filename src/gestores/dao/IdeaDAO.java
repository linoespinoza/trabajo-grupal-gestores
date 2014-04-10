package gestores.dao;

import gestores.bean.Puntaje;
import gestores.enums.EstadoIdea;
import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Idea;
import gestores.modelo.PlanTarifario;
import gestores.modelo.Usuario;
import gestores.util.ConexionBD;
import gestores.util.FechaUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Harry Bravo.
 */
public class IdeaDAO extends BaseDAO {

	public List<Idea> listar(Integer codigoAsesor) throws DAOExcepcion {
		List<Idea> lista = new ArrayList<Idea>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Co_Idea, No_Titulo FROM IDEA "
					+ "WHERE Co_Asesor = ? ORDER BY No_Titulo";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, codigoAsesor);

			rs = stmt.executeQuery();
			while (rs.next()) {
				Idea vo = new Idea();
				vo.setCodigo(rs.getInt(1));
				vo.setTitulo(rs.getString(2));
				lista.add(vo);
			}
		} catch (SQLException e) {
			throw new DAOExcepcion(e);
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return lista;
	}

	public List<Idea> listarEvaluacion(Idea idea, Usuario evaluador)
			throws DAOExcepcion {
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
					+ "AND est.Co_Centro_Formacion = ?"
					+ "AND ide.Co_Estado IN (?, ?, ?)";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + idea.getTitulo() + "%");
			stmt.setString(2, evaluador.getCentroFormacion().getCodigo());
			stmt.setString(3, EstadoIdea.PUBLICADA.getCodigo());
			stmt.setString(4, EstadoIdea.APROBADA.getCodigo());
			stmt.setString(5, EstadoIdea.RECHAZADA.getCodigo());

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
				vo.setFechaCreacion(rs.getTimestamp(11));
				lista.add(vo);
			}
		} catch (SQLException e) {
			throw new DAOExcepcion(e);
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
				vo.setFechaCreacion(rs.getTimestamp(11));

				Usuario asesor = new Usuario();
				asesor.setCodigo(rs.getInt(12));
				vo.setAsesor(asesor);
			}
		} catch (SQLException e) {
			throw new DAOExcepcion(e);
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public int actualizarEstado(Idea vo) throws DAOExcepcion {
		int registroAfectado = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "UPDATE IDEA SET Co_Estado = ? WHERE Co_Idea = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getEstadoIdea().getCodigo());
			stmt.setInt(2, vo.getCodigo());

			registroAfectado = stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOExcepcion(e);
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return registroAfectado;
	}

	public int actualizarAsesor(Idea vo) throws DAOExcepcion {
		int registroAfectado = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "UPDATE IDEA SET Co_Asesor = ? WHERE Co_Idea = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getAsesor().getCodigo());
			stmt.setInt(2, vo.getCodigo());

			registroAfectado = stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOExcepcion(e);
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return registroAfectado;
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
				flagPublicado = EstadoIdea.PUBLICADA.getCodigo().equals(
						rs.getString(1));
			}
		} catch (SQLException e) {
			throw new DAOExcepcion(e);
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
				flagAprobado = EstadoIdea.APROBADA.getCodigo().equals(
						rs.getString(1));
			}
		} catch (SQLException e) {
			throw new DAOExcepcion(e);
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
			throw new DAOExcepcion(e);
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
			throw new DAOExcepcion(e);
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
			throw new DAOExcepcion(e);
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return lista;
	}

	/*
	 * Lino Espinoza
	 */
	public Idea insertarIdea(Idea idea) throws DAOExcepcion {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			String query = "INSERT INTO IDEA (No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo, Fe_Creacion, Co_Estado, Co_Estudiante) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, idea.getTitulo());
			stmt.setString(2, idea.getDescripcion());
			stmt.setString(3, idea.getPalabrasClave());
			stmt.setString(4, idea.getArchivo());
			stmt.setTimestamp(5,
					FechaUtil.convertirTimestamp(idea.getFechaCreacion()));
			stmt.setString(6, idea.getEstadoIdea().getCodigo());
			stmt.setInt(7, idea.getEstudiante().getCodigo());

			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar la idea");
			}

			// Obtener el ultimo id
			Integer id = 0;
			query = "SELECT LAST_INSERT_ID()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			idea.setCodigo(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return idea;
	}

	public boolean esIdeaConTituloExistente(Idea idea) throws DAOExcepcion {
		boolean flagIdeaConTituloExistente = false;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Co_Idea FROM IDEA WHERE No_Titulo = ? AND Co_Estudiante = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, idea.getTitulo());
			stmt.setInt(2, idea.getEstudiante().getCodigo());
			
			System.out.println(idea.getTitulo());
			rs = stmt.executeQuery();

			if (rs.next()) {
				flagIdeaConTituloExistente = true;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return flagIdeaConTituloExistente;
	}

	public boolean esIdeaConAlgunaPalabraClaveIgual(Idea idea)
			throws DAOExcepcion {
		boolean flag = false;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Co_Idea FROM IDEA WHERE No_Titulo = ? AND Co_Estudiante = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, idea.getTitulo());
			stmt.setInt(2, idea.getEstudiante().getCodigo());
			rs = stmt.executeQuery();

			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return flag;
	}

	public Idea actualizarIdea(Idea idea) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement stmt = null;
		try {

			String query = "UPDATE IDEA SET No_Titulo = ?, Tx_Descripcion = ?, Tx_Palabras_Clave = ?, Tx_Archivo = ?"
					+ " WHERE Co_Idea = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, idea.getTitulo());
			stmt.setString(2, idea.getDescripcion());
			stmt.setString(3, idea.getPalabrasClave());
			stmt.setString(4, idea.getArchivo());
			stmt.setInt(5, idea.getCodigo());

			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar la idea de id:"
						+ idea.getCodigo());
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return idea;
	}

	public List<Idea> listarIdeasPorUsuario(Usuario estudiante)
			throws DAOExcepcion {

		List<Idea> lista = new ArrayList<Idea>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Co_Idea, No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, "
					+ "Tx_Archivo, Co_Estado, Fe_Creacion "
					+ "FROM IDEA i INNER JOIN USUARIO u "
					+ "ON (i.Co_Estudiante = u.Co_Usuario) "
					+ "WHERE i.Co_Estudiante = ? " + "ORDER BY i.No_Titulo";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, estudiante.getCodigo());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Idea idea = new Idea();
				idea.setCodigo(rs.getInt("Co_Idea"));
				idea.setTitulo(rs.getString("No_Titulo"));
				idea.setDescripcion(rs.getString("Tx_Descripcion"));
				idea.setPalabrasClave(rs.getString("Tx_Palabras_Clave"));
				idea.setArchivo(rs.getString("Tx_Archivo"));
				idea.setEstadoIdea(EstadoIdea.getEstadoIdea(rs
						.getString("Co_Estado")));
				idea.setFechaCreacion(rs.getDate("Fe_Creacion"));

				lista.add(idea);
			}
		} catch (SQLException e) {
			throw new DAOExcepcion(e);
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return lista;
	}

	public Collection<Idea> listar_Idea() throws DAOExcepcion {
		Collection<Idea> i = new ArrayList<Idea>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			// String query =
			// "select co_Idea,no_Titulo,Tx_Descripcion,Tx_Palabras_clave,Tx_Archivo,Co_Estudiante,Co_Estado,Fe_Creacion,Fe_Publicacion,Co_Asesor from idea;";
			String query = "SELECT ide.Co_Idea, ide.No_Titulo, ide.Tx_Archivo, est.No_Usuario AS No_Estudiante_Est, est.No_Ape_Paterno AS No_Ape_Paterno_Est, est.No_Ape_Materno AS No_Ape_Materno_Est, ase.No_Usuario AS No_Asesor_Ase, ase.No_Ape_Paterno AS No_Ape_Paterno_Ase, ase.No_Ape_Materno AS No_Ape_Materno_Ase, ide.Co_Estado, ide.Fe_Creacion, ide.Fe_Publicacion "
					+ "FROM IDEA ide INNER JOIN USUARIO est ON (ide.Co_Estudiante = est.Co_Usuario) LEFT JOIN USUARIO ase ON (ide.Co_Asesor = ase.Co_Usuario);";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Idea vo = new Idea();
				vo.setCodigo(rs.getInt("ide.co_Idea"));
				vo.setTitulo(rs.getString("ide.no_Titulo"));
				vo.setDescripcion(rs.getString("ide.Tx_Descripcion"));
				vo.setPalabrasClave(rs.getString("ide.Tx_Palabras_clave"));
				vo.setArchivo(rs.getString("ide.Tx_Archivo"));

				Usuario estudiante = new Usuario();
				estudiante.setNombre(rs.getString("No_Estudiante_Est"));
				estudiante.setApellidoPaterno(rs
						.getString("No_ape_paterno_Est"));
				estudiante.setApellidoMaterno(rs
						.getString("No_ape_materno_Est"));
				vo.setEstudiante(estudiante);

				vo.setEstadoIdea(EstadoIdea.getEstadoIdea(rs
						.getString("ide.Co_Estado")));
				vo.setFechaCreacion(rs.getDate("Fe_Creacion"));
				vo.setFechaPublicacion(rs.getDate("Fe_Publicacion"));

				Usuario asesor = new Usuario();
				asesor.setNombre(rs.getString("No_Asesor_Ase"));
				asesor.setApellidoPaterno(rs.getString("No_Ape_paterno_Ase"));
				asesor.setApellidoMaterno(rs.getString("No_Ape_materno_Ase"));
				vo.setAsesor(asesor);

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

	public Collection<Idea> buscarCadena_Idea(String cadena)
			throws DAOExcepcion {
		Collection<Idea> i = new ArrayList<Idea>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			// String query =
			// "select co_Idea,no_Titulo,Tx_Descripcion,Tx_Palabras_clave,Tx_Archivo,Co_Estudiante,Co_Estado,Fe_Creacion,Fe_Publicacion,Co_Asesor from idea where no_Titulo like ? or tx_Descripcion like ? or tx_Palabras like ?;";
			String query = "SELECT i.* FROM IDEA i INNER JOIN USUARIO u ON (i.Co_Estudiante = u.Co_Usuario) LEFT JOIN USUARIO a ON (i.Co_Asesor = a.Co_Usuario);"
					+ "WHERE i.no_Titulo like ? OR i.tx_Descripcion like ? OR i.tx_Palabras_clave like ?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + cadena + "%");
			stmt.setString(2, "%" + cadena + "%");
			stmt.setString(3, "%" + cadena + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Idea vo = new Idea();
				vo.setCodigo(rs.getInt("i.co_Idea"));
				vo.setTitulo(rs.getString("i.no_Titulo"));
				vo.setDescripcion(rs.getString("i.Tx_Descripcion"));
				vo.setPalabrasClave(rs.getString("i.Tx_Palabras_clave"));
				vo.setArchivo(rs.getString("i.Tx_Archivo"));

				Usuario estudiante = new Usuario();
				estudiante.setNombre(rs.getString("u.No_Usuario"));
				estudiante.setApellidoPaterno(rs.getString("u.No_ape_paterno"));
				estudiante.setApellidoMaterno(rs.getString("u.No_ape_materno"));
				vo.setEstudiante(estudiante);

				vo.setEstadoIdea(EstadoIdea.getEstadoIdea(rs
						.getString("i.Co_Estado")));

				vo.setFechaCreacion(rs.getDate("i.Fe_Creacion"));
				vo.setFechaPublicacion(rs.getDate("i.Fe_Publicacion"));

				Usuario asesor = new Usuario();
				asesor.setNombre(rs.getString("a.No_Usuario"));
				asesor.setApellidoPaterno(rs.getString("a.No_Ape_paterno"));
				asesor.setApellidoMaterno(rs.getString("a.No_Ape_materno"));
				vo.setAsesor(asesor);

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

	public Collection<Idea> buscarNombre_Idea(int codigo) throws DAOExcepcion {
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
	
	/**
	 * @author Lino Espinoza
	 */
	public int eliminar(String codigo) throws DAOExcepcion {
		int registroAfectado = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "DELETE FROM IDEA WHERE Co_Idea = ?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigo);
			registroAfectado = stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOExcepcion(e);
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return registroAfectado;
	}

	/**
	 * @author Lino Espinoza
	 */	
	public Idea obtener(String codigo) throws DAOExcepcion {
		Idea vo = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Co_Idea, No_Titulo, Tx_Descripcion, Tx_Palabras_Clave, Tx_Archivo "
					+ "FROM IDEA WHERE Co_Idea = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				vo = new Idea();
				vo.setCodigo(Integer.parseInt(rs.getString(1)));
				vo.setTitulo(rs.getString(2));
				vo.setDescripcion(rs.getString(3));
				vo.setPalabrasClave(rs.getString(4));
				vo.setArchivo(rs.getString(5));
			}
		} catch (SQLException e) {
			throw new DAOExcepcion(e);
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
}