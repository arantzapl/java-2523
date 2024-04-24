package com.ipartek.formacion.ejemplospring.repositorios;

import java.math.*;

import org.springframework.data.repository.*;

import com.ipartek.formacion.ejemplospring.entidades.*;

public interface ProductoRepository extends CrudRepository<Producto, Long>{
	Iterable<Producto> findByNombreContains(String nombre);
	
	Iterable<Producto> findByPrecioBetween(BigDecimal minimo, BigDecimal maximo);
}
