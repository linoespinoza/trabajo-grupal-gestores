package gestores.negocio;

import gestores.dao.EvaluadorDAO;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;

import java.util.Date;
import java.util.List;

public class GestionEvaluador {

	public List<Idea> listaIdeasporCF(Usuario evaluador, Idea ideab, Date fecha_ini, Date fecha_fin) 
			throws DAOExcepcion {
		EvaluadorDAO dao = new EvaluadorDAO();
		return dao.listaIdeasporCF(evaluador, ideab, fecha_ini, fecha_fin);
	}

}
