package gestores.test;

import gestores.enums.EstadoIdea;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
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

	// @Test
	public void estudianteCreaIdeaConDatosIndicados() {

		GestionIdea gestion = new GestionIdea();

		String tituloIdea = "Titulo Idea 1";
		String descripcionIdea = "Descripción de la idea 1";
		String palabrasClave = "tag1,tag2,tag3,tag4";
		String archivo = "/documento/documento.docx";
		Date fechaCreacion = FechaUtil.establecerFechaHora(1,
				Calendar.DECEMBER, 2014, 23, 11, 59);
		EstadoIdea estadoIdea = EstadoIdea.CREADA;

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
			idea.setEstadoIdea(EstadoIdea.CREADA); // Creada

			Idea ideaCreada = gestion.insertar(idea);

			System.out
					.println("Se inserto la idea correctamente. El id ingresado fue: "
							+ ideaCreada.getCodigo());
		} catch (NegocioExcepcion e) {
			Assert.fail("Validación: " + e.getMessage());
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
		String archivo = "/documento/documento.docx";
		Date fechaCreacion = FechaUtil.establecerFechaHora(1,
				Calendar.DECEMBER, 2014, 23, 11, 59);
		EstadoIdea estadoIdea = EstadoIdea.CREADA;

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
			idea.setEstadoIdea(EstadoIdea.CREADA); // Creada

			Idea ideaCreada = gestion.insertar(idea);

			System.out
					.println("Se inserto la idea correctamente. El id ingresado fue: "
							+ ideaCreada.getCodigo());
		} catch (NegocioExcepcion e) {
			Assert.fail("Validación: " + e.getMessage());
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
		Date fechaCreacion = FechaUtil.establecerFechaHora(1,
				Calendar.DECEMBER, 2014, 23, 11, 59);
		EstadoIdea estadoIdea = EstadoIdea.CREADA;

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
			idea.setEstadoIdea(EstadoIdea.CREADA); // Creada

			Idea ideaCreada = gestion.insertar(idea);

			System.out
					.println("Se inserto la idea correctamente. El id ingresado fue: "
							+ ideaCreada.getCodigo());
		} catch (NegocioExcepcion e) {
			Assert.fail("Validación: " + e.getMessage());
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
		Date fechaCreacion = FechaUtil.establecerFechaHora(1,
				Calendar.DECEMBER, 2014, 23, 11, 59);
		EstadoIdea estadoIdea = EstadoIdea.CREADA;

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
			idea.setEstadoIdea(EstadoIdea.CREADA); // Creada

			Idea ideaCreada = gestion.insertar(idea);

			System.out
					.println("Se inserto la idea correctamente. El id ingresado fue: "
							+ ideaCreada.getCodigo());
		} catch (NegocioExcepcion e) {
			Assert.fail("Validación: " + e.getMessage());
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

			System.out.println("Se actualizó correctamente la idea: "
					+ ideaCreada.getCodigo());
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la insercion: " + e.getMessage());
		}
	}
}
