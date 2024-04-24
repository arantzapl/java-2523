package com.ipartek.formacion.ejemplospring;

import java.math.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

import com.ipartek.formacion.ejemplospring.entidades.*;
import com.ipartek.formacion.ejemplospring.repositorios.*;

@SpringBootApplication
public class EjemplospringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EjemplospringApplication.class, args);
	}
	
	@Autowired
	private ProductoRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(Producto.builder().nombre("Prueba").precio(new BigDecimal(1234)).build());
		
		for(var p: repo.findAll()) {
			System.out.println(p);
		}
		
		for(var p: repo.findByNombreContains("ru")) {
			System.out.println(p);
		}
		
		for(var p: repo.findByPrecioBetween(new BigDecimal(1), new BigDecimal(2000))) {
			System.out.println(p);
		}
	}

}
