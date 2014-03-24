package gestores.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

//import gestores.util.*;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Usuario;
import gestores.modelo.Idea;
import gestores.negocio.GestionIdeas;
import gestores.negocio.GestionUsuarios;

public class GestionIdeasTest {
	
//	@Test
	public void insertar_ideaTest(){
		
		java.util.Date hoy = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(hoy.getTime());
		//System.out.println(sqlDate);
				
		Idea i = new Idea();
		i.setCoIdea(2);
		i.setTitulo("Preview de HTC One X");
		i.setDescripcion("Se busca comparar la nueva version de celular");
		i.setPalabras("HTC, One, Android, Jelly Bean");
		i.setArchivo("HTC");
		i.setCoEstudiante(5);
		i.setCoEstado("CRE");
		i.setFechaCreacion(sqlDate);
		i.setFechaPublicacion(sqlDate);
		i.setCoAsesor(3);
		
		GestionIdeas gi = new GestionIdeas();
		try {
			gi.insertar_idea(i);
			System.out.println("OK! Registro Insertado Exitosamente");
		} catch (DAOExcepcion e) {
			Assert.fail("No insertó: " + e.getMessage());
		}		
	}

//	@Test
	public void listar_ideaTest() {

		String estado_idea,t1,t2;
		int lista_out=1;
		t1="CRE";
		t2="PUB";
		
		GestionIdeas negocio = new GestionIdeas();
		GestionUsuarios negocio2 = new GestionUsuarios();
		
		try {
			Collection<Idea> listado = negocio.listar_idea();
			System.out.println("Total de registros: "+ listado.size());
			System.out.println("------------------------");
			
			for (Idea idea : listado) {

				System.out.println("Registro Número  : "+lista_out++);
				System.out.println("----------------------------------------------------");
				System.out.println("Código           : "+idea.getCoIdea());
				System.out.println("Título           : "+idea.getTitulo());
				System.out.println("Descripción      : "+idea.getDescripcion());
				System.out.println("Palabras clave   : "+idea.getPalabras());
				System.out.println("Archivo          : "+idea.getArchivo());
				//System.out.println("Código Estudiante : "+idea.getUsuarioEstudiante().getIdUsuario());
				System.out.println("Código Estudiante: "+idea.getCoEstudiante());
				
				Collection<Usuario> listado2 = negocio2.buscarNombre_Usuario(idea.getCoEstudiante());
				for (Usuario usuario : listado2){
					System.out.println("Nombre Estudiante: "+usuario.getNombre()+" "+usuario.getApellidoPaterno()+" "+usuario.getApellidoMaterno());
				}
				
				if (t1.equals(idea.getCoEstado())){
					estado_idea = "CREADA";

				}else{
					if (t2.equals(idea.getCoEstado())){
						estado_idea="PUBLICADA";
					}else{
						estado_idea="APROBADA";
					}
				}
				System.out.println("Tipo Estado Idea : "+estado_idea);
				System.out.println("Fecha Creación   : "+idea.getFechaCreacion());
				System.out.println("Fecha Publicación: "+idea.getFechaPublicacion());	
				System.out.println("Código Asesor    : "+idea.getCoAsesor());
				
				Collection<Usuario> listado3 = negocio2.buscarNombre_Usuario(idea.getCoAsesor());
				for (Usuario usuario : listado3){
					System.out.println("Nombre Asesor    : "+usuario.getNombre()+" "+usuario.getApellidoPaterno()+" "+usuario.getApellidoMaterno());
				}
				System.out.println("----------------------------------------------------");
			}
			
			Assert.assertTrue(listado.size() > 0);			
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
	@Test
	public void buscarCadena_ideaTest() {

		String estado_idea,t1,t2;
		int lista_out=1;
		t1="CRE";
		t2="PUB";
		
		String cadena="bean";
		
		GestionIdeas negocio = new GestionIdeas();
		GestionUsuarios negocio2 = new GestionUsuarios();
		
		try {
			Collection<Idea> listado = negocio.buscarCadena_idea(cadena);
			System.out.println("Total de registros: "+ listado.size());
			System.out.println("------------------------");
			
			for (Idea idea : listado) {

				System.out.println("Registro Número  : "+lista_out++);
				System.out.println("----------------------------------------------------");
				System.out.println("Código           : "+idea.getCoIdea());
				System.out.println("Título           : "+idea.getTitulo());
				System.out.println("Descripción      : "+idea.getDescripcion());
				System.out.println("Palabras clave   : "+idea.getPalabras());
				System.out.println("Archivo          : "+idea.getArchivo());
				//System.out.println("Código Estudiante : "+idea.getUsuarioEstudiante().getIdUsuario());
				System.out.println("Código Estudiante: "+idea.getCoEstudiante());
				
				Collection<Usuario> listado2 = negocio2.buscarNombre_Usuario(idea.getCoEstudiante());
				for (Usuario usuario : listado2){
					System.out.println("Nombre Estudiante: "+usuario.getNombre()+" "+usuario.getApellidoPaterno()+" "+usuario.getApellidoMaterno());
				}
				
				if (t1.equals(idea.getCoEstado())){
					estado_idea = "CREADA";

				}else{
					if (t2.equals(idea.getCoEstado())){
						estado_idea="PUBLICADA";
					}else{
						estado_idea="APROBADA";
					}
				}
				System.out.println("Tipo Estado Idea : "+estado_idea);
				System.out.println("Fecha Creación   : "+idea.getFechaCreacion());
				System.out.println("Fecha Publicación: "+idea.getFechaPublicacion());	
				System.out.println("Código Asesor    : "+idea.getCoAsesor());
				
				Collection<Usuario> listado3 = negocio2.buscarNombre_Usuario(idea.getCoAsesor());
				for (Usuario usuario : listado3){
					System.out.println("Nombre Asesor    : "+usuario.getNombre()+" "+usuario.getApellidoPaterno()+" "+usuario.getApellidoMaterno());
				}
				System.out.println("----------------------------------------------------");
			}
			
			Assert.assertTrue(listado.size() > 0);			
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
}
