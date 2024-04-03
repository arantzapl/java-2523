package examen_mf0966.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import examen_mf0966.dtos.CursoDTO;



public class CursoAccesoDatos {
	private static final Logger LOG = Logger.getLogger(CursoAccesoDatos.class.getName());
	
	private static final String SQL_SELECT = "SELECT c.nombre, c.identificador, c.nHoras, p.nombre, p.apellidos FROM curso c JOIN profesor p ON c.profesor_codigo = p.codigo";
	private static final String SQL_SELECT_ID = "SELECT c.nombre, c.identificador, c.nHoras, p.nombre, p.apellidos, r.descripcion FROM resena r JOIN curso c ON r.curso_codigo = c.codigo JOIN profesor p ON c.profesor_codigo = p.codigo WHERE c.codigo = ?";
	
	
		public static ArrayList<CursoDTO> obtenerTodos() {
			var cursos = new ArrayList<CursoDTO>();
			
			try (
				Connection con = AccesoDatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
				
				CursoDTO curso;
				
				while(rs.next()) {
	
					curso = new CursoDTO(rs.getString("nombre"), rs.getString("identificador"), rs.getInt("nHoras"), rs.getString("p.nombre"), rs.getString("p.apellidos"));
					
					LOG.info("LISTADO DE TODOS LOS CURSOS: " + curso);
					
					cursos.add(curso);
				}
				
				return cursos;
				
			} catch (SQLException e) {
				LOG.log(Level.SEVERE, "NO SE HAN PODIDO OBTENER LOS CURSOS", e);
				throw new RuntimeException("Error en la select", e);
			}
		}
		
		
		public static CursoDTO obtenerPorCodigo(long codigo) {
			try (
				Connection con = AccesoDatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
					
				pst.setLong(1, codigo);
					
				ResultSet rs = pst.executeQuery();
					
				CursoDTO curso = null;
				
				if (rs.next()) {
					curso = filaACurso(rs);
				}
				
				return curso;
				
			} catch (SQLException e) {
				LOG.log(Level.SEVERE, "NO SE HAN PODIDO OBTENER LOS CURSOS CON SUS RESEÑAS", e);
				throw new RuntimeException("Error en la select", e);
			}

		}


		private static CursoDTO filaACurso(ResultSet rs) throws SQLException {
			CursoDTO curso;
			
			curso = new CursoDTO(rs.getString("nombre"), rs.getString("identificador"), rs.getInt("nHoras"), rs.getString("p.nombre"), rs.getString("p.apellidos"));
			
			return curso;
		}
	
}
