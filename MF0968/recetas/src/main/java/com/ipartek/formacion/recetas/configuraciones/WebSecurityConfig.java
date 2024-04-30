package com.ipartek.formacion.recetas.configuraciones;
import javax.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	// https://spring.io/guides/gs/securing-web
	// https://www.baeldung.com/spring-security-jdbc-authentication

	// AUTENTICACIÓN
	@Autowired
	private DataSource dataSource;
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	// AUTORIZACIÓN
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(requests) -> requests
					.requestMatchers("/ingrediente").hasRole("ADMIN")
					.anyRequest().authenticated()
				)
				.formLogin((form) -> form
//						.loginPage("/login")
						.permitAll()
				)
//				.logout((logout) -> logout.permitAll())
				;
		return http.build();
	}
}