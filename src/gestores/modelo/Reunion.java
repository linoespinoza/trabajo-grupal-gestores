package gestores.modelo;

import gestores.enums.TipoCalificacion;
import gestores.util.FechaUtil;

import java.util.Date;

/**
 * @author Harry Bravo.
 */
public class Reunion {

	private Integer codigo;
	private Idea idea;
	private Date fechaReunion;
	private String observacion;
	private TipoCalificacion tipoCalificacion;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public Date getFechaReunion() {
		return fechaReunion;
	}

	public void setFechaReunion(Date fechaReunion) {
		this.fechaReunion = fechaReunion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public TipoCalificacion getTipoCalificacion() {
		return tipoCalificacion;
	}

	public void setTipoCalificacion(TipoCalificacion tipoCalificacion) {
		this.tipoCalificacion = tipoCalificacion;
	}

	public String getFechaReunionFormateada() {
		String fechaFormateada = null;
		if (fechaReunion != null) {
			fechaFormateada = FechaUtil.formatearFechaHora(fechaReunion);
		}
		return fechaFormateada;
	}
}