package com.ipartek.formacion.uf2214;

import com.ipartek.formacion.uf2214.accesodatos.PostAccesoDatos;
import com.ipartek.formacion.uf2214.accesodatos.RolAccesoDatos;
import com.ipartek.formacion.uf2214.accesodatos.UsuarioAccesoDatos;
import com.ipartek.formacion.uf2214.entidades.Post;
import com.ipartek.formacion.uf2214.entidades.Rol;
import com.ipartek.formacion.uf2214.entidades.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class App {
	public static final Rol ADMIN = new Rol(null, "ADMIN");
	public static final Rol USER = new Rol(null, "USER");
	
	public static void main(String[] args) {
		Rol rolAdmin = RolAccesoDatos.obtenerPorId(1);
		Rol rolUser = RolAccesoDatos.obtenerPorId(2);
		
		
		
		//	registro
		UsuarioAccesoDatos.insertar(new Usuario("arantzaperez", "contra", rolAdmin));
		UsuarioAccesoDatos.insertar(new Usuario("pruebapru", "proba", rolUser));

		//	loguearse
		Usuario admin = UsuarioAccesoDatos.buscarPorNickName("noexiste");
		
		System.out.println(admin);
		
		Usuario user = UsuarioAccesoDatos.buscarPorNickName("pruebapru");
		
		System.out.println(user);
		
		//	crearPost
		Post post = new Post(user, "Nuevo post en la aplicación");
		
		PostAccesoDatos.insertar(post);
		
		//	todosLosPost
		var posts = PostAccesoDatos.obtenerTodos();
		
		for(Post p: posts) {
			System.out.println(p);
		}
	}
	
	
    public static void mainPruebaSinAccesoDatos() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ipartek.formacion.uf2214.entidades");
    	
    	EntityManager em = emf.createEntityManager();
    	
    	EntityTransaction t = em.getTransaction();
    	
    	t.begin();
    	
    	em.persist(ADMIN);
    	em.persist(USER);
    	
    	t.commit();
    }
}
