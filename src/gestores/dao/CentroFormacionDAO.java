package gestores.dao;

import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.PlanTarifario;
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
public class CentroFormacionDAO extends BaseDAO {

	public List<CentroFormacion> listar(CentroFormacion centroFormacion)
			throws DAOExcepcion {
		List<CentroFormacion> lista = new ArrayList<CentroFormacion>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String condicion = "";
			if (centroFormacion.getTipoCentroFormacion() != null) {
				condicion = "AND cfo.Co_Tipo_Centro_Formacion = ?";
			}
			String query = "SELECT cfo.Co_Centro_Formacion, cfo.No_Centro_Formacion, cfo.Co_Tipo_Centro_Formacion, cfo.Tx_Url, cfo.Tx_Logo, pta.No_Plan_Tarifario "
					+ "FROM CENTRO_FORMACION cfo INNER JOIN PLAN_TARIFARIO pta "
					+ "ON (cfo.Co_Plan_Tarifario = pta.Co_Plan_Tarifario) "
					+ "WHERE cfo.No_Centro_Formacion LIKE ? " + condicion;

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + centroFormacion.getNombre() + "%");

			if (centroFormacion.getTipoCentroFormacion() != null) {
				stmt.setString(2, centroFormacion.getTipoCentroFormacion()
						.getCodigo());
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				CentroFormacion vo = new CentroFormacion();
				vo.setCodigo(rs.getString(1));
				vo.setNombre(rs.getString(2));
				vo.setTipoCentroFormacion(TipoCentroFormacion
						.getTipoCentroFormacion(rs.getString(3)));
				vo.setUrl(rs.getString(4));
				vo.setLogo(rs.getString(5));

				PlanTarifario planTarifario = new PlanTarifario();
				planTarifario.setNombre(rs.getString(6));
				vo.setPlanTarifario(planTarifario);
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

	public CentroFormacion insertar(CentroFormacion vo) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "INSERT INTO CENTRO_FORMACION (Co_Centro_Formacion, No_Centro_Formacion, Co_Tipo_Centro_Formacion, Tx_Url, Tx_Logo, Co_Plan_Tarifario) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getCodigo());
			stmt.setString(2, vo.getNombre());
			stmt.setString(3, vo.getTipoCentroFormacion().getCodigo());
			stmt.setString(4, vo.getUrl());
			stmt.setString(5, vo.getLogo());
			stmt.setInt(6, vo.getPlanTarifario().getCodigo());

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

	public CentroFormacion obtener(String codigo) throws DAOExcepcion {
		CentroFormacion vo = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Co_Centro_Formacion, No_Centro_Formacion, Co_Tipo_Centro_Formacion, Tx_Url, Tx_Logo, Co_Plan_Tarifario "
					+ "FROM CENTRO_FORMACION "
					+ "WHERE Co_Centro_Formacion = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				vo = new CentroFormacion();
				vo.setCodigo(rs.getString(1));
				vo.setNombre(rs.getString(2));
				vo.setTipoCentroFormacion(TipoCentroFormacion
						.getTipoCentroFormacion(rs.getString(3)));
				vo.setUrl(rs.getString(4));
				vo.setLogo(rs.getString(5));

				PlanTarifario planTarifario = new PlanTarifario();
				planTarifario.setCodigo(rs.getInt(6));
				vo.setPlanTarifario(planTarifario);
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

	public void eliminar(String codigo) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "DELETE FROM CENTRO_FORMACION WHERE Co_Centro_Formacion = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, codigo);
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

	public CentroFormacion actualizar(CentroFormacion vo) throws DAOExcepcion {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String query = "UPDATE CENTRO_FORMACION SET No_Centro_Formacion = ?, Co_Tipo_Centro_Formacion = ?, Tx_Url = ?, Tx_Logo = ?, Co_Plan_Tarifario = ? "
					+ "WHERE Co_Centro_Formacion = ?";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getTipoCentroFormacion().getCodigo());
			stmt.setString(3, vo.getUrl());
			stmt.setString(4, vo.getLogo());
			stmt.setInt(5, vo.getPlanTarifario().getCodigo());
			stmt.setString(6, vo.getCodigo());

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