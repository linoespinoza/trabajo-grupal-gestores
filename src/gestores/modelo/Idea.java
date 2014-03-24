
package gestores.modelo;

import java.util.ArrayList;
import java.util.Date;

public class Idea {
    
    private int coIdea;
    private String titulo;
    private String descripcion;
    private String palabras;
    private String archivo;
    private int coEstudiante;
    private String coEstado;
    private Date fechaCreacion;
    private Date fechaPublicacion;
    private int coAsesor; 
   

/*    // Una idea es creada por un usuario (Estudiante)
    private Usuario usuarioEstudiante;

    // Una idea es asesorada a un usuario (Asesor)
    private Usuario usuarioAsesor;
*/       
    // Una idea puede generar una o muchas reuniones
    private ArrayList<Reunion> reuniones;

    // Constructor
    
    // Getters / Setters
    
    public int getCoIdea() {
        return coIdea;
    }

    public void setCoIdea(int coIdea) {
        this.coIdea = coIdea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPalabras() {
        return palabras;
    }

    public void setPalabras(String palabras) {
        this.palabras = palabras;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
/*
    public Usuario getUsuarioAsesor() {
        return usuarioAsesor;
    }

    public void setUsuarioAsesor(Usuario usuarioAsesor) {
        this.usuarioAsesor = usuarioAsesor;
    }

    public Usuario getUsuarioEstudiante() {
        return usuarioEstudiante;
    }

    public void setUsuarioEstudiante(Usuario usuarioEstudiante) {
        this.usuarioEstudiante = usuarioEstudiante;
    }
*/
    public ArrayList<Reunion> getReuniones() {
        return reuniones;
    }

    public void setReuniones(ArrayList<Reunion> reuniones) {
        this.reuniones = reuniones;
    }

	public String getCoEstado() {
		return coEstado;
	}

	public void setCoEstado(String coEstado) {
		this.coEstado = coEstado;
	}

	public int getCoEstudiante() {
		return coEstudiante;
	}

	public void setCoEstudiante(int coEstudiante) {
		this.coEstudiante = coEstudiante;
	}

	public int getCoAsesor() {
		return coAsesor;
	}

	public void setCoAsesor(int coAsesor) {
		this.coAsesor = coAsesor;
	}

}
