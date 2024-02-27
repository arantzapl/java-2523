package com.ipartek.formacion.guasa.entidades;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "contactos", uniqueConstraints = {
		@UniqueConstraint(name = "UK_contacto_telefono", columnNames = {"telefono"}) })
public class Contacto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "telefono", columnDefinition = "CHAR(9)", length = 9, nullable = false)
	private String telefono;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "apellido", length = 50)
	private String apellido;
	
	@ManyToMany
	@JoinTable(name = "estados_contactos", joinColumns = @JoinColumn(name = "contacto_id"), inverseJoinColumns = @JoinColumn(name = "estado_id"), foreignKey = @ForeignKey(name = "FK_contacto_estado_contacto_contacto"), inverseForeignKey = @ForeignKey(name = "FK_contacto_estado_contacto_estado_contacto"))
	private List<Mensaje> estadoContacto;
	
	@ManyToMany
	@JoinTable(name = "lista_contactos", joinColumns = @JoinColumn(name = "propietario_id"), inverseJoinColumns = @JoinColumn(name = "contacto_id"), foreignKey = @ForeignKey(name = "FK_contacto_contactos_contacto"))
	private List<Contacto> contactos;
	
	@ManyToMany(mappedBy = "contactos")
	private List<Chat> chats;
	
	
	public Contacto() {
		
	}


	public Contacto(Long id, String telefono, String nombre, String apellido, List<Mensaje> estadoContacto,
			List<Contacto> contactos, List<Chat> chats) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estadoContacto = estadoContacto;
		this.contactos = contactos;
		this.chats = chats;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public List<Mensaje> getEstadoContacto() {
		return estadoContacto;
	}


	public void setEstadoContacto(List<Mensaje> estadoContacto) {
		this.estadoContacto = estadoContacto;
	}


	public List<Contacto> getContactos() {
		return contactos;
	}


	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}


	public List<Chat> getChats() {
		return chats;
	}


	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}


	@Override
	public int hashCode() {
		return Objects.hash(apellido, chats, contactos, estadoContacto, id, nombre, telefono);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(chats, other.chats)
				&& Objects.equals(contactos, other.contactos) && Objects.equals(estadoContacto, other.estadoContacto)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono);
	}


	@Override
	public String toString() {
		return "Contacto [id=" + id + ", telefono=" + telefono + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", estadoContacto=" + estadoContacto + ", contactos=" + contactos + ", chats=" + chats + "]";
	}
	
	
}