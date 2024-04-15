package com.ipartek.formacion.fullstack.accesodatos;

import com.ipartek.formacion.fullstack.dtos.*;

public interface DaoCurso extends Dao<CursoDto> {

	Iterable<AlumnoDto> alumnos(Long id);

}