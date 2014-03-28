package gestores.test;

import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.PlanTarifario;
import gestores.negocio.GestionCentroFormacion;

import java.util.List;

import org.junit.Assert;

public class GestionCentroFormacionTest {

	//@Test
	public void insertarTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			PlanTarifario planTarifario = new PlanTarifario();
			planTarifario.setCodigo(2);

			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setCodigo("10804050208");
			centroFormacion.setNombre("Instituto Superior Tecnologico IDAT");
			centroFormacion
					.setTipoCentroFormacion(TipoCentroFormacion.Instituto);
			centroFormacion.setUrl("http://www.idat.edu.pe");
			centroFormacion.setLogo("/images/logo/logoIdat.png");
			centroFormacion.setPlanTarifario(planTarifario);

			CentroFormacion vo = negocio.insertar(centroFormacion);
			System.out.println("Se insertó el id: " + vo.getCodigo());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	//@Test
	public void obtenerTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			String codigo = "10804050208";
			CentroFormacion vo = negocio.obtener(codigo);
			Assert.assertNotNull(vo);
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la obtención: " + e.getMessage());
		}
	}

	//@Test
	public void actualizarTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			PlanTarifario planTarifario = new PlanTarifario();
			planTarifario.setCodigo(3);

			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setCodigo("10804050208");
			centroFormacion.setNombre("Instituto IDAT");
			centroFormacion
					.setTipoCentroFormacion(TipoCentroFormacion.Instituto);
			centroFormacion.setUrl("http://www.idat.edu.pe/index.jsp");
			centroFormacion.setLogo("/images/logo/logoIdat.png");
			centroFormacion.setPlanTarifario(planTarifario);

			CentroFormacion vo = negocio.actualizar(centroFormacion);
			System.out.println("Se actualizó el id: " + vo.getCodigo());
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la actualización: " + e.getMessage());
		}
	}

	//@Test
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
						+ vo.getTipoCentroFormacion().toString());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la búsqueda: " + e.getMessage());
		}
	}

	//@Test
	public void buscarPorNombreTipoTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setNombre("Cibertec");
			centroFormacion
					.setTipoCentroFormacion(TipoCentroFormacion.Instituto);

			List<CentroFormacion> listado = negocio.listar(centroFormacion);
			System.out.println("Total de registros: " + listado.size());

			for (CentroFormacion vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoCentroFormacion().toString());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la búsqueda: " + e.getMessage());
		}
	}

	//@Test
	public void buscarPorTipoTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setNombre("");
			centroFormacion
					.setTipoCentroFormacion(TipoCentroFormacion.Instituto);

			List<CentroFormacion> listado = negocio.listar(centroFormacion);
			System.out.println("Total de registros: " + listado.size());

			for (CentroFormacion vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoCentroFormacion().toString());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la búsqueda: " + e.getMessage());
		}
	}

	//@Test
	public void eliminarTest() {
		GestionCentroFormacion negocio = new GestionCentroFormacion();
		try {
			String codigo = "10804050208";
			negocio.eliminar(codigo);
			CentroFormacion vo = negocio.obtener(codigo);
			Assert.assertNull(null, vo);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la eliminición: " + e.getMessage());
		}
	}
}