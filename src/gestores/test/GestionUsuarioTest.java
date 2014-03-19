package gestores.test;

import gestores.enums.FiltroBusquedaUsuario;
import gestores.enums.TipoDocumento;
import gestores.enums.TipoUsuario;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Usuario;
import gestores.negocio.GestionUsuario;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jerem�as Yalta.
 */
public class GestionUsuarioTest {

	@Test
	public void insertarTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setCodigo("10406048417");

			Usuario usuario = new Usuario();
			usuario.setNombre("Victoria");
			usuario.setApellidoPaterno("Hernandez");
			usuario.setApellidoMaterno("Rodriguez");
			usuario.setSexo("F");
			usuario.setTipoDocumento(TipoDocumento.CarnetExtranjeria);
			usuario.setNumeroDocumento("CEX123456789");
			usuario.setEmail("victoria.hernandez@upc.edu.pe");
			usuario.setNumeroCelular("962329330");
			usuario.setContrasenia("vhernandez");
			usuario.setTipoUsuario(TipoUsuario.Evaluador);
			usuario.setCentroFormacion(centroFormacion);

			Usuario vo = negocio.insertar(usuario);
			System.out.println("Se insert� el usuario: " + vo.getNombre() + " "
					+ vo.getApellidoPaterno() + " " + vo.getApellidoMaterno());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserci�n: " + e.getMessage());
		}
	}

	@Test
	public void obtenerTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Integer codigo = 9;
			Usuario vo = negocio.obtener(codigo);
			Assert.assertNotNull(vo);
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la obtenci�n: " + e.getMessage());
		}
	}

	@Test
	public void actualizarTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setCodigo("10406048417");

			Usuario usuario = new Usuario();
			usuario.setCodigo(9);
			usuario.setNombre("Victoria");
			usuario.setApellidoPaterno("Hernandez");
			usuario.setApellidoMaterno("Rodriguez");
			usuario.setSexo("F");
			usuario.setTipoDocumento(TipoDocumento.Ruc);
			usuario.setNumeroDocumento("10556089321");
			usuario.setEmail("victoria.h@upc.edu.pe");
			usuario.setNumeroCelular("962329555");
			usuario.setTipoUsuario(TipoUsuario.Evaluador);
			usuario.setCentroFormacion(centroFormacion);

			Usuario vo = negocio.actualizar(usuario);
			System.out.println("Se actualiz� el id: " + vo.getCodigo());
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la actualizaci�n: " + e.getMessage());
		}
	}

	@Test
	public void listarTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Usuario usuario = new Usuario();
			usuario.setNombre("");
			usuario.setTipoUsuario(null);

			List<Usuario> listado = negocio.listar(
					FiltroBusquedaUsuario.Nombre, usuario);
			System.out.println("Total de registros: " + listado.size());

			for (Usuario vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoUsuario().toString());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la b�squeda: " + e.getMessage());
		}
	}

	@Test
	public void buscarPorTipoTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Usuario usuario = new Usuario();
			usuario.setNombre("");
			usuario.setTipoUsuario(TipoUsuario.Evaluador);

			List<Usuario> listado = negocio.listar(
					FiltroBusquedaUsuario.Nombre, usuario);
			System.out.println("Total de registros: " + listado.size());

			for (Usuario vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoUsuario().toString());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la b�squeda: " + e.getMessage());
		}
	}

	@Test
	public void buscarPorNombreTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Usuario usuario = new Usuario();
			usuario.setNombre("Victoria");
			usuario.setTipoUsuario(null);

			List<Usuario> listado = negocio.listar(
					FiltroBusquedaUsuario.Nombre, usuario);
			System.out.println("Total de registros: " + listado.size());

			for (Usuario vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoUsuario().toString());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la b�squeda: " + e.getMessage());
		}
	}

	@Test
	public void buscarPorApellidoPaternoTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Usuario usuario = new Usuario();
			usuario.setApellidoPaterno("Hernandez");
			usuario.setTipoUsuario(null);

			List<Usuario> listado = negocio.listar(
					FiltroBusquedaUsuario.ApellidoPaterno, usuario);
			System.out.println("Total de registros: " + listado.size());

			for (Usuario vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoUsuario().toString());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la b�squeda: " + e.getMessage());
		}
	}

	@Test
	public void buscarPorApellidoMaternoTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Usuario usuario = new Usuario();
			usuario.setApellidoMaterno("Rodriguez");
			usuario.setTipoUsuario(null);

			List<Usuario> listado = negocio.listar(
					FiltroBusquedaUsuario.ApellidoMaterno, usuario);
			System.out.println("Total de registros: " + listado.size());

			for (Usuario vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoUsuario().toString());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la b�squeda: " + e.getMessage());
		}
	}

	@Test
	public void autenticarTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Usuario usuario = new Usuario();
			usuario.setEmail("hbravocoronel@gmail.com");
			usuario.setContrasenia("admin");

			boolean autenticadoFlag = negocio.esAutenticado(usuario);

			System.out.println("Es Autenticado: " + autenticadoFlag);
			Assert.assertTrue(autenticadoFlag);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la autenticaci�n: " + e.getMessage());
		}
	}

	@Test
	public void eliminarTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Integer codigo = 9;
			negocio.eliminar(codigo);
			Usuario vo = negocio.obtener(codigo);
			Assert.assertNull(null, vo);
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la eliminici�n: " + e.getMessage());
		}
	}
}