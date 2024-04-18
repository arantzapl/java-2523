package com.ipartek.formacion.fullstack.pruebas;

import jakarta.persistence.*;

public class Pruebas {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("com.ipartek.formacion.fullstack.entidades");
	}

}