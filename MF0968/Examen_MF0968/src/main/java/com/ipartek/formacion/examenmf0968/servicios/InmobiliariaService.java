package com.ipartek.formacion.examenmf0968.servicios;

import java.math.*;
import java.util.*;

import org.springframework.stereotype.*;

import com.ipartek.formacion.examenmf0968.entidades.*;

@Service
public interface InmobiliariaService {
	
	default Iterable<Inmueble> listarInmuebles() {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Iterable<Inmueble> listarInmueblesPorNombreYPrecio() {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Inmueble verInmueblePorId(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Inmueble crearInmueble(Inmueble inmueble) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Iterable<Inmueble> verInmueblesPorRangoPrecio(BigDecimal precioMin, BigDecimal precioMax) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default List<Inmueble> buscarPorNombreODireccion(String fragmento) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Inmueble verInmueble(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void anadirTipo(String tipo) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	default List<Inmueble> verInmueblesPorTipo(String tipo) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	
	
	

}
