package gestores.constante;

/**
 * @author Jerem�as Yalta.
 */
public class UsuarioConstante {

	private UsuarioConstante() {
	}

	public static final String SER_INI_USUARIO = "InicioUsuarioServlet";
	public static final String PAG_MANT_USUARIO = "jsp/mantenimiento/usuario/mantenimientoUsuario.jsp";
	public static final String PAG_NUEVO_USUARIO = "jsp/mantenimiento/usuario/nuevoUsuario.jsp";
	public static final String PAG_EDITA_USUARIO = "jsp/mantenimiento/usuario/editaUsuario.jsp";

	public static final String MSJ_VALID_AUTENTICACION = "Usuario y/o contraseña incorrectos";
	public static final String MSJ_VALID_DOCUMENTO = "Ya existe un usuario con el mismo documento";
	public static final String MSJ_VALID_EMAIL = "Ya existe un usuario con el mismo e-mail";
	public static final String MSJ_VALID_NRO_CELULAR = "El número de celular debe ser de 9 digitos";
	public static final String MSJ_VALID_NO_EXIST_USUARIO = "No existe el usuario";
}