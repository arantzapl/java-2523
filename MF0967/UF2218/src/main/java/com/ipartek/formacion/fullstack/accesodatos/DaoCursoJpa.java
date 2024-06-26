package com.ipartek.formacion.fullstack.accesodatos;

import com.ipartek.formacion.fullstack.dtos.AlumnoDto;
import com.ipartek.formacion.fullstack.dtos.LibroDto;
import com.ipartek.formacion.fullstack.entidades.Curso;

public class DaoCursoJpa extends AccesoDatosJpa implements DaoCurso {

	@Override
	public Iterable<LibroDto> obtenerTodos() {
		return enTransaccion(
				em -> em.createQuery("select c.id, c.nombre from Curso c", LibroDto.class).getResultList());
	}

	@Override
	public LibroDto obtenerPorId(Long id) {
		return enTransaccion(em -> em.createQuery("select c.id, c.nombre from Curso c where c.id=:id", LibroDto.class)
				.setParameter("id", id).getSingleResult());
	}

	@Override
	public LibroDto insertar(LibroDto curso) {
		return enTransaccion(em -> {
			Curso c = new Curso(null, curso.nombre(), null);
			em.persist(c);
			return new LibroDto(c.getId(), c.getNombre());
		});
	}

	@Override
	public LibroDto modificar(LibroDto curso) {
		return enTransaccion(em -> {
			if (curso.id() == null) {
				throw new AccesoDatosException("Para modificar un curso debes proporcionar el id");
			}

			Curso c = new Curso(curso.id(), curso.nombre(), null);
			em.merge(c);
			return new LibroDto(c.getId(), c.getNombre());
		});
	}

	@Override
	public void borrar(Long id) {
		enTransaccionVoid(em -> em.remove(em.find(Curso.class, id)));
	}

	@Override
	public Iterable<AlumnoDto> alumnos(Long id) {
		return enTransaccion(em -> em.createQuery(
				"select a.id, a.nombre, a.apellidos, a.fechaNacimiento from Alumno a join a.cursos c where c.id = :id",
				AlumnoDto.class).setParameter("id", id).getResultList());
	}

//	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ipartek.formacion.fullstack.entidades");
//	@Override
//	public Iterable<Curso> obtenerTodos() {
//		EntityTransaction t = null;
//		
//		try (EntityManager em = emf.createEntityManager()) {
//			t = em.getTransaction();
//			t.begin();
//			
//			List<Curso> cursos = em.createQuery("select c from Curso c", Curso.class).getResultList();
//			
//			t.commit();
//			
//			return cursos;
//		} catch(Exception e) {
//			if(t != null) {
//				t.rollback();
//			}
//			
//			throw new AccesoDatos("No se ha podido consultar los cursos");
//		}
//	}
}