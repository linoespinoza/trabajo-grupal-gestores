package gestores.test;

import gestores.bean.Puntaje;
import gestores.enums.EstadoIdea;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.EvaluacionIdea;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EvaluacionIdeaTest {

	@Test
	public void obtenerEvaluacionTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Integer codigo = 2;
			Idea vo = negocio.obtenerEvaluacion(codigo);
			Assert.assertNotNull(vo);
		} catch (NegocioExcepcion e) {
			Assert.fail("Validación: " + e.getMessage());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la obtención: " + e.getMessage());
		}
	}

	@Test
	public void aprobarTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Idea idea = new Idea();
			idea.setCodigo(2);
			idea.setEstadoIdea(EstadoIdea.APROBADA);

			int registroAfectado = negocio.actualizarEstado(idea);
			Assert.assertTrue(registroAfectado > 0);
		} catch (NegocioExcepcion e) {
			Assert.fail("Validación: " + e.getMessage());
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la aprobación: " + e.getMessage());
		}
	}

	@Test
	public void rechazarTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Idea idea = new Idea();
			idea.setCodigo(2);
			idea.setEstadoIdea(EstadoIdea.RECHAZADA);

			int registroAfectado = negocio.actualizarEstado(idea);
			Assert.assertTrue(registroAfectado > 0);
		} catch (NegocioExcepcion e) {
			Assert.fail("Validación: " + e.getMessage());
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la desaprobación: " + e.getMessage());
		}
	}

	@Test
	public void asignarAsesorTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Usuario estudiante = new Usuario();
			estudiante.setCodigo(2);

			Usuario asesor = new Usuario();
			asesor.setCodigo(7);

			Idea idea = new Idea();
			idea.setCodigo(2);
			idea.setEstudiante(estudiante);
			idea.setAsesor(asesor);

			int registroAfectado = negocio.asignarAsesor(idea);
			Assert.assertTrue(registroAfectado > 0);
		} catch (NegocioExcepcion e) {
			Assert.fail("Validación: " + e.getMessage());
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la asignación de asesor: " + e.getMessage());
		}
	}

	@Test
	public void listarEvaluacionTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Idea idea = new Idea();
			idea.setTitulo("");

			Usuario evaluador = new Usuario();
			evaluador.setCodigo(8);

			List<Idea> listado = negocio.listarEvaluacion(idea, evaluador);
			System.out.println("Total de registros: " + listado.size());

			for (Idea vo : listado) {
				System.out.println(vo.getTitulo() + " - "
						+ vo.getEstadoIdea().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la búsqueda: " + e.getMessage());
		}
	}

	@Test
	public void buscarEvaluacionPorTituloTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Idea idea = new Idea();
			idea.setTitulo("Matricula");

			Usuario evaluador = new Usuario();
			evaluador.setCodigo(8);

			List<Idea> listado = negocio.listarEvaluacion(idea, evaluador);
			System.out.println("Total de registros: " + listado.size());

			for (Idea vo : listado) {
				System.out.println(vo.getTitulo() + " - "
						+ vo.getEstadoIdea().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la búsqueda: " + e.getMessage());
		}
	}

	@Test
	public void listarResumenPuntajeTest() {
		EvaluacionIdea negocio = new EvaluacionIdea();
		try {
			Integer codigo = 2;

			List<Puntaje> listado = negocio.listarResumenPuntaje(codigo);
			System.out.println("Total de registros: " + listado.size());

			for (Puntaje vo : listado) {
				System.out.println(vo.getValorPuntaje() + " - "
						+ vo.getCantidadUsuarios());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la búsqueda: " + e.getMessage());
		}
	}
}