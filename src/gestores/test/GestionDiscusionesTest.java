package gestores.test;

import gestores.exception.DAOExcepcion;
import gestores.modelo.Discusion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.negocio.GestionIdeas;
import gestores.negocio.GestionUsuarios;
import gestores.negocio.GestionDiscusiones;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class GestionDiscusionesTest {

	@Test
	public void insertar_discusionesTest(){
		
		java.util.Date hoy = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(hoy.getTime());
		//System.out.println(sqlDate);
				
		Discusion d = new Discusion();
		d.setCoDiscusion(2);
		d.setCoIdea(1);
		d.setCoUsuario(9);
		d.setComentario("No me parece bien tu idea");
		d.setFechaCreacion(sqlDate);
		
		GestionDiscusiones gd = new GestionDiscusiones();
		try {
			gd.insertar(d);
			System.out.println("OK! Registro Insertado Exitosamente");
		} catch (DAOExcepcion e) {
			Assert.fail("No insertó: " + e.getMessage());
		}		
	}

//	@Test
	public void buscarTexto_discusionesTest(){
		
	}
	
//	@Test
	public void listar_discusionesTest() {

		int lista_out=1;
		
		GestionDiscusiones negocio = new GestionDiscusiones();
		GestionIdeas negocio2 = new GestionIdeas();
		GestionUsuarios negocio3 = new GestionUsuarios();
		
		try {
			Collection<Discusion> listado = negocio.listar();
			System.out.println("Total de registros: "+ listado.size());
			System.out.println("------------------------");
			
			for (Discusion discusion : listado) {

				System.out.println("Registro Número  : "+lista_out++);
				System.out.println("----------------------------------------------------");
				System.out.println("Código Discusion : "+discusion.getCoDiscusion());
				System.out.println("Código Idea      : "+discusion.getCoIdea());
				Collection<Idea> listado2 = negocio2.buscarNombre_idea(discusion.getCoIdea());
				for (Idea idea : listado2){
					System.out.println("Nombre Idea      : "+idea.getTitulo());
				}							
				System.out.println("Código Usuario   : "+discusion.getCoUsuario());
				Collection<Usuario> listado3 = negocio3.buscarNombre_Usuario(discusion.getCoUsuario());
				for (Usuario usuario : listado3){
					System.out.println("Nombre Estudiante: "+usuario.getNombre()+" "+usuario.getApellidoPaterno()+" "+usuario.getApellidoMaterno());
				}
				System.out.println("Comentario       : "+discusion.getComentario());
				System.out.println("Fecha Creación   : "+discusion.getFechaCreacion());
				System.out.println("----------------------------------------------------");
			}
			
			Assert.assertTrue(listado.size() > 0);			
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
}
