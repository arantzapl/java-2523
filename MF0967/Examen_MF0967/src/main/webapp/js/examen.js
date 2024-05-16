$(function() {
	new DataTable('table', {
		language: {
			url: 'json/datatables_es-ES.json',
		},
	});
});


// Función para ocultar automáticamente el mensaje después de 3 segundos
function ocultarMensaje() {
	var alerta = document.getElementById("alerta");
	if (alerta) {
		setTimeout(function(){
	    	alerta.classList.remove("show");
	    	alerta.remove();
	    	document.getElementById("container").classList.add("oculto");
		}, 1500); // El mensaje se desvanecerá después de 1 segundo (1000 milisegundos)
	}
}
	
// Llamar a la función para ocultar el mensaje cuando se carga la página
window.onload = function() {
	var alerta = document.getElementById("alerta");
	if (alerta) {
		// Agregar la clase "show" para que la animación de desvanecimiento se inicie
	    alerta.classList.add("show");
	    // Llamar a la función para ocultar el mensaje después de 1 segundos
	    ocultarMensaje();
	}
}