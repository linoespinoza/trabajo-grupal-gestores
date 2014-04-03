package gestores.test;

import gestores.enums.EstadoIdea;
import gestores.enums.TipoCentroFormacion;
import gestores.exception.DAOExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.modelo.Idea;
import gestores.modelo.PlanTarifario;
import gestores.modelo.Usuario;
import gestores.negocio.GestionCentroFormacion;
import gestores.negocio.GestionIdea;
import gestores.negocio.GestionUsuario;
import gestores.util.FechaUtil;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Lino Espinoza.
 */
public class GestionIdeaTest {

	//@Test
	public void estudianteCreaIdeaConDatosIndicados() {
		
		GestionIdea gestion = new GestionIdea();
		
		String tituloIdea = "Titulo Idea 1";
		String descripcionIdea = "Descripción de la idea 1";
		String palabrasClave = "tag1,tag2,tag3,tag4";		
		String archivo = "/documento/documento.docx";
		Date fechaCreacion = FechaUtil.establecerFechaHora(1, Calendar.DECEMBER, 2014, 23, 11, 59);
		EstadoIdea estadoIdea = EstadoIdea.Creada;
		
		try {
			GestionUsuario gestionUsuario = new GestionUsuario();
			Usuario estudiante = gestionUsuario.obtener(2);
			
			Idea idea = new Idea();
			idea.setTitulo(tituloIdea);
			idea.setDescripcion(descripcionIdea);
			idea.setPalabrasClave(palabrasClave);
			idea.setArchivo(archivo);
			idea.setFechaCreacion(fechaCreacion);
			idea.setEstudiante(estudiante);
			idea.setEstadoIdea(EstadoIdea.Creada); // Creada
		
			Idea ideaCreada = gestion.insertar(idea);
			
			System.out.println("Se inserto la idea correctamente. El id ingresado fue: " + ideaCreada.getCodigo());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la insercion: " + e.getMessage());
		}
	}
	
	// @Test
	public void estudianteCreaIdeaConUnTituloDuplicado() {
		GestionIdea gestion = new GestionIdea();
		
		String tituloIdea = "Titulo Idea 5";
		String descripcionIdea = "Descripción de la idea 1";
		String palabrasClave = "tag1,tag2,tag3,tag4";
<<<<<<< HEAD
		String archivo = "/documento/documento.docx";
		Date fechaCreacion = FechaUtil.establecerFechaHora(1, Calendar.DECEMBER, 2014, 23, 11, 59);
		EstadoIdea estadoIdea = EstadoIdea.Creada;
		
		try {
			GestionUsuario gestionUsuario = new GestionUsuario();
			Usuario estudiante = gestionUsuario.obtener(2);
			
			Idea idea = new Idea();
			idea.setTitulo(tituloIdea);
			idea.setDescripcion(descripcionIdea);
			idea.setPalabrasClave(palabrasClave);
			idea.setArchivo(archivo);
			idea.setFechaCreacion(fechaCreacion);
			idea.setEstudiante(estudiante);
			idea.setEstadoIdea(EstadoIdea.Creada); // Creada
		
			Idea ideaCreada = gestion.insertar(idea);
			
			System.out.println("Se inserto la idea correctamente. El id ingresado fue: " + ideaCreada.getCodigo());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la insercion: " + e.getMessage());
		}
	}
	
	@Test
	public void estudianteCreaIdeaConUnPalabrasClavesIguales() {
		GestionIdea gestion = new GestionIdea();
		
		String tituloIdea = "Titulo Idea xxxx";
		String descripcionIdea = "Descripción de la idea 1";
		String palabrasClave = "tag1,tag2,tag3,tag1";
		String archivo = "/documento/documento.docx";
		Date fechaCreacion = FechaUtil.establecerFechaHora(1, Calendar.DECEMBER, 2014, 23, 11, 59);
		EstadoIdea estadoIdea = EstadoIdea.Creada;
		
		try {
			GestionUsuario gestionUsuario = new GestionUsuario();
			Usuario estudiante = gestionUsuario.obtener(2);
			
			Idea idea = new Idea();
			idea.setTitulo(tituloIdea);
			idea.setDescripcion(descripcionIdea);
			idea.setPalabrasClave(palabrasClave);
			idea.setArchivo(archivo);
			idea.setFechaCreacion(fechaCreacion);
			idea.setEstudiante(estudiante);
			idea.setEstadoIdea(EstadoIdea.Creada); // Creada
		
			Idea ideaCreada = gestion.insertar(idea);
			
			System.out.println("Se inserto la idea correctamente. El id ingresado fue: " + ideaCreada.getCodigo());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la insercion: " + e.getMessage());
		}
	}
	
	// @Test
	public void estudianteCreaIdeaConDatosIncompletos() {
		GestionIdea gestion = new GestionIdea();
		
		String tituloIdea = null;
		String descripcionIdea = "Descripción de la idea 1";
		String palabrasClave = "tag1,tag2,tag3,tag4";
		String archivo = "/documento/documento.docx";
		Date fechaCreacion = FechaUtil.establecerFechaHora(1, Calendar.DECEMBER, 2014, 23, 11, 59);
		EstadoIdea estadoIdea = EstadoIdea.Creada;
		
		try {
			GestionUsuario gestionUsuario = new GestionUsuario();
			Usuario estudiante = gestionUsuario.obtener(2);
			
			Idea idea = new Idea();
			idea.setTitulo(tituloIdea);
			idea.setDescripcion(descripcionIdea);
			idea.setPalabrasClave(palabrasClave);
			idea.setArchivo(archivo);
			idea.setFechaCreacion(fechaCreacion);
			idea.setEstudiante(estudiante);
			idea.setEstadoIdea(EstadoIdea.Creada); // Creada
		
			Idea ideaCreada = gestion.insertar(idea);
			
			System.out.println("Se inserto la idea correctamente. El id ingresado fue: " + ideaCreada.getCodigo());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la insercion: " + e.getMessage());
		}
	}
	
	// @Test
	public void estudianteActualizaIdeaConDatosIndicados() {
		GestionIdea gestion = new GestionIdea();
		
		Integer codigoIdea = 6;
		String tituloIdea = "Titulo Nuevo";
		String descripcionIdea = "Descripción de la idea 1";
		String palabrasClave = "tag1,tag2,tag3,tag4";
		String archivo = "/documento/documento.docx";
		
		try {
			Idea idea = new Idea();
			idea.setCodigo(codigoIdea);
			idea.setTitulo(tituloIdea);
			idea.setDescripcion(descripcionIdea);
			idea.setPalabrasClave(palabrasClave);
			idea.setArchivo(archivo);
		
			Idea ideaCreada = gestion.actualizar(idea);
			
			System.out.println("Se actualizó correctamente la idea: " + ideaCreada.getCodigo());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la insercion: " + e.getMessage());
		}
=======
		String terceraPalabra = "tag3";
		String[] palabraClaveArray = palabrasClave.split(",");

		idea.setTitulo(tituloIdea);
		idea.setDescripcion(descripcionIdea);
		idea.setPalabrasClave(palabrasClave);
		idea.setFechaCreacion(fechaCreacion);
		idea.setEstadoIdea(EstadoIdea.CREADA); // Creada

		assertNotNull(idea);
		assertEquals(tituloIdea, idea.getTitulo());
		assertEquals(descripcionIdea, idea.getDescripcion());
		assertEquals(palabrasClave, idea.getPalabrasClave());
		assertEquals(terceraPalabra, palabraClaveArray[2]);
		assertEquals(fechaCreacion, idea.getFechaCreacion());
		assertEquals(EstadoIdea.CREADA, idea.getEstadoIdea());
>>>>>>> branch 'master' of https://github.com/linoespinoza/trabajo-grupal-gestores.git
	}
}
