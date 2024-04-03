package examen_mf0966.dtos;


public record CursoDTO (String nombre, String identificador, Integer numHoras, ProfesorDTO profe) {
	public CursoDTO(String nombre, String identificador, Integer numHoras, String nombreProfe, String apellidosProfe) {
		this(nombre, identificador, numHoras, new ProfesorDTO(nombreProfe, apellidosProfe));
	}
}
