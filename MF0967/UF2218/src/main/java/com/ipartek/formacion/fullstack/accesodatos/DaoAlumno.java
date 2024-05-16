package com.ipartek.formacion.fullstack.accesodatos;

import com.ipartek.formacion.fullstack.dtos.AlumnoDto;
import com.ipartek.formacion.fullstack.dtos.AlumnoLoginDto;
import com.ipartek.formacion.fullstack.dtos.LibroDto;

public interface DaoAlumno extends Dao<AlumnoDto> {
	void apuntarseACurso(Long idAlumno, Long idCurso);
	Iterable<LibroDto> cursos(Long idAlumno);
	
	AlumnoLoginDto buscarPorEmail(String email);
}