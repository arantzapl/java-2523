package com.ipartek.formacion.examenmf0968.servicios;

import java.math.*;
import java.util.*;

import org.springframework.stereotype.*;

import com.ipartek.formacion.examenmf0968.entidades.*;
import com.ipartek.formacion.examenmf0968.repositorios.*;

@Service
public class InmobiliariaServiceImpl implements InmobiliariaService {
	private InmuebleRepository inmuebleRepository;
	
	public InmobiliariaServiceImpl(InmuebleRepository inmuebleRepository) {
				
		inmuebleRepository.save(Inmueble.builder().nombre("Atico junto a la ria").tipo("Alquiler").nHabitaciones(3).direccion("Deusto").precio(new BigDecimal(2500)).build());
		inmuebleRepository.save(Inmueble.builder().nombre("Estudio").tipo("Compra").nHabitaciones(2).direccion("Bilbao").precio(new BigDecimal(2000000)).build());
		
		this.inmuebleRepository = inmuebleRepository;
	}

	@Override
	public Iterable<Inmueble> listarInmuebles() {
		return inmuebleRepository.findAll();
	}
	
	@Override
	public Iterable<Inmueble> listarInmueblesPorNombreYPrecio() {
		return inmuebleRepository.buscarPorNombreAscYPrecioAsc();
	}

	@Override
	public Inmueble verInmueblePorId(Long id) {
		return inmuebleRepository.findById(id).orElse(null);
	}

	@Override
	public Inmueble crearInmueble(Inmueble inmueble) {
		return inmuebleRepository.save(inmueble);
	}

	@Override
	public Iterable<Inmueble> verInmueblesPorRangoPrecio(BigDecimal precioMin, BigDecimal precioMax) {
		return inmuebleRepository.findByPrecioBetween(precioMin, precioMax);
	}

	@Override
	public List<Inmueble> buscarPorNombreODireccion(String fragmento) {
		return inmuebleRepository.buscarPorNombreODireccion(fragmento);
	}

	@Override
	public List<Inmueble> verInmueblesPorTipo(String tipo) {
		return inmuebleRepository.findByTipo(tipo);
	}

	
		
	
}
