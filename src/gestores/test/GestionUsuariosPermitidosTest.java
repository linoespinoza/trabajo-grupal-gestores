package gestores.test;

import java.util.Collection;

import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.modelo.UsuariosPermitidos;
import gestores.negocio.GestionIdeas;
import gestores.negocio.GestionUsuarios;
import gestores.negocio.GestionUsuariosPermitidos;

import org.junit.Assert;
import org.junit.Test;

public class GestionUsuariosPermitidosTest {

	@Test
	public void insertar_PuntajeTest(){
				
		UsuariosPermitidos up = new UsuariosPermitidos();
		up.setCoUsuario(9);
		up.setCoIdea(1);
		up.setPuntaje(5);

		GestionUsuariosPermitidos gup = new GestionUsuariosPermitidos();
		
		try {
			
			Collection<UsuariosPermitidos> listado = gup.buscar_Puntaje(up.getCoUsuario(),up.getCoIdea());

			if (listado.size() == 1){
				for (UsuariosPermitidos usuariospermitidos : listado){
					if (usuariospermitidos.getPuntaje() == 0){
						gup.insertar_Puntaje(up);
						System.out.println("OK! Puntaje Registrado Exitosamente");
					}else{
						System.out.println("Puntaje ya asignado");
					}
				}
			}

		} catch (DAOExcepcion e) {
			Assert.fail("No insertó: " + e.getMessage());
		}		
	}
	
//	@Test
	public void buscar_PuntajeTest (){
		
		int user=9;
		int idea=1;
		String nombre = null;
		String nombre_idea = null;
		
		GestionUsuariosPermitidos negocio = new GestionUsuariosPermitidos();
		
		GestionIdeas negocio2 = new GestionIdeas();
		GestionUsuarios negocio3 = new GestionUsuarios();
		
		try{
			Collection<Usuario> listado = negocio3.buscarNombre_Usuario(user);
			for (Usuario usuario : listado){
				nombre = usuario.getNombre()+" "+usuario.getApellidoPaterno()+" "+usuario.getApellidoMaterno();
			}
			
			Collection<Idea> listado2 = negocio2.buscarNombre_idea(idea);
			for (Idea ideas : listado2){
				nombre_idea = ideas.getTitulo();
			}
			
			Collection<UsuariosPermitidos> listado3 = negocio.buscar_Puntaje(user,idea);				
			if (listado.size() > 0){
				for (UsuariosPermitidos usuariospermitidos : listado3){
					System.out.println("El puntaje asignado por el usuario " + nombre + " a la idea " + nombre_idea + " es : "+usuariospermitidos.getPuntaje());
				}
			}else{
				System.out.println("El usuario " + nombre + " no se encuentra asociado a la idea " + nombre_idea);
			}
			Assert.assertTrue(listado.size() > 0);
		}
		catch (DAOExcepcion e) {
		Assert.fail("Falló el listado: " + e.getMessage());
		}
	}
	
}
