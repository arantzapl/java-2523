package com.ipartek.formacion.fullstack.accesodatos;

import com.ipartek.formacion.fullstack.dtos.AlumnoDto;
import com.ipartek.formacion.fullstack.entidades.*;

public class DaoAlumnoJpa extends AccesoDatosJpa implements DaoAlumno {

	@Override
	public Iterable<AlumnoDto> obtenerTodos() {
		return enTransaccion(em -> em.createQuery("select a.id, a.nombre, a.apellidos, a.fechaNacimiento from Alumno a", AlumnoDto.class).getResultList());
	}

	@Override
	public AlumnoDto obtenerPorId(Long id) {
		return enTransaccion(em -> em.createQuery("select a.id, a.nombre, a.apellidos, a.fechaNacimiento from Alumno a where a.id = :id", AlumnoDto.class).setParameter("id", id).getSingleResult());
	}

	@Override
	public AlumnoDto insertar(AlumnoDto alumno) {
		return enTransaccion(em -> {
			Alumno a = new Alumno(null, alumno.nombre(), alumno.apellidos(), alumno.fechaNacimiento(), null, null);
			em.persist(a);
			return new AlumnoDto(a.getId(), a.getNombre(), a.getApellidos(), a.getFechaNacimiento());
		});
	}

	@Override
	public AlumnoDto modificar(AlumnoDto alumno) {
		return enTransaccion(em -> {
			if(alumno.id() == null) {
				throw new AccesoDatosException("El alumno debe tener un id para poder modificar sus datos");
			}
			em.merge(alumno);
			return alumno;
		});
	}

	@Override
	public void borrar(Long id) {
		enTransaccionVoid(em -> em.remove(em.find(Alumno.class, id)));
	}

	@Override
	public void apuntarseACurso(Long idAlumno, Long idCurso) {
		enTransaccionVoid(em -> {
//			Curso c = new Curso();
//			c.setId(idCurso);
//			
//			Alumno a = new Alumno();
//			a.setId(idAlumno);
//			
//			a.getCursos().add(c);
//			
//			em.persist(a);
			
			em.createNativeQuery("INSERT INTO cursos_alumnos (cursos_id, alumnos_id) VALUES (:idCurso, :idAlumno)").setParameter("idCurso", idCurso).setParameter("idAlumno", idAlumno).executeUpdate();
		});
	}

}