<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<main class="container">
	<div class="row row-cols-1 row-cols-md-3">
    <c:forEach items="${libros}" var="l">
        <div class="col mb-4">
            <div class="card h-100">
                <div class="card-body">
                	<img src="${l.urlFoto}" class="card-img-top" alt="...">
                    <h6 class="card-title">${l.nombre}</h6>
                    <p class="card-text fw-bold fs-6">${l.autor}</p>
                    <div class="d-flex justify-content-between align-items-start">
                    	<p class="nuevo-precio text-danger fw-bold"><fmt:formatNumber type="currency" value="${l.descuento != 0 ? (l.precio - (l.descuento/100)) : l.precio}"></fmt:formatNumber></p>
						<p class="antiguo-precio">
							<span class="precio-tachado"><fmt:formatNumber type="currency" value="${l.precio}"></fmt:formatNumber></span>
						</p>
                    	<p class="card-text fw-bold desc">- ${l.descuento}%</p>
					</div>
                    
                </div>
            </div>
        </div>
    </c:forEach>
</div>

</main>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
