package com.ipartek.formacion.examen.entidades;

import java.math.*;
import java.util.*;

import jakarta.validation.constraints.*;

public class Libro {
	@Min(0)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 150)
	private String nombre;
	
	@NotNull
	@Min(0)
	private BigDecimal precio;
	
	@NotNull
	@Min(0)
	@Max(100)
	private Integer descuento;

	public Libro() {
		
	}
	
	public Libro(String nombre, BigDecimal precio) {
		this(null, nombre, precio, null);
	}
	
	public Libro(String nombre, BigDecimal precio, Integer descuento) {
		this(null, nombre, precio, descuento);
	}
	
	public Libro(Long id, String nombre, BigDecimal precio, Integer descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descuento, id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(descuento, other.descuento) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + "]";
	}
}

