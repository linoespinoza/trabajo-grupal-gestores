package gestores.test;

import gestores.enums.FiltroBusquedaUsuario;
import gestores.enums.TipoDocumento;
import gestores.enums.TipoUsuario;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Usuario;
import gestores.negocio.GestionUsuario;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jeremías Yalta.
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
			usuario.setTipoDocumento(TipoDocumento.CARNET_EXTRANJERIA);
			usuario.setNumeroDocumento("CEX123456789");
			usuario.setEmail("victoria.hernandez@upc.edu.pe");
			usuario.setNumeroCelular("962329330");
			usuario.setContrasenia("vhernandez");
			usuario.setTipoUsuario(TipoUsuario.EVALUADOR);
			usuario.setCentroFormacion(centroFormacion);

			int registroAfectado = negocio.insertar(usuario);
			Assert.assertTrue(registroAfectado > 0);
		} catch (NegocioExcepcion e) {
			Assert.fail("Validaciï¿½n: " + e.getMessage());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserciï¿½n: " + e.getMessage());
		}
	}

	@Test
	public void obtenerTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Integer codigo = 9;
			Usuario vo = negocio.obtener(codigo);
			Assert.assertNotNull(vo);
		} catch (NegocioExcepcion e) {
			Assert.fail("Validaciï¿½n: " + e.getMessage());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la obtenciï¿½n: " + e.getMessage());
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
			usuario.setTipoDocumento(TipoDocumento.RUC);
			usuario.setNumeroDocumento("10556089321");
			usuario.setEmail("victoria.h@upc.edu.pe");
			usuario.setNumeroCelular("962329555");
			usuario.setTipoUsuario(TipoUsuario.EVALUADOR);
			usuario.setCentroFormacion(centroFormacion);

			int registroAfectado = negocio.actualizar(usuario);
			Assert.assertTrue(registroAfectado > 0);
		} catch (NegocioExcepcion e) {
			Assert.fail("Validaciï¿½n: " + e.getMessage());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallï¿½ la actualizaciï¿½n: " + e.getMessage());
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
					FiltroBusquedaUsuario.NOMBRE, usuario);
			System.out.println("Total de registros: " + listado.size());

			for (Usuario vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoUsuario().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fallï¿½ la bï¿½squeda: " + e.getMessage());
		}
	}

	@Test
	public void buscarPorTipoTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Usuario usuario = new Usuario();
			usuario.setNombre("");
			usuario.setTipoUsuario(TipoUsuario.EVALUADOR);

			List<Usuario> listado = negocio.listar(
					FiltroBusquedaUsuario.NOMBRE, usuario);
			System.out.println("Total de registros: " + listado.size());

			for (Usuario vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoUsuario().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fallï¿½ la bï¿½squeda: " + e.getMessage());
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
					FiltroBusquedaUsuario.NOMBRE, usuario);
			System.out.println("Total de registros: " + listado.size());

			for (Usuario vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoUsuario().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fallï¿½ la bï¿½squeda: " + e.getMessage());
		}
	}

	@Test
	public void buscarPorApellidoPaternoTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Usuario usuario = new Usuario();
			usuario.setNombre("Hernandez");
			usuario.setTipoUsuario(null);

			List<Usuario> listado = negocio.listar(
					FiltroBusquedaUsuario.APELLIDO_PATERNO, usuario);
			System.out.println("Total de registros: " + listado.size());

			for (Usuario vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoUsuario().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fallï¿½ la bï¿½squeda: " + e.getMessage());
		}
	}

	@Test
	public void buscarPorApellidoMaternoTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Usuario usuario = new Usuario();
			usuario.setNombre("Rodriguez");
			usuario.setTipoUsuario(null);

			List<Usuario> listado = negocio.listar(
					FiltroBusquedaUsuario.APELLIDO_MATERNO, usuario);
			System.out.println("Total de registros: " + listado.size());

			for (Usuario vo : listado) {
				System.out.println(vo.getNombre() + " - "
						+ vo.getTipoUsuario().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fallï¿½ la bï¿½squeda: " + e.getMessage());
		}
	}

	@Test
	public void autenticarTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			String email = "victoria.h@upc.edu.pe";
			String contrasenia = "vhernandez";
			Usuario usuario = negocio.autenticar(email, contrasenia);
			Assert.assertNotNull(usuario);
		} catch (NegocioExcepcion e) {
			Assert.fail("Validaciï¿½n: " + e.getMessage());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallï¿½ la autenticaciï¿½n: " + e.getMessage());
		}
	}

	@Test
	public void eliminarTest() {
		GestionUsuario negocio = new GestionUsuario();
		try {
			Integer codigo = 11;
			int registroAfectado = negocio.eliminar(codigo);
			Assert.assertTrue(registroAfectado > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Fallï¿½ la eliminiciï¿½n: " + e.getMessage());
		}
	}
}