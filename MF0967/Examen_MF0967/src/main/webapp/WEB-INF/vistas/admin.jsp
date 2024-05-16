<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<main class="container-fluid">
	<div class="container">
	    <c:if test="${logOk != null}">
	        <div id="alerta" class="alert alert-info alert-dismissible fade" role="alert">
	            ${logOk}
	        </div>
	    </c:if>
	</div>
	
	<div id="tabla" class="table-responsive">
		<table class="table table-hover table-bordered table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Descuento</th>
					<th>Autor</th>
					<th>URL foto</th>
					<th>OPCIONES</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${libros}" var="l">
					<tr>
						<th>${l.id}</th>
						<td>${l.nombre}</td>
						<td><fmt:formatNumber type="currency" value="${l.precio}" /></td>
						<td>${l.descuento}</td>
						<td>${l.autor}</td>
						<td>${l.urlFoto}</td>
						<td><a href="admin/libro?id=${l.id}" class="btn btn-sm btn-primary">Editar</a> <a
							href="admin/borrar?id=${l.id}" class="btn btn-sm btn-danger">Borrar</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><a href="admin/libro" class="btn btn-sm btn-primary">Añadir</a></td>
				</tr>
			</tfoot>
		</table>
	</div>
	
</main>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>