package com.ipartek.formacion.uf2214.accesodatos;

import static com.ipartek.formacion.uf2214.accesodatos.AccesoDatosJpa.enTransaccion;

import java.util.List;

import com.ipartek.formacion.uf2214.entidades.Usuario;

import jakarta.persistence.Query;

public class UsuarioAccesoDatos {
	public static void insertar(Usuario usuario) {
		enTransaccion(em -> {
			em.persist(usuario);
			return null;
		});
	}

	public static Usuario buscarPorNickName(String nickName) {
		return enTransaccion(em -> {
			var usuarios = em
					.createQuery("select u from Usuario u join fetch u.rol where u.nickName = :nickName", Usuario.class)
					.setParameter("nickName", nickName).getResultList();

			if (usuarios.size() == 1) {
				return usuarios.get(0);
			} else {
				return null;
			}
		});
	}

	public static List<Usuario> obtenerSeguidores(long id) {
		return enTransaccion(em -> em.createQuery(
				"select seguidores from Usuario seguidores join seguidores.seguidorDe seguido where seguido.id = :id",
				Usuario.class).setParameter("id", id).getResultList());
	}

	public static void agregarSeguidor(long id, long seguirAId) {
		enTransaccion(em -> {
			Query query = em.createNativeQuery(
					"INSERT INTO usuarios_seguidores (usuario_id, seguidor_de_id) VALUES (:id, :seguidorDeId)");

			query.setParameter("id", id);
			query.setParameter("seguidorDeId", seguirAId);
			query.executeUpdate();

			return null;
		});
	}

	public static void quitarSeguidor(long id, long seguirAId) {
		enTransaccion(em -> {
			Query query = em.createNativeQuery(
					"DELETE FROM usuarios_seguidores WHERE usuario_id = :id AND seguidor_de_id = :seguidorDeId");

			query.setParameter("id", id);
			query.setParameter("seguidorDeId", seguirAId);
			query.executeUpdate();

			return null;
		});
	}

	public static void agregarBloqueado(long id, long bloqueadoId) {
		enTransaccion(em -> {
			Query query = em.createNativeQuery(
					"INSERT INTO usuarios_bloqueados (usuario_id, bloqueado_id) VALUES (:id, :bloqueadoId)");
			query.setParameter("id", id);
			query.setParameter("bloqueadoId", bloqueadoId);
			query.executeUpdate();

			return null;
		});
	}
}