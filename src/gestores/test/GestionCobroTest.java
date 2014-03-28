package gestores.test;

import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.ReportePago;
import gestores.negocio.GestionCobro;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class GestionCobroTest {

	@Test
	public void listar(){
		GestionCobro negocio = new GestionCobro();
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

}
