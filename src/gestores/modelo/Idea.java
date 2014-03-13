/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lino Espinoza
 */
public class Idea {
    
    private int idIdea;
    private String titulo;
    private String descripcion;
    private String referencia;
    private Date fechaCreacion;
    private Date fechaPublicacion;
    // Una idea puede tener un estado
    private TipoEstadoIdea tipoEstado;    

    // Una idea es creada por un usuario (Estudiante)
    private Usuario usuarioEstudiante;

    // Una idea es asesorada a un usuario (Asesor)
    private Usuario usuarioAsesor;
        
    // Una idea puede generar una o muchas reuniones
    private ArrayList<Reunion> reuniones;

    // Constructor
    
    // Getters / Setters
    
    public int getIdIdea() {
        return idIdea;
    }

    public void setIdIdea(int idIdea) {
        this.idIdea = idIdea;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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

    public TipoEstadoIdea getTipoEstado() {
        return tipoEstado;
    }
    
    public void setTipoEstado(TipoEstadoIdea tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public ArrayList<Reunion> getReuniones() {
        return reuniones;
    }

    public void setReuniones(ArrayList<Reunion> reuniones) {
        this.reuniones = reuniones;
    }
    
    
}
