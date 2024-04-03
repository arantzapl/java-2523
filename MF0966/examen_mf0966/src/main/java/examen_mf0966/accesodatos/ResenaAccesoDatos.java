package examen_mf0966.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import examen_mf0966.dtos.ResenaDTO;

public class ResenaAccesoDatos {
	
	private static final String SQL_SELECT = "SELECT * FROM resena";
	private static final String SQL_SELECT_ID = "SELECT * FROM resena WHERE id = ?";
	private static final String SQL_INSERT_1 = "SELECT a.nombre, c.nombre, ? FROM alumno a JOIN resena r ON a.codigo = r.alumno_codigo JOIN resena c ON c.codigo = r.resena_codigo";
	private static final String SQL_INSERT = "INSERT INTO resena (id, descripcion, alumno_codigo, curso_codigo)" + SQL_INSERT_1;
	private static final String SQL_UPDATE = "UPDATE resena SET id = ?";
	private static final String SQL_DELETE = "DELETE FROM resena WHERE id =?";
	
	public static ArrayList<ResenaDTO> obtenerTodos() {
		var resenas = new ArrayList<ResenaDTO>();
		
		try (
			Connection con = AccesoDatos.obtenerConexion();
			PreparedStatement pst = con.prepareStatement(SQL_SELECT);
			ResultSet rs = pst.executeQuery()) {
			
			ResenaDTO resena;
			
			while(rs.next()) {

				resena = new ResenaDTO(rs.getLong("id"), rs.getString("descripcion"), rs.getLong("alumno_codigo"), rs.getLong("curso_codigo"));
				
				resenas.add(resena);
			}
			
			return resenas;
			
		} catch (SQLException e) {
			throw new RuntimeException("Error en la select", e);
		}
	}
	
	public static ResenaDTO obtenerPorId(long id) {
		try (
			Connection con = AccesoDatos.obtenerConexion();
			PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
				
			pst.setLong(1, id);
				
			ResultSet rs = pst.executeQuery();
				
			ResenaDTO resena = null;
			
			if (rs.next()) {
				resena = filaAResena(rs);
			}
			
			return resena;
			
		} catch (SQLException e) {
			throw new RuntimeException("Error en la select", e);
		}

	}
	
	private static ResenaDTO filaAResena(ResultSet rs) throws SQLException {
		ResenaDTO resena;
		
		resena = new ResenaDTO(rs.getLong("id"), rs.getString("descripcion"), rs.getLong("alumno_codigo"), rs.getLong("curso_codigo"));
		
		return resena;
	}
	
	public static ResenaDTO insertar(ResenaDTO resena) {
		try (Connection con = AccesoDatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {
				
				pst.setLong(1, resena.id());
				pst.setString(2, resena.descripcion());
				pst.setLong(3, resena.alumnoCodigo());
				pst.setLong(4, resena.cursoCodigo());
				
				pst.executeUpdate();
				
				return resena;
				
			} catch (SQLException e) {
				throw new RuntimeException("Error en la insert", e);
			}
	}

	public static ResenaDTO modificar(long id, ResenaDTO resena) {
		try (Connection con = AccesoDatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
				
				pst.setString(1, resena.descripcion());

				pst.setLong(2, id);
				
				pst.executeUpdate();
				
				return resena;
			} catch (SQLException e) {
				throw new RuntimeException("Error en la update", e);
			}
	}

	public static void borrar(long id) {
		try (Connection con = AccesoDatos.obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {
				
				pst.setLong(1, id);
				
				pst.executeUpdate();
				
			} catch (SQLException e) {
				throw new RuntimeException("Error en la delete", e);
			}
	}
		
}
