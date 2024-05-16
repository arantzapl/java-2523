package com.ipartek.formacion.examenmf0968.entidades;

import java.math.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "inmuebles")
public class Inmueble {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Size(min = 3, max = 100)
	private String nombre;
	
	@NotNull
	@NotBlank
	private String direccion;
	
	@NotNull
	@Min(0)
	private BigDecimal precio;
	
	@NotNull
	@Min(1)
	private Integer nHabitaciones;
	
	@NotNull
	private String tipo;
	
	private String servicio;
}
