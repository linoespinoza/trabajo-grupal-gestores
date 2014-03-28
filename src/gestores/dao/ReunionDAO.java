package gestores.dao;

import gestores.enums.TipoCalificacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Reunion;
import gestores.modelo.Usuario;
import gestores.util.ConexionBD;
import gestores.util.FechaUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Jeremías Yalta.
 */
public class ReunionDAO extends BaseDAO {

	public List<Reunion> listar(Date fechaInicio, Date fechaFin, Reunion reunion)
			throws DAOExcepcion {
		List<Reunion> lista = new ArrayList<Reunion>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String condicion = "";
			if (fechaInicio != null && fechaFin != null) {
				condicion = "AND DATE(reu.Fe_Reunion) BETWEEN DATE(?) AND DATE(?) ";
			}
			if (reunion.getTipoCalificacion() != null) {
				condicion += "AND reu.Co_Tipo_Calificacion = ?";
			}

			String query = "SELECT reu.Co_Reunion, reu.Fe_Reunion, ide.No_Titulo, usu.No_Usuario, usu.No_Ape_Paterno, usu.No_Ape_Materno, reu.Tx_Observacion, reu.Co_Tipo_Calificacion "
					+ "FROM REUNION reu INNER JOIN IDEA ide "
					+ "ON (reu.Co_Idea = ide.Co_Idea) "
					+ "INNER JOIN USUARIO usu "
					+ "ON (ide.Co_Estudiante = usu.Co_Usuario) "
					+ "WHERE ide.Co_Asesor = ? " + condicion;

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			int indiceParametro = 2;

			stmt.setInt(1, reunion.getIdea().getAsesor().getCodigo());

			if (fechaInicio != null && fechaFin != null) {
				stmt.setTimestamp(2, FechaUtil.convertirSqlDate(fechaInicio));
				stmt.setTimestamp(3, FechaUtil.convertirSqlDate(fechaFin));
				indiceParametro = 4;
			}
			if (reunion.getTipoCalificacion() != null) {
				stmt.setString(indiceParametro, reunion.getTipoCalificacion()
						.getCodigo());
			}

			rs = stmt.executeQuery();
			while (rs.next()) {
				Reunion vo = new Reunion();
				vo.setCodigo(rs.getInt(1));
				vo.setFechaReunion(rs.getDate(2));

				Idea idea = new Idea();
				idea.setTitulo(rs.getString(3));

				Usuario estudiante = new Usuario();
				estudiante.setNombre(rs.getString(4));
				estudiante.setApellidoPaterno(rs.getString(5));
				estudiante.setApellidoMaterno(rs.getString(6));

				idea.setEstudiante(estudiante);
				vo.setIdea(idea);
				vo.setObservacion(rs.getString(7));
				vo.setTipoCalificacion(TipoCalificacion.getTipoCalificacion(rs
						.getString(8)));
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

	public Reunion insertar(Reunion vo) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "INSERT INTO REUNION (Co_Idea, Fe_Reunion, Tx_Observacion, Co_Tipo_Calificacion) "
					+ "VALUES (?, ?, ?, ?)";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getIdea().getCodigo());
			stmt.setTimestamp(2, FechaUtil.convertirSqlDate(vo.getFechaReunion()));
			stmt.setString(3, vo.getObservacion());
			stmt.setString(4, vo.getTipoCalificacion().getCodigo());

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

	public boolean esRegistradaMismoDia(Reunion reunion) throws DAOExcepcion {
		boolean registradaFlag = false;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT reu.Co_Reunion "
					+ "FROM REUNION reu INNER JOIN IDEA ide "
					+ "ON (reu.Co_Idea = ide.Co_Idea) "
					+ "WHERE ide.Co_Asesor = ? AND DATE(reu.Fe_Reunion) = DATE(?)";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, reunion.getIdea().getAsesor().getCodigo());
			stmt.setTimestamp(2,
					FechaUtil.convertirSqlDate(reunion.getFechaReunion()));
			rs = stmt.executeQuery();

			if (rs.next()) {
				registradaFlag = true;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return registradaFlag;
	}
}