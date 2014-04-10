package gestores.dao;

import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.PlanTarifario;
import gestores.modelo.ReportePago;
import gestores.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
/**
 * @author Marco Chumpitaz.
 */
public class PagosDAO extends BaseDAO{

	public Collection<ReportePago> listaPagos(ReportePago rpago) throws DAOExcepcion{
		
		Collection<ReportePago> listap = new ArrayList<ReportePago>();
		int f_cond=0;
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String condicion = "";
			if (rpago.getCentroFormacion().getNombre() != null) {
				condicion = " Where No_Centro_Formacion like ? ";
				f_cond += 1;
			} 
			if (rpago.getCentroFormacion().getTipoCentroFormacion() != null) {
				if (f_cond == 1){
					condicion += "and Co_Tipo_Centro_Formacion like ? ";
				} else {
					condicion = " Where Co_Tipo_Centro_Formacion like ? ";	
				}
				f_cond += 1;
			}
			if (rpago.getMesPago() != null) {
				if (f_cond >= 1){
					condicion += "and Fe_Mes_Pago like ? ";
				} else {
					condicion = " Where Fe_Mes_Pago like ? ";
				}
				f_cond += 1;
			}
			if (rpago.getAnioPago() != null) {
				if (f_cond >= 1){
					condicion += "and Fe_Anio_Pago = ? ";
				} else {
					condicion = " Where Fe_Anio_Pago = ? ";
				}
			}
			
			String query = "SELECT No_Centro_Formacion, Co_Tipo_Centro_Formacion,No_Plan_Tarifario, Fe_Mes_Pago, Fe_Anio_Pago, Ss_Monto_Mensual " 
					+ "FROM centro_formacion cf inner join reporte_pago rp " 
					+ "on (cf.Co_Centro_Formacion = rp.Co_Centro_Formacion) "
					+ "left join plan_tarifario pt "
					+ "on (cf.Co_Plan_Tarifario = pt.Co_Plan_Tarifario)" +  condicion;
			
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			int indiceParametro = 1;
			
			if (rpago.getCentroFormacion().getNombre() != null) {
				stmt.setString(indiceParametro,"%" + rpago.getCentroFormacion().getNombre() + "%");
				indiceParametro += 1;
			} 
			if (rpago.getCentroFormacion().getTipoCentroFormacion() != null) {
				stmt.setString(indiceParametro, rpago.getCentroFormacion().getTipoCentroFormacion().getCodigo());
				indiceParametro += 1;
			}
			if (rpago.getMesPago() != null) {
				stmt.setString(indiceParametro, rpago.getMesPago());
				indiceParametro += 1;
			}
			if (rpago.getAnioPago() != null) {
				stmt.setInt(indiceParametro, rpago.getAnioPago());	
			}
							
			rs = stmt.executeQuery();
			while (rs.next()) {
				ReportePago vo = new ReportePago();
				vo.setMesPago(rs.getString(4));
				vo.setAnioPago(rs.getInt(5));
				vo.setMontoMensual(rs.getBigDecimal(6));
				
				CentroFormacion centroF = new CentroFormacion();
				centroF.setNombre(rs.getString(1));
				centroF.setTipoCentroFormacion(TipoCentroFormacion.getTipoCentroFormacion(rs.getString(2)));
				vo.setCentroFormacion(centroF);
				
				PlanTarifario plant = new PlanTarifario();
				plant.setNombre(rs.getString(3));
				vo.setPlanTarifario(plant);
				
				listap.add(vo);
				
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return listap;
	}
	
	public Collection<ReportePago> listar() throws DAOExcepcion{
	
		Collection<ReportePago> c = new ArrayList<ReportePago>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT No_Centro_Formacion, Co_Tipo_Centro_Formacion,No_Plan_Tarifario, Fe_Mes_Pago, Fe_Anio_Pago, Ss_Monto_Mensual " 
						+ "FROM centro_formacion cf inner join reporte_pago rp " 
						+ "on (cf.Co_Centro_Formacion = rp.Co_Centro_Formacion) "
						+ "left join plan_tarifario pt "
						+ "on (cf.Co_Plan_Tarifario = pt.Co_Plan_Tarifario)";
							
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
						
				ReportePago vo = new ReportePago();
				vo.setMesPago(rs.getString(4));
				vo.setAnioPago(rs.getInt(5));
				vo.setMontoMensual(rs.getBigDecimal(6));
			
				CentroFormacion centrof = new CentroFormacion();
				centrof.setNombre(rs.getString(1));
				centrof.setTipoCentroFormacion(TipoCentroFormacion
					.getTipoCentroFormacion(rs.getString(2)));
				vo.setCentroFormacion(centrof);
			
				PlanTarifario plant = new PlanTarifario();
				plant.setNombre(rs.getString(3));
				vo.setPlanTarifario(plant);
				
				c.add(vo);
		}

	} catch (SQLException e) {
		System.err.println(e.getMessage());
		throw new DAOExcepcion(e.getMessage());
	} finally {
		this.cerrarResultSet(rs);
		this.cerrarStatement(stmt);
		this.cerrarConexion(con);
	}
	return c;
}
}
