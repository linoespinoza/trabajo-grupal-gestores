package gestores.modelo;

import gestores.enums.EstadoIdea;

import java.util.Date;
import java.util.List;

/**
 * @author Harry Bravo.
 */
public class Idea {

	private Integer codigo;
	private String titulo;
	private String descripcion;
	private String palabrasClave;
	private String archivo;
	private Usuario estudiante;
	private EstadoIdea estadoIdea;
	private Date fechaCreacion;
	private Date fechaPublicacion;
	private Usuario asesor;
	private List<UsuarioPermitido> listaUsuariosPermitidos;
	private List<Reunion> listaReuniones;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer i) {
		this.codigo = i;
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

	public String getPalabrasClave() {
		return palabrasClave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public Usuario getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Usuario estudiante) {
		this.estudiante = estudiante;
	}

	public EstadoIdea getEstadoIdea() {
		return estadoIdea;
	}

	public void setEstadoIdea(EstadoIdea estadoIdea) {
		this.estadoIdea = estadoIdea;
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

	public Usuario getAsesor() {
		return asesor;
	}

	public void setAsesor(Usuario asesor) {
		this.asesor = asesor;
	}

	public List<UsuarioPermitido> getListaUsuariosPermitidos() {
		return listaUsuariosPermitidos;
	}

	public void setListaUsuariosPermitidos(
			List<UsuarioPermitido> listaUsuariosPermitidos) {
		this.listaUsuariosPermitidos = listaUsuariosPermitidos;
	}

	public List<Reunion> getListaReuniones() {
		return listaReuniones;
	}

	public void setListaReuniones(List<Reunion> listaReuniones) {
		this.listaReuniones = listaReuniones;
	}

	public boolean isPublicada() {
		return estadoIdea.equals(EstadoIdea.PUBLICADA);
	}

	public boolean isAprobada() {
		return estadoIdea.equals(EstadoIdea.APROBADA);
	}
}