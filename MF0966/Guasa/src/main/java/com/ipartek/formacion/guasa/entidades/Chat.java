package com.ipartek.formacion.guasa.entidades;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "chats")
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "titulo", length = 100, nullable = false)
	private String titulo;
	
	@Column(name = "archivado", nullable = false)
	private Boolean archivado = false;
	
	@Column(name = "fijado", nullable = false)
	private Boolean fijado = false;
	
	@ManyToMany
	@JoinTable(name = "chat_administradores", joinColumns = @JoinColumn(name = "chat_id"), inverseJoinColumns = @JoinColumn(name = "admin_id"), foreignKey = @ForeignKey(name = "FK_chat_admins_chat"), inverseForeignKey = @ForeignKey(name = "FK_chat_admins_admin"))
	private List<Contacto> admins;
	
	@ManyToMany
	@JoinTable(name = "chat_contactos", joinColumns = @JoinColumn(name = "chat_id"), inverseJoinColumns = @JoinColumn(name = "contacto_id"), foreignKey = @ForeignKey(name = "FK_chat_contactos_chat"), inverseForeignKey = @ForeignKey(name = "FK_chat_contactos_contacto"))
	private List<Contacto> contactos;
	
	@OneToMany(mappedBy = "chat")
	private List<Mensaje> mensaje;

	
	public Chat() {
		
	}

	public Chat(Long id, String titulo, Boolean archivado, Boolean fijado, List<Contacto> admins,
			List<Contacto> contactos, List<Mensaje> mensaje) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.archivado = archivado;
		this.fijado = fijado;
		this.admins = admins;
		this.contactos = contactos;
		this.mensaje = mensaje;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Boolean getArchivado() {
		return archivado;
	}


	public void setArchivado(Boolean archivado) {
		this.archivado = archivado;
	}


	public Boolean getFijado() {
		return fijado;
	}


	public void setFijado(Boolean fijado) {
		this.fijado = fijado;
	}


	public List<Contacto> getAdmins() {
		return admins;
	}


	public void setAdmins(List<Contacto> admins) {
		this.admins = admins;
	}


	public List<Contacto> getContactos() {
		return contactos;
	}


	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}


	public List<Mensaje> getMensaje() {
		return mensaje;
	}


	public void setMensaje(List<Mensaje> mensaje) {
		this.mensaje = mensaje;
	}


	@Override
	public int hashCode() {
		return Objects.hash(admins, archivado, contactos, fijado, id, mensaje, titulo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chat other = (Chat) obj;
		return Objects.equals(admins, other.admins) && Objects.equals(archivado, other.archivado)
				&& Objects.equals(contactos, other.contactos) && Objects.equals(fijado, other.fijado)
				&& Objects.equals(id, other.id) && Objects.equals(mensaje, other.mensaje)
				&& Objects.equals(titulo, other.titulo);
	}


	@Override
	public String toString() {
		return "Chat [id=" + id + ", titulo=" + titulo + ", archivado=" + archivado + ", fijado=" + fijado + ", admins="
				+ admins + ", contactos=" + contactos + ", mensaje=" + mensaje + "]";
	}
	
	
}
