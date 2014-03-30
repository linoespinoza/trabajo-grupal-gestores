package gestores.exception;

/**
 * @author Harry Bravo.
 */
public class LoginExcepcion extends Exception {

	private static final long serialVersionUID = -7641905494356127686L;

	public LoginExcepcion() {
		super();
	}

	public LoginExcepcion(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginExcepcion(String message) {
		super(message);
	}

	public LoginExcepcion(Throwable cause) {
		super(cause);
	}
}