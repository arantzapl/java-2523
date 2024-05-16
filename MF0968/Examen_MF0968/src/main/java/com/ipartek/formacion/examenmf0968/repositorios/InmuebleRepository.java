package com.ipartek.formacion.examenmf0968.repositorios;

import java.math.*;
import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

import com.ipartek.formacion.examenmf0968.entidades.*;


public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
	
	@Query("SELECT i FROM Inmueble i ORDER BY i.nombre ASC, i.precio ASC")
	List<Inmueble> buscarPorNombreAscYPrecioAsc();

	List<Inmueble> findByPrecioBetween(BigDecimal precioMin, BigDecimal precioMax);

	@Query("SELECT i FROM Inmueble i WHERE LOWER(i.nombre) LIKE %:fragmento% OR LOWER(i.direccion) LIKE %:fragmento%")
    List<Inmueble> buscarPorNombreODireccion(String fragmento);

	@Query("SELECT i FROM Inmueble i WHERE i.tipo = :tipo")
    List<Inmueble> findByTipo(@Param("tipo") String tipo);


}
