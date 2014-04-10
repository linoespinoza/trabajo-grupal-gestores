package gestores.dao;


import gestores.enums.EstadoIdea;
import gestores.exception.DAOExcepcion;
import gestores.modelo.Idea;
import gestores.modelo.Usuario;
import gestores.util.ConexionBD;
import gestores.util.FechaUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author Marco Chumpitaz.
 */
public class EvaluadorDAO extends BaseDAO {
	
	public Collection<Idea> listar(Usuario evaluador) throws DAOExcepcion {
		Collection<Idea> ideax = new ArrayList<Idea>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			con = ConexionBD.obtenerConexion();
			String query = "select No_Titulo,Tx_Descripcion,Tx_Palabras_Clave,Tx_Archivo,Co_Estado,Fe_Creacion,"
					+ "us1.No_Usuario, us1.No_Ape_Paterno, us1.No_Ape_Materno,"
					+ "us2.No_Usuario, us2.No_Ape_Paterno, us2.No_Ape_Materno "
					+ "from idea id1 inner join usuario us1 "
					+ "on (id1.Co_Estudiante = us1.Co_Usuario) "
					+ "left join usuario us2 "
					+ "on (id1.Co_Asesor = us2.Co_Usuario)"
					+ "where us1.Co_Centro_Formacion = ? ";
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, evaluador.getCentroFormacion().getCodigo());
			rs = stmt.executeQuery();
			
			while (rs.next()) {
		
				Idea vo = new Idea();
				vo.setTitulo(rs.getString(1));
				vo.setDescripcion(rs.getString(2));
				vo.setPalabrasClave(rs.getString(3));
				vo.setArchivo(rs.getString(4));
				vo.setEstadoIdea(EstadoIdea.getEstadoIdea(rs.getString(5)));
				vo.setFechaCreacion(rs.getDate(6));
	
				Usuario estudiante = new Usuario();
				estudiante.setNombre(rs.getString(7));
				estudiante.setApellidoPaterno(rs.getString(8));
				estudiante.setApellidoMaterno(rs.getString(9));
				vo.setEstudiante(estudiante);
	
				Usuario asesor = new Usuario();
				asesor.setNombre(rs.getString(10));
				asesor.setApellidoPaterno(rs.getString(11));
				asesor.setApellidoMaterno(rs.getString(12));
				vo.setAsesor(asesor);
	
				ideax.add(vo);
			}
		}
		catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return ideax;
	}

	public List<Idea> listaIdeasporCF(Usuario evaluador, Idea ideab,
			Date fecha_ini, Date fecha_fin) throws DAOExcepcion {
		
		List<Idea> lista = new ArrayList<Idea>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
	
			String condicion = "";
			
			if (ideab.getTitulo() != null) {
				condicion = "and  id1.No_Titulo like ? ";
			} else if (ideab.getDescripcion() != null) {
				condicion = "and id1.Tx_Descripcion like ? ";
			} else if (ideab.getPalabrasClave() != null) {
				condicion = "and id1.Tx_Palabras_Clave like ? ";
			}
			if (ideab.getEstadoIdea() != null) {
				condicion += "and id1.Co_Estado = ? ";
			}
			if (fecha_ini != null && fecha_fin != null) {
				condicion += "AND DATE(id1.Fe_Creacion) BETWEEN ? AND ? ";
			}
		
			String query = "select No_Titulo,Tx_Descripcion,Tx_Palabras_Clave,Tx_Archivo,Co_Estado,Fe_Creacion,"
					+ "us1.No_Usuario, us1.No_Ape_Paterno, us1.No_Ape_Materno,"
					+ "us2.No_Usuario, us2.No_Ape_Paterno, us2.No_Ape_Materno "
					+ "from idea id1 inner join usuario us1 "
					+ "on (id1.Co_Estudiante = us1.Co_Usuario) "
					+ "left join usuario us2 "
					+ "on (id1.Co_Asesor = us2.Co_Usuario)"
					+ "where us1.Co_Centro_Formacion = ? " + condicion;
	
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			int indiceParametro = 2;
				
			stmt.setString(1, evaluador.getCentroFormacion().getCodigo().toString());
					
			if (ideab.getTitulo() != null) {
				stmt.setString(indiceParametro, "%" + ideab.getTitulo() + "%");
				indiceParametro += 1;
			} else if (ideab.getDescripcion() != null) {
				stmt.setString(indiceParametro, "%" + ideab.getDescripcion() + "%");
				indiceParametro += 1;
			} else if (ideab.getPalabrasClave() != null) {
				stmt.setString(indiceParametro, "%" + ideab.getPalabrasClave() + "%");
				indiceParametro += 1;
			}
			
			if (ideab.getEstadoIdea() != null) {
				stmt.setString(indiceParametro, ideab.getEstadoIdea().getCodigo());
				indiceParametro += 1;
			}
			
			if (fecha_ini != null && fecha_fin != null) {
				stmt.setTimestamp(indiceParametro, FechaUtil.convertirTimestamp(fecha_ini));
				stmt.setTimestamp(indiceParametro + 1, FechaUtil.convertirTimestamp(fecha_fin));
			}
			
				
			rs = stmt.executeQuery();
			while (rs.next()) {
				Idea vo = new Idea();
				vo.setTitulo(rs.getString(1));
				vo.setDescripcion(rs.getString(2));
				vo.setPalabrasClave(rs.getString(3));
				vo.setArchivo(rs.getString(4));
				vo.setEstadoIdea(EstadoIdea.getEstadoIdea(rs.getString(5)));
				vo.setFechaCreacion(rs.getDate(6));
	
				Usuario estudiante = new Usuario();
				estudiante.setNombre(rs.getString(7));
				estudiante.setApellidoPaterno(rs.getString(8));
				estudiante.setApellidoMaterno(rs.getString(9));
				vo.setEstudiante(estudiante);
				
				
				Usuario asesor = new Usuario();
				asesor.setNombre(rs.getString(10));
				asesor.setApellidoPaterno(rs.getString(11));
				asesor.setApellidoMaterno(rs.getString(12));
				vo.setAsesor(asesor);
	
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return lista;
	
	}

}
