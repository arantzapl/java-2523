 package com.ipartek.formacion.exmf0967.presentacion.filtros;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebFilter("/admin/*")
public class LoginCorrectFilter extends HttpFilter implements Filter {
    
	private static final long serialVersionUID = -6256502688044510953L;

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("usuario") != null) {
			chain.doFilter(request, response);
			return;
		}
		
		request.setAttribute("logOk", "Se ha logueado correctamente");
		request.getRequestDispatcher("/login").forward(request, response);
	}

}
