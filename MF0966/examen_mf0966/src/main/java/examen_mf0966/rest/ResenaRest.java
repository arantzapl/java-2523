package examen_mf0966.rest;

import java.sql.SQLException;
import java.util.ArrayList;

import examen_mf0966.accesodatos.ResenaAccesoDatos;
import examen_mf0966.dtos.ResenaDTO;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/resena")
public class ResenaRest {
	
	@GET
	public ArrayList<ResenaDTO> obtenerTodos() {
		return ResenaAccesoDatos.obtenerTodos();
	}
	
	@GET
	@Path("/{id}")
	public ResenaDTO obtenerPorId(@PathParam("id") long id) {
		return ResenaAccesoDatos.obtenerPorId(id);
	}

	@POST
	public ResenaDTO insertar(ResenaDTO resena) throws SQLException{
		return ResenaAccesoDatos.insertar(resena);
	}
	
	@PUT
	@Path("/{id}")
	public ResenaDTO modificar(@PathParam("id") long id, ResenaDTO resena) throws SQLException {
		return ResenaAccesoDatos.modificar(id, resena);
	}
	
	@DELETE
	@Path("/{id}")
	public void borrar(@PathParam("id") long id) throws SQLException {
		ResenaAccesoDatos.borrar(id);
	}
}
