package com.ipartek.formacion.exmf0967.presentacion.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ipartek.formacion.exmf0967.configuraciones.*;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("libros", Globales.DAO_LIBRO.obtenerTodos());
		
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}
}
