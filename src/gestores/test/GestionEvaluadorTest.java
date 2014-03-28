package gestores.test;

import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.GestionEvaluador;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GestionEvaluadorTest {

	@Test
	/**
	 * @author Marco Ch.
	 */
	public void listarIdeasporCF_Eval_CondTest() {
		GestionEvaluador negocio = new GestionEvaluador();
		try {
			Date fechaInicio = null;
			Date fechaFin = null;
	
			CentroFormacion centroFormacion = new CentroFormacion();
			centroFormacion.setCodigo("10334522659");
				
			Usuario evaluador = new Usuario();
			evaluador.setCentroFormacion(centroFormacion);
			
			Idea idea = new Idea();
			idea.setTitulo(null);
			idea.setDescripcion(null);
			idea.setPalabrasClave(null);
			idea.setEstadoIdea(null);
				
		
			List<Idea> listado = negocio.listaIdeasporCF(evaluador, idea, fechaInicio, fechaFin);
			System.out.println("Total de registros: " + listado.size());
	
			for (Idea vo : listado) {
				System.out.println(vo.getTitulo() + " | "
						+ vo.getDescripcion() +  " | "
						+ vo.getPalabrasClave() + " | "
						+ vo.getArchivo() + " | "
						+ vo.getEstudiante().getApellidoPaterno()
						+ vo.getEstudiante().getApellidoMaterno() + ", "
						+ vo.getEstudiante().getNombre() + " | "
						+ vo.getEstadoIdea().getCodigo() + " | "
						+ vo.getFechaCreacion());
			}
			Assert.assertTrue(listado.size() > 0);
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la búsqueda: " + e.getMessage());
		}
	}

}
