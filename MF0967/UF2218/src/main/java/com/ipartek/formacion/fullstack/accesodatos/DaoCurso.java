package com.ipartek.formacion.fullstack.accesodatos;

import com.ipartek.formacion.fullstack.dtos.*;

public interface DaoCurso extends Dao<LibroDto> {

	Iterable<AlumnoDto> alumnos(Long id);

}