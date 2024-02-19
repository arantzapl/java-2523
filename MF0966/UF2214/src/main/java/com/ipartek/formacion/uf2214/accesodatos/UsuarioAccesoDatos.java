package com.ipartek.formacion.uf2214.accesodatos;

import static com.ipartek.formacion.uf2214.accesodatos.AccesoDatosJpa.enTransaccion;

import java.util.List;

import com.ipartek.formacion.uf2214.entidades.Post;
import com.ipartek.formacion.uf2214.entidades.Usuario;

public class UsuarioAccesoDatos {
	public static void insertar(Usuario usuario) {
		enTransaccion(em -> {
			em.persist(usuario);
			return null;
		});
	}
	
	public static Usuario buscarPorNickName(String nickName) {
		return enTransaccion(em -> {
			var usuarios = em.createQuery("select u from Usuario u where u.nickName = :nickName", Usuario.class).setParameter("nickName", nickName).getResultList();
			
			if(usuarios.size() == 1) {
				return usuarios.get(0);
			} else {
				return null;
			}
		});
	}
	
	public static List<Usuario> obtenerSeguidores(long id) {
		return enTransaccion(em -> em.createQuery("select u from Usuario u where :id in u.seguidorDe.id", Usuario.class).setParameter("id", id).getResultList());
	}
	
	public static void agregarSeguidor(long id, long seguirAId) {
		enTransaccion(em -> {
			Usuario usuario = em.find(Usuario.class, id);
			Usuario seguirA = em.find(Usuario.class, seguirAId);
			
			usuario.getSeguidorDe().remove(seguirA);
			
			em.merge(usuario);
			
			return null;
		});
	}
	
	public static void agregarBloqueado(long id, long bloqueadosId) {
		enTransaccion(em -> {
			Usuario usuario = em.find(Usuario.class, id);
			Usuario bloqueados = em.find(Usuario.class, bloqueadosId);
			
			usuario.getBloqueados().remove(bloqueados);
			
			em.merge(usuario);
			
			return null;
		});
	}
	
//	public static void agregarDenunciado(long id, Denuncia denuncia) {
//		enTransaccion(em -> {
//			Usuario usuario = em.find(Usuario.class, id);
//			Usuario denunciado = em.find(Usuario.class, denunciadoId);
//			
//			usuario.getDenunciasRealizadas().remove(denunciado);
//			
//			em.merge(usuario);
//			
//			return null;
//		});
//	}
}
