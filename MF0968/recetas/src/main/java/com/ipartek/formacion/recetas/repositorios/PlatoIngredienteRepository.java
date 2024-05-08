package com.ipartek.formacion.recetas.repositorios;

import org.springframework.data.repository.*;

import com.ipartek.formacion.recetas.entidades.*;

public interface PlatoIngredienteRepository extends CrudRepository<PlatoIngrediente, Long> {

	Iterable<PlatoIngrediente> findByPlatoId(Long id);
	void deleteByPlatoId(Long id);
}
