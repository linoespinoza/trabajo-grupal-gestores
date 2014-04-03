package gestores.test;

import gestores.enums.TipoCalificacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Reunion;
import gestores.modelo.Usuario;
import gestores.negocio.GestionReunion;
import gestores.util.FechaUtil;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jeremías Yalta.
 */
public class GestionReunionTest {

	@Test
	public void insertarTest() {
		GestionReunion negocio = new GestionReunion();
		try {
			Idea idea = new Idea();
			idea.setCodigo(5);

			Usuario asesor = new Usuario();
			asesor.setCodigo(5);
			idea.setAsesor(asesor);

			Reunion reunion = new Reunion();
			reunion.setIdea(idea);
			reunion.setFechaReunion(FechaUtil.establecerFechaHora(19, 3, 2014,
					12, 30, 0));
			reunion.setObservacion("El proyecto es muy interesante y va por buen camino");
			reunion.setTipoCalificacion(TipoCalificacion.BUENO);

			Reunion vo = negocio.insertar(reunion);
			System.out.println("Se insertó la reunión de la idea "
					+ vo.getIdea().getCodigo() + " en la fecha "
					+ vo.getFechaReunion());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}

	@Test
	public void listarTest() {
		GestionReunion negocio = new GestionReunion();
		try {
			Date fechaInicio = null;
			Date fechaFin = null;

			Usuario asesor = new Usuario();
			asesor.setCodigo(5);

			Idea idea = new Idea();
			idea.setAsesor(asesor);

			Reunion reunion = new Reunion();
			reunion.setIdea(idea);
			reunion.setTipoCalificacion(null);

			List<Reunion> listado = negocio.listar(fechaInicio, fechaFin,
					reunion);
			System.out.println("Total de registros: " + listado.size());

			for (Reunion vo : listado) {
				System.out.println("Reunión: " + vo.getCodigo() + ", Idea: "
						+ vo.getIdea().getTitulo() + ", Calificación: "
						+ vo.getTipoCalificacion().getNombre());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la búsqueda: " + e.getMessage());
		}
	}
}