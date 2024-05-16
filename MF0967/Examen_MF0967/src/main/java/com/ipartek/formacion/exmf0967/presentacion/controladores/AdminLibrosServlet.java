package com.ipartek.formacion.exmf0967.presentacion.controladores;

import java.io.*;

import com.ipartek.formacion.exmf0967.configuraciones.*;
import com.ipartek.formacion.exmf0967.presentacion.filtros.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/admin/libros")
public class AdminLibrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String logOk = MensajesUsuario.mostrarInformacion("Se ha logueado correctamente");
		
		request.setAttribute("logOk", logOk);
		request.setAttribute("libros", Globales.DAO_LIBRO.obtenerTodos());
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin.jsp").forward(request, response);
	}
}
