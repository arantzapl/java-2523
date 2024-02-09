package com.ipartek.formacion.uf2214.entidades;

import java.util.Set;

public class Usuario {
	private Long id;
	private String nickname;
	private Rol rol;
	private Set<Post> posts;
	private Set<Usuario> seguidorDe;
	private Set<Usuario> bloqueados;
	private Set<Post> postQueLeGusta;
	private Set<Post> postGuardado;
	private Set<Denuncia> denuncias;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nickname, Rol rol, Set<Post> posts, Set<Usuario> seguidorDe, Set<Usuario> bloqueados,
			Set<Post> postQueLeGusta, Set<Post> postGuardado, Set<Denuncia> denuncias) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.rol = rol;
		this.posts = posts;
		this.seguidorDe = seguidorDe;
		this.bloqueados = bloqueados;
		this.postQueLeGusta = postQueLeGusta;
		this.postGuardado = postGuardado;
		this.denuncias = denuncias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Set<Usuario> getSeguidorDe() {
		return seguidorDe;
	}

	public void setSeguidorDe(Set<Usuario> seguidorDe) {
		this.seguidorDe = seguidorDe;
	}

	public Set<Usuario> getBloqueados() {
		return bloqueados;
	}

	public void setBloqueados(Set<Usuario> bloqueados) {
		this.bloqueados = bloqueados;
	}

	public Set<Post> getPostQueLeGusta() {
		return postQueLeGusta;
	}

	public void setPostQueLeGusta(Set<Post> postQueLeGusta) {
		this.postQueLeGusta = postQueLeGusta;
	}

	public Set<Post> getPostGuardado() {
		return postGuardado;
	}

	public void setPostGuardado(Set<Post> postGuardado) {
		this.postGuardado = postGuardado;
	}

	public Set<Denuncia> getDenuncias() {
		return denuncias;
	}

	public void setDenuncias(Set<Denuncia> denuncias) {
		this.denuncias = denuncias;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nickname=" + nickname + ", rol=" + rol + ", posts=" + posts + ", seguidorDe="
				+ seguidorDe + ", bloqueados=" + bloqueados + ", postQueLeGusta=" + postQueLeGusta + ", postGuardado="
				+ postGuardado + ", denuncias=" + denuncias + "]";
	}
	
	
}
