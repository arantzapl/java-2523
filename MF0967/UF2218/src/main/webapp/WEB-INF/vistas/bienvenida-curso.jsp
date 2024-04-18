<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<main>
	<h1>Hola ${alumno.nombre()}, te has dado de alta en el curso ${curso.nombre()}</h1>
</main>
	
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>