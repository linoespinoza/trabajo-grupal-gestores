package gestores.dao;

import gestores.exception.DAOExcepcion;
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
public class PlanTarifarioDAO extends BaseDAO {

	public List<PlanTarifario> listar() throws DAOExcepcion {
		List<PlanTarifario> lista = new ArrayList<PlanTarifario>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Co_Plan_Tarifario, No_Plan_Tarifario, Ss_Precio_Servicio, Ss_Precio_Tarifa "
					+ "FROM PLAN_TARIFARIO";

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				PlanTarifario vo = new PlanTarifario();
				vo.setCodigo(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setPrecioServicio(rs.getBigDecimal(3));
				vo.setPrecioTarifa(rs.getBigDecimal(4));
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
}