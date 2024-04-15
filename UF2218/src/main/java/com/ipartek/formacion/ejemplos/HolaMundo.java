package com.ipartek.formacion.ejemplos;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/hola")
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HolaMundo() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hola");
	}

}
