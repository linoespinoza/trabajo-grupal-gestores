package gestores.modelo;

import java.util.ArrayList;

/**
 *
 * @author Lino Espinoza
 */
public class Usuario {
    
    private int coUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String sexo;
    private String cotipodocumento;
    private String numeroDocumento;
    private String email;
    private String numeroCelular;
    private String contrasena;
    private String cotipousuario;
    private String cocentroformacion;
    
    // Un usuario puede tener una o muchas ideas
    private ArrayList<Idea> ideas;
  
    // Un usuario puede pertenecer a un centro de formacion
    private CentroFormacion centroFormacion;

    // Getters / Setters
    public int getCoUsuario() {
        return coUsuario;
    }

    public void setCoUsuario(int coUsuario) {
        this.coUsuario = coUsuario;
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

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(ArrayList<Idea> ideas) {
        this.ideas = ideas;
    }

    public CentroFormacion getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(CentroFormacion centroFormacion) {
        this.centroFormacion = centroFormacion;
    }

	public String getCotipodocumento() {
		return cotipodocumento;
	}

	public void setCotipodocumento(String cotipodocumento) {
		this.cotipodocumento = cotipodocumento;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCotipousuario() {
		return cotipousuario;
	}

	public void setCotipousuario(String cotipousuario) {
		this.cotipousuario = cotipousuario;
	}

	public String getCocentroformacion() {
		return cocentroformacion;
	}

	public void setCocentroformacion(String cocentroformacion) {
		this.cocentroformacion = cocentroformacion;
	}
    
}
