-- SQL listar últimos 5 cursos

SELECT c.nombre, c.identificador, c.nHoras, p.nombre, p.apellidos FROM curso c JOIN profesor p ON c.profesor_codigo = p.codigo ORDER BY c.codigo desc LIMIT 5;


-- SQL listar últimos 5 usuarios creados

SELECT codigo, nombre, apellidos, fNacimiento, direccion, poblacion, codigopostal, telefono, email, dni, nHermanos, activo FROM alumno ORDER BY codigo desc LIMIT 5;


-- SQL detalle curso + numero de reseñas

SELECT c.nombre, c.identificador, c.nHoras, p.nombre, p.apellidos, COUNT(r.id) AS num_resenas FROM profesor p JOIN curso c ON c.profesor_codigo = p.codigo JOIN resena r ON c.codigo = r.curso_codigo GROUP BY c.codigo, c.nombre;


-- SQL listado usuarios ordenado por número de reseñas

SELECT a.*, COUNT(r.id) as num_resenas FROM alumno a JOIN resena r ON a.codigo = r.alumno_codigo GROUP BY a.codigo, a.nombre ORDER BY COUNT(r.id) DESC;


-- SQL Resumen de número de cursos de todos los años

SELECT cursoYEAR(fFin) AS anios, COUNT(*) AS num_cursos FROM curso GROUP BY YEAR(fFin) ORDER BY anios;