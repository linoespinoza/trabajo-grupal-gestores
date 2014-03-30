package gestores.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gestores.enums.EstadoIdea;
import gestores.modelo.Idea;
import gestores.util.FechaUtil;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * @author Lino Espinoza.
 */
public class GestionIdeaTest {

	@Test
	public void ideaDebeCrearseConLosDatosIndicados() {
		Idea idea = new Idea();

		String tituloIdea = "Titulo Idea 1";
		String descripcionIdea = "Descripción de la idea 1";

		// Uso de la libreria Calendar para el manejo de fechas
		// Date fechaSinHora = FechaUtil.establecerFecha(1, Calendar.DECEMBER,
		// 2014);
		Date fechaCreacion = FechaUtil.establecerFechaHora(1,
				Calendar.DECEMBER, 2014, 23, 11, 59);

		String palabrasClave = "tag1,tag2,tag3,tag4";
		String terceraPalabra = "tag3";
		String[] palabraClaveArray = palabrasClave.split(",");

		idea.setTitulo(tituloIdea);
		idea.setDescripcion(descripcionIdea);
		idea.setPalabrasClave(palabrasClave);
		idea.setFechaCreacion(fechaCreacion);
		idea.setEstadoIdea(EstadoIdea.Creada); // Creada

		assertNotNull(idea);
		assertEquals(tituloIdea, idea.getTitulo());
		assertEquals(descripcionIdea, idea.getDescripcion());
		assertEquals(palabrasClave, idea.getPalabrasClave());
		assertEquals(terceraPalabra, palabraClaveArray[2]);
		assertEquals(fechaCreacion, idea.getFechaCreacion());
		assertEquals(EstadoIdea.Creada, idea.getEstadoIdea());
	}
}