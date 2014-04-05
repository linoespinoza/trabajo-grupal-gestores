package gestores.modelo;

import gestores.enums.TipoCentroFormacion;

/**
 * @author Harry Bravo.
 */
public class CentroFormacion {

	private String codigo;
	private String nombre;
	private TipoCentroFormacion tipoCentroFormacion;
	private String url;
	private String logo;
	private PlanTarifario planTarifario;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoCentroFormacion getTipoCentroFormacion() {
		return tipoCentroFormacion;
	}

	public void setTipoCentroFormacion(TipoCentroFormacion tipoCentroFormacion) {
		this.tipoCentroFormacion = tipoCentroFormacion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public PlanTarifario getPlanTarifario() {
		return planTarifario;
	}

	public void setPlanTarifario(PlanTarifario planTarifario) {
		this.planTarifario = planTarifario;
	}
}