package com.ipartek.formacion.examen.configuraciones;

import java.math.BigDecimal;

import com.ipartek.formacion.examen.accesodatos.DaoLibro;
import com.ipartek.formacion.examen.accesodatos.DaoLibroMemoria;
import com.ipartek.formacion.examen.entidades.Libro;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

public class Globales {
	public static final DaoLibro DAO_LIBRO= DaoLibroMemoria.getInstancia();
	public static final ValidatorFactory VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory();
	
	static {
		for(int i = 1; i <= 10; i++) {
			DAO_LIBRO.insertar(new Libro("Libro" + i, new BigDecimal(i * 10)));
		}
	}
}
