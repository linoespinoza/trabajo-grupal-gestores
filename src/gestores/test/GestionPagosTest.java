package gestores.test;

import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.ReportePago;
import gestores.negocio.GestionPagos;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class GestionPagosTest {

	//@Test
	public void listar(){
		GestionPagos negocio = new GestionPagos();
		try {
			Collection<ReportePago> listad = negocio.listar(); 
						
			System.out.println("Total de registros: " + listad.size());
			
			for (ReportePago vo : listad) {
				System.out.println(vo.getCentroFormacion().getNombre().toString()
						+ " | " + vo.getCentroFormacion().getTipoCentroFormacion().toString()
						+ " | " + vo.getPlanTarifario().getNombre().toString()
						+ " | " + vo.getMesPago()
						+ " | " + vo.getAnioPago()
						+ " | " + vo.getMontoMensual()
						);
			}
			Assert.assertTrue(listad.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la lista: " + e.getMessage());
		}
		
	}

	@Test
	public void listaPagos(){
		GestionPagos negocio = new GestionPagos();
		try {
			
			CentroFormacion cF = new CentroFormacion();
			cF.setNombre(null);
			
			
			ReportePago rPago = new ReportePago();
			rPago.setCentroFormacion(cF);
			rPago.setAnioPago(null);
			
			
			Collection<ReportePago> listad = negocio.listaPagos(rPago); 
						
			System.out.println("Total de registros: " + listad.size());
			
			for (ReportePago vo : listad) {
				System.out.println(vo.getCentroFormacion().getNombre().toString()
						+ " | " + vo.getCentroFormacion().getTipoCentroFormacion().toString()
						+ " | " + vo.getPlanTarifario().getNombre().toString()
						+ " | " + vo.getMesPago()
						+ " | " + vo.getAnioPago()
						+ " | " + vo.getMontoMensual()
						);
			}
			Assert.assertTrue(listad.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la lista: " + e.getMessage());
		}
		
	}
}
