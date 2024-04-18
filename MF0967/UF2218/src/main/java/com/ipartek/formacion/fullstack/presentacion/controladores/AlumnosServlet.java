
package com.ipartek.formacion.fullstack.presentacion.controladores;

import java.io.IOException;

import com.ipartek.formacion.fullstack.configuraciones.Globales;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/alumnos")
public class AlumnosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var alumnos = Globales.daoAlumno.obtenerTodos();
		
		request.setAttribute("alumnos", alumnos);
		
		request.getRequestDispatcher("/WEB-INF/vistas/alumnos.jsp").forward(request, response);
	}

}
