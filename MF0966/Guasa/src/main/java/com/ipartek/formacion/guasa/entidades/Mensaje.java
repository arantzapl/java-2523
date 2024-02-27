package com.ipartek.formacion.guasa.entidades;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mensajes")
public class Mensaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha = LocalDateTime.now();
	
	@Column(name = "contenido", length = 2000, nullable = false)
	private String contenido; // MarkDown
	
	@Column(name = "reacciones", length = 255)
	private String reacciones; // :smile:,2,:sad:,5
	
	@ManyToOne
	@JoinColumn(name = "chat_id", nullable = false, foreignKey = @ForeignKey(name = "FK_mensaje_chat"))
	private Chat chat;
	
	@ManyToOne
	@JoinColumn(name = "estado_mensaje_id", nullable = false, foreignKey = @ForeignKey(name = "FK_mensaje_estado_mensaje"))
	private EstadoMensaje estadoMensaje;
	
	@ManyToOne
	@JoinColumn(name = "respuesta_de_id", nullable = false, foreignKey = @ForeignKey(name = "FK_mensaje_respuesta_de"))
	private Mensaje respuestaDe;
	
	@ManyToOne
	@JoinColumn(name = "contacto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_mensaje_contacto"))
	private Contacto contacto;
	
	public Mensaje() {
		
	}

	public Mensaje(Long id, LocalDateTime fecha, String contenido, String reacciones, Chat chat,
			EstadoMensaje estadoMensaje, Mensaje respuestaDe, Contacto contacto) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.contenido = contenido;
		this.reacciones = reacciones;
		this.chat = chat;
		this.estadoMensaje = estadoMensaje;
		this.respuestaDe = respuestaDe;
		this.contacto = contacto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getReacciones() {
		return reacciones;
	}

	public void setReacciones(String reacciones) {
		this.reacciones = reacciones;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public EstadoMensaje getEstadoMensaje() {
		return estadoMensaje;
	}

	public void setEstadoMensaje(EstadoMensaje estadoMensaje) {
		this.estadoMensaje = estadoMensaje;
	}

	public Mensaje getRespuestaDe() {
		return respuestaDe;
	}

	public void setRespuestaDe(Mensaje respuestaDe) {
		this.respuestaDe = respuestaDe;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chat, contacto, contenido, estadoMensaje, fecha, id, reacciones, respuestaDe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return Objects.equals(chat, other.chat) && Objects.equals(contacto, other.contacto)
				&& Objects.equals(contenido, other.contenido) && Objects.equals(estadoMensaje, other.estadoMensaje)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id)
				&& Objects.equals(reacciones, other.reacciones) && Objects.equals(respuestaDe, other.respuestaDe);
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", fecha=" + fecha + ", contenido=" + contenido + ", reacciones=" + reacciones
				+ ", chat=" + chat + ", estadoMensaje=" + estadoMensaje + ", respuestaDe=" + respuestaDe + ", contacto="
				+ contacto + "]";
	}
	
	
	
}
