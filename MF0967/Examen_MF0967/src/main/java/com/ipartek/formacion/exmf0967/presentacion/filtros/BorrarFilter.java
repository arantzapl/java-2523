package com.ipartek.formacion.exmf0967.presentacion.filtros;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class BorrarFilter extends HttpFilter implements Filter {
    
	private static final long serialVersionUID = 3461874377393511008L;

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("usuario") != null) {
			chain.doFilter(request, response);
			return;
		}
		
		request.setAttribute("delWarn", "Va a borrar este elemento, ¿está seguro que desea proceder?");
		request.getRequestDispatcher("/admin/borrar").forward(request, response);
	}

}
