package com.ipartek.formacion.exmf0967.configuraciones;

import java.math.BigDecimal;

import com.ipartek.formacion.exmf0967.accesodatos.*;
import com.ipartek.formacion.exmf0967.entidades.*;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

public class Globales {
	public static final DaoLibro DAO_LIBRO= DaoLibroMemoria.getInstancia();
	public static final ValidatorFactory VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory();
	
	static {
		for(int i = 1; i <= 10; i++) {
			DAO_LIBRO.insertar(new Libro("Libro" + i, new BigDecimal(i * 10), Integer.valueOf(i), "Autor" + i, "https://picsum.photos/300/200?" + i));
		}
	}
}
