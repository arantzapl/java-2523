package examen_mf0966.rest;

import java.util.ArrayList;

import examen_mf0966.accesodatos.CursoAccesoDatos;
import examen_mf0966.dtos.CursoDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;


@Path("/curso")
public class CursoRest {

	@GET
	public ArrayList<CursoDTO> obtenerTodos() {
		return CursoAccesoDatos.obtenerTodos();
	}
	
	@GET
	@Path("/{id}")
	public CursoDTO obtenerPorCodigo(@PathParam("id") long codigo) {
		return CursoAccesoDatos.obtenerPorCodigo(codigo);
	}
}
