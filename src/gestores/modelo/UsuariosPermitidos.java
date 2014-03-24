
package gestores.modelo;

import java.util.ArrayList;


public class UsuariosPermitidos {
    
    private int puntaje;
  
    private int CoIdea;
    private int CoUsuario;

    public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getCoIdea() {
		return CoIdea;
	}

	public void setCoIdea(int coIdea) {
		CoIdea = coIdea;
	}

	public int getCoUsuario() {
		return CoUsuario;
	}

	public void setCoUsuario(int coUsuario) {
		CoUsuario = coUsuario;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

/*    // Idea permitida
    private Idea idea;
*/    
    // Lista de usuarios permitidos por idea
    private ArrayList<Usuario> usuarios;
    
}
