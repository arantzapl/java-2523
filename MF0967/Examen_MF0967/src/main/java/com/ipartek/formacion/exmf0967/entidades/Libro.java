package com.ipartek.formacion.exmf0967.entidades;

import java.math.*;
import java.util.*;

import org.hibernate.validator.constraints.*;

import jakarta.validation.constraints.*;

public class Libro {
	@Min(0)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 150)
	private String nombre;
	
	@NotNull
	@Min(0)
	private BigDecimal precio;
	
	@Min(0)
	@Max(100)
	private Integer descuento;
	
	@NotNull
	private String autor;
	
	@NotNull
	@URL
	private String urlFoto;

	public Libro() {

	}
	
	public Libro(String nombre, BigDecimal precio) {
		this(null, nombre, precio, null, null, null);
	}
	
	public Libro(String nombre, BigDecimal precio, Integer descuento) {
		this(null, nombre, precio, descuento, null, null);
	}
	
	public Libro (String nombre, BigDecimal precio, String autor) {
		this(null, nombre, precio, null, autor, null);
	}
	
	public Libro (String nombre, BigDecimal precio, String autor, String urlFoto) {
		this(null, nombre, precio, null, autor, urlFoto);
	}
	
	public Libro(String nombre, BigDecimal precio, Integer descuento, String autor) {
		this(null, nombre, precio, descuento, autor, null);
	}
	
	public Libro(String nombre, BigDecimal precio, Integer descuento, String autor, String urlFoto) {
		this(null, nombre, precio, descuento, autor, urlFoto);
	}
	
	public Libro(Long id, String nombre, BigDecimal precio, Integer descuento, String autor, String urlFoto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.autor = autor;
		this.urlFoto = urlFoto;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, descuento, id, nombre, precio, urlFoto);
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
		return Objects.equals(autor, other.autor) && Objects.equals(descuento, other.descuento)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio) && Objects.equals(urlFoto, other.urlFoto);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + ", autor="
				+ autor + ", urlFoto=" + urlFoto + "]";
	}
	
}