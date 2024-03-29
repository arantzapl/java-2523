package com.ipartek.formacion.uf2214.entidades;

import java.util.Objects;

import jakarta.persistence.*;


@Entity
@Table(name = "denuncias")
public class Denuncia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "quien_id", nullable = false, foreignKey = @ForeignKey(name = "FK_denuncia_quien"))
	private Usuario quien;
	
	@ManyToOne
	@JoinColumn(name = "a_quien_id", nullable = false, foreignKey = @ForeignKey(name = "FK_denuncia_a_quien"))
	private Usuario aQuien;
	
	@Column(name = "razon", length = 255, nullable = false)
	private String razon;
	
	@ManyToOne
	@JoinColumn(name = "post_id", nullable = true, foreignKey = @ForeignKey(name = "FK_denuncia_post"))
//	Dejamos como opcional el POST porque se puede denunciar directamente a un usuario
	private Post post;
	
	public Denuncia () {
		
	}

	public Denuncia(Long id, Usuario quien, Usuario aQuien, String razon, Post post) {
		super();
		this.id = id;
		this.quien = quien;
		this.aQuien = aQuien;
		this.razon = razon;
		this.post = post;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getQuien() {
		return quien;
	}

	public void setQuien(Usuario quien) {
		this.quien = quien;
	}

	public Usuario getaQuien() {
		return aQuien;
	}

	public void setaQuien(Usuario aQuien) {
		this.aQuien = aQuien;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Denuncia [id=" + id + ", quien=" + quien + ", aQuien=" + aQuien + ", razon=" + razon + ", post=" + post
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aQuien, id, post, quien, razon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Denuncia other = (Denuncia) obj;
		return Objects.equals(aQuien, other.aQuien) && Objects.equals(id, other.id) && Objects.equals(post, other.post)
				&& Objects.equals(quien, other.quien) && Objects.equals(razon, other.razon);
	}
	
	
}
