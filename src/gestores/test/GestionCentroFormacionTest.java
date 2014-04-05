package gestores.test;

import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.PlanTarifario;
import gestores.negocio.GestionCentroFormacion;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GestionCentroFormacionTest {

	@Test
	public void insertarTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			PlanTarifario planTarifario = new PlanTarifario();
			planTarifario.setCodigo(2);

			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setCodigo("10804050202");
			centroFormacion.setNombre("Instituto Superior Tecnol�gico IDAT");
			centroFormacion
					.setTipoCentroFormacion(TipoCentroFormacion.INSTITUTO);
			centroFormacion.setUrl("http://www.idat.edu.pe");
			centroFormacion.setLogo("logoIdat.png");
			centroFormacion.setPlanTarifario(planTarifario);

			int registroAfectado = negocio.insertar(centroFormacion);
			Assert.assertTrue(registroAfectado > 0);
		} catch (NegocioExcepcion e) {
			Assert.fail("Validaci�n: " + e.getMessage());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserci�n: " + e.getMessage());
		}
	}

	@Test
	public void obtenerTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			String codigo = "10804050202";
			CentroFormacion vo = negocio.obtener(codigo);
			Assert.assertNotNull(vo);
		} catch (NegocioExcepcion e) {
			Assert.fail("Validaci�n: " + e.getMessage());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la obtenci�n: " + e.getMessage());
		}
	}

	@Test
	public void actualizarTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			PlanTarifario planTarifario = new PlanTarifario();
			planTarifario.setCodigo(3);

			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setCodigo("10804050202");
			centroFormacion.setNombre("Instituto IDAT");
			centroFormacion
					.setTipoCentroFormacion(TipoCentroFormacion.INSTITUTO);
			centroFormacion.setUrl("http://www.idat.edu.pe/index.jsp");
			centroFormacion.setLogo("logoIdat.png");
			centroFormacion.setPlanTarifario(planTarifario);

			int registroAfectado = negocio.actualizar(centroFormacion);
			Assert.assertTrue(registroAfectado > 0);
		} catch (NegocioExcepcion e) {
			Assert.fail("Validaci�n: " + e.getMessage());
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la actualizaci�n: " + e.getMessage());
		}
	}

	@Test
	public void listarTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setNombre("");
			centroFormacion.setTipoCentroFormacion(null);

			List<CentroFormacion> listado = negocio.listar(centroFormacion);
			System.out.println("Total de registros: " + listado.size());

			for (CentroFormacion vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoCentroFormacion().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la b�squeda: " + e.getMessage());
		}
	}

	@Test
	public void buscarPorNombreTipoTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setNombre("IDAT");
			centroFormacion
					.setTipoCentroFormacion(TipoCentroFormacion.INSTITUTO);

			List<CentroFormacion> listado = negocio.listar(centroFormacion);
			System.out.println("Total de registros: " + listado.size());

			for (CentroFormacion vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoCentroFormacion().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la b�squeda: " + e.getMessage());
		}
	}

	@Test
	public void buscarPorTipoTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setNombre("");
			centroFormacion
					.setTipoCentroFormacion(TipoCentroFormacion.INSTITUTO);

			List<CentroFormacion> listado = negocio.listar(centroFormacion);
			System.out.println("Total de registros: " + listado.size());

			for (CentroFormacion vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoCentroFormacion().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la b�squeda: " + e.getMessage());
		}
	}

	@Test
	public void eliminarTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			String codigo = "10804050202";
			int registroAfectado = negocio.eliminar(codigo);
			Assert.assertTrue(registroAfectado > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la eliminici�n: " + e.getMessage());
		}
	}
}