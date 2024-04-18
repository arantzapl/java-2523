
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de alumnos</title>
</head>
<body>
	<a href="cursos">Listado de cursos</a>
	<h1>Listado de alumnos</h1>
	<ul>
		<c:forEach items="${alumnos}" var="alumno">
			<li>
				${alumno.nombre()} ${alumno.apellidos()}
			</li>
		</c:forEach>
	</ul>
</body>
</html>
