package gestores.negocio;

import gestores.constante.CentroFormacionConstante;
import gestores.constante.GeneralConstante;
import gestores.dao.CentroFormacionDAO;
import gestores.exception.DAOExcepcion;
import gestores.exception.NegocioExcepcion;
import gestores.modelo.CentroFormacion;
import gestores.util.ArchivoUtil;
import gestores.util.NumeroUtil;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Harry Bravo.
 */
public class GestionCentroFormacion {

	public List<CentroFormacion> listar(CentroFormacion centroFormacion)
			throws DAOExcepcion {
		CentroFormacionDAO dao = new CentroFormacionDAO();
		return dao.listar(centroFormacion);
	}

	public int insertar(CentroFormacion centroFormacion) throws DAOExcepcion,
			NegocioExcepcion {
		CentroFormacionDAO dao = new CentroFormacionDAO();

		if (!NumeroUtil.esRuc(centroFormacion.getCodigo())) {
			throw new NegocioExcepcion(GeneralConstante.MSJ_VALID_RUC);
		}
		if (!ArchivoUtil.esImagen(centroFormacion.getLogo())) {
			throw new NegocioExcepcion(
					CentroFormacionConstante.MSJ_VALID_IMAGEN);
		}
		if (dao.esRegistradoNombre(centroFormacion.getCodigo(),
				centroFormacion.getNombre())) {
			throw new NegocioExcepcion(
					CentroFormacionConstante.MSJ_VALID_NOMBRE);
		}
		if (dao.esRegistradoUrl(centroFormacion.getCodigo(),
				centroFormacion.getUrl())) {
			throw new NegocioExcepcion(CentroFormacionConstante.MSJ_VALID_URL);
		}
		return dao.insertar(centroFormacion);
	}

	public CentroFormacion obtener(String codigo) throws DAOExcepcion,
			NegocioExcepcion {
		CentroFormacionDAO dao = new CentroFormacionDAO();

		CentroFormacion centroFormacion = dao.obtener(codigo);
		if (centroFormacion == null) {
			throw new NegocioExcepcion(
					CentroFormacionConstante.MSJ_VALID_NO_EXIST_CENTRO_FORMACION);
		}
		return centroFormacion;
	}

	public int eliminar(String codigo) throws DAOExcepcion {
		CentroFormacionDAO dao = new CentroFormacionDAO();
		return dao.eliminar(codigo);
	}

	public int actualizar(CentroFormacion centroFormacion) throws DAOExcepcion,
			NegocioExcepcion {
		CentroFormacionDAO dao = new CentroFormacionDAO();

		if (!NumeroUtil.esRuc(centroFormacion.getCodigo())) {
			throw new NegocioExcepcion(GeneralConstante.MSJ_VALID_RUC);
		}
		if (StringUtils.isNotBlank(centroFormacion.getLogo())
				&& !ArchivoUtil.esImagen(centroFormacion.getLogo())) {
			centroFormacion.setLogo(null);
			throw new NegocioExcepcion(
					CentroFormacionConstante.MSJ_VALID_IMAGEN);
		}
		if (dao.esRegistradoNombre(centroFormacion.getCodigo(),
				centroFormacion.getNombre())) {
			throw new NegocioExcepcion(
					CentroFormacionConstante.MSJ_VALID_NOMBRE);
		}
		if (dao.esRegistradoUrl(centroFormacion.getCodigo(),
				centroFormacion.getUrl())) {
			throw new NegocioExcepcion(CentroFormacionConstante.MSJ_VALID_URL);
		}
		return dao.actualizar(centroFormacion);
	}
}