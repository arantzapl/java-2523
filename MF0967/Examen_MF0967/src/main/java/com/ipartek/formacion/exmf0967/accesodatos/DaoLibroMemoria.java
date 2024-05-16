package com.ipartek.formacion.exmf0967.accesodatos;

import java.util.*;

import com.ipartek.formacion.exmf0967.entidades.*;

public class DaoLibroMemoria implements DaoLibro {

	private TreeMap<Long, Libro> libros = new TreeMap<>();

	// PATRÓN SINGLETON
	private DaoLibroMemoria() {
	}

	private static final DaoLibroMemoria INSTANCIA = new DaoLibroMemoria();

	public static DaoLibroMemoria getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros.values();
	}

	@Override
	public Libro obtenerPorId(Long id) {
		return libros.get(id);
	}

	@Override
	public Libro insertar(Libro libro) {
		Long id = libros.size() > 0L ? libros.lastKey() + 1L: 1L;
		libro.setId(id);
		libros.put(id, libro);
		
		return libro;
	}

	@Override
	public Libro modificar(Libro libro) {
		libros.put(libro.getId(), libro);
		return libro;
	}

	@Override
	public void borrar(Long id) {
	    try {
	        if (!libros.containsKey(id)) {
	            throw new NoSuchElementException("No existe un libro con el ID proporcionado: " + id);
	        }
	        libros.remove(id);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
