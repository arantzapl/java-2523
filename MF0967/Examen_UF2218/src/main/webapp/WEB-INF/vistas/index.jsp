<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<main class="container">
	<div class="row row-cols-1 row-cols-md-3">
    <c:forEach items="${libros}" var="l">
        <div class="col mb-4">
            <div class="card h-100">
                <div class="card-body">
                    <h5 class="card-title">${l.nombre}</h5>
                    <p class="card-text">Precio: <fmt:formatNumber type="currency" value="${l.precio}"/></p>
                    <p class="card-text">Descuento: ${l.descuento}%</p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

</main>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
