package gestores.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import gestores.util.*;
import gestores.exception.DAOExcepcion;
import gestores.modelo.TipoEstadoIdea;
import gestores.modelo.Usuario;
import gestores.modelo.Idea;
import gestores.negocio.GestionIdeas;
import gestores.util.ConexionBD;

public class GestionIdeasTest {
	
//	@Test
	public void insertar(){
		
		Usuario u = new Usuario();
		u.setIdUsuario(1);
		
		TipoEstadoIdea t = new TipoEstadoIdea();
		t.setIdEstadoIdea(1);

		Usuario a = new Usuario();
		a.setIdUsuario(2);
		
		Idea i = new Idea();
		i.setIdIdea(2);
		i.setTitulo("Novedades sobre Galaxy S5");
		i.setDescripcion("Se busca comparar la nueva version de celular");
		i.setReferencia("Samsung");
		i.setFechaCreacion(null);
		i.setFechaPublicacion(null);
		i.setTipoEstado(t);
		i.setUsuarioEstudiante(u);
		i.setUsuarioAsesor(a);
		
		GestionIdeas gi = new GestionIdeas();
		try {
			gi.insertar(i);
		} catch (DAOExcepcion e) {
			Assert.fail("No insertó: " + e.getMessage());
		}		
	}

	@Test
	public void listarTest() {

		GestionIdeas negocio = new GestionIdeas();
		int lista_out=1;
		try {
			Collection<Idea> listado = negocio.listar();

			System.out.println("Total de registros: "+ listado.size());
			System.out.println("------------------------");
			
			for (Idea idea : listado) {

				System.out.println("Registro Número  : "+lista_out++);
				System.out.println("----------------------------------------------------");
				System.out.println("Código           : "+idea.getIdIdea());
				System.out.println("Título           : "+idea.getTitulo());
				System.out.println("Descripción      : "+idea.getDescripcion());
				System.out.println("Referencia       : "+idea.getReferencia());
				System.out.println("Fecha Creación   : "+idea.getFechaCreacion());
				System.out.println("Fecha Publicación: "+idea.getFechaPublicacion());	
				System.out.println("Tipo Estado Idea : "+idea.getTipoEstado().getIdEstadoIdea());
				System.out.println("Código Estudiante: "+idea.getUsuarioEstudiante().getIdUsuario());
				System.out.println("Código Asesor    : "+idea.getUsuarioAsesor().getIdUsuario());
				System.out.println("----------------------------------------------------");
			}
			
			Assert.assertTrue(listado.size() > 0);			
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
}
