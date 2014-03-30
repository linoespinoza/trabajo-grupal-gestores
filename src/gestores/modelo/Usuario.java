package gestores.modelo;

import gestores.enums.TipoDocumento;
import gestores.enums.TipoUsuario;

/**
 * @author Harry Bravo.
 */
public class Usuario {

	private Integer codigo;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String sexo;
	private TipoDocumento tipoDocumento;
	private String numeroDocumento;
	private String email;
	private String numeroCelular;
	private String contrasenia;
	private TipoUsuario tipoUsuario;
	private CentroFormacion centroFormacion;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public CentroFormacion getCentroFormacion() {
		return centroFormacion;
	}

	public void setCentroFormacion(CentroFormacion centroFormacion) {
		this.centroFormacion = centroFormacion;
	}

	public boolean isAdministrador() {
		return tipoUsuario.equals(TipoUsuario.ADMINISTRADOR);
	}

	public boolean isEvaluador() {
		return tipoUsuario.equals(TipoUsuario.EVALUADOR);
	}

	public boolean isDocente() {
		return tipoUsuario.equals(TipoUsuario.DOCENTE);
	}

	public boolean isEstudiante() {
		return tipoUsuario.equals(TipoUsuario.ESTUDIANTE);
	}
}