package gestores.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FechaUtil {

	private FechaUtil() {
	}

	public static Date establecerFecha(int dia, int mes, int anio) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, dia);
		calendar.set(Calendar.MONTH, mes - 1);
		calendar.set(Calendar.YEAR, anio);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date establecerFechaHora(int dia, int mes, int anio,
			int hora, int minuto, int segundo) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, dia);
		calendar.set(Calendar.MONTH, mes - 1);
		calendar.set(Calendar.YEAR, anio);
		calendar.set(Calendar.HOUR_OF_DAY, hora);
		calendar.set(Calendar.MINUTE, minuto);
		calendar.set(Calendar.SECOND, segundo);
		return calendar.getTime();
	}

	public static String obtenerNombreMes(Date fecha) {
		DateFormat dateFormat = new SimpleDateFormat("MMMMM", new Locale("es"));
		return dateFormat.format(fecha);
	}

	public static int obtenerAnio(Date fecha) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		return Integer.parseInt(dateFormat.format(fecha));
	}

	public static Timestamp convertirSqlDate(Date fecha) {
		return new Timestamp(fecha.getTime());
	}
}