package gestores.modelo;

//import java.util.ArrayList;
import java.util.Date;

public class Discusion {

    private int coDiscusion;
    private int coIdea;
    private int CoUsuario;
    private String Comentario;
    private Date FechaCreacion;
    
    //private ArrayList<Usuario> usuarios;
    
	public int getCoDiscusion() {
		return coDiscusion;
	}
	public void setCoDiscusion(int coDiscusion) {
		this.coDiscusion = coDiscusion;
	}
	public int getCoIdea() {
		return coIdea;
	}
	public void setCoIdea(int coIdea) {
		this.coIdea = coIdea;
	}
	public int getCoUsuario() {
		return CoUsuario;
	}
	public void setCoUsuario(int coUsuario) {
		CoUsuario = coUsuario;
	}
	public String getComentario() {
		return Comentario;
	}
	public void setComentario(String comentario) {
		Comentario = comentario;
	}
	public Date getFechaCreacion() {
		return FechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}
  
    
}
