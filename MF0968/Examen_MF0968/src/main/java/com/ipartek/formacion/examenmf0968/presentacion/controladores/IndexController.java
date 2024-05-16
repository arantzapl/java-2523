package com.ipartek.formacion.examenmf0968.presentacion.controladores;

import java.math.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import com.ipartek.formacion.examenmf0968.entidades.*;
import com.ipartek.formacion.examenmf0968.servicios.*;

import jakarta.validation.*;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private InmobiliariaService servicio;

    @GetMapping({"/", "/inmuebles"})
    public String listarInmuebles(Model modelo) {
    	 modelo.addAttribute("inmuebles", servicio.listarInmuebles());
    	 return "inmuebles";
    }

    @GetMapping("/inmueble/{id}")
    public String verDetalleInmueble(@PathVariable Long id, Model modelo) {
    	modelo.addAttribute("inmuebles", servicio.listarInmuebles());
    	modelo.addAttribute("inmueble", servicio.verInmueblePorId(id));
   	 	return "inmueble";
    }
    
    @GetMapping("/inmuebles/buscarPorNombreODireccion")
    public String verInmueblePorNombreODireccion(String fragmento, Model modelo) {
    	modelo.addAttribute("inmuebles", servicio.buscarPorNombreODireccion(fragmento));
		return "resultado-inmueble";
    }
    
    @GetMapping("/inmuebles/rangoPrecio")
    public String buscarInmueblesPorPrecio(BigDecimal precioMin, BigDecimal precioMax, Model modelo) {
    	modelo.addAttribute("inmuebles", servicio.verInmueblesPorRangoPrecio(precioMin, precioMax));
        return "resultado-precios";
    }
    
    @GetMapping("/inmuebles/todos")
    public String verInmueblesPorTipos(Model modelo) {
    	modelo.addAttribute("inmuebles", servicio.listarInmuebles());
		return "resultado-tipos";
    }
    
    @GetMapping("/inmuebles/alquiler")
    public String verInmueblePorAlquiler(Model modelo) {
    	modelo.addAttribute("inmuebles", servicio.verInmueblesPorTipo("alquiler"));
		return "resultado-alquiler";
    }
    
    @GetMapping("/inmuebles/venta")
    public String verInmueblePorVenta(Model modelo) {
    	modelo.addAttribute("inmuebles", servicio.verInmueblesPorTipo("compra"));
		return "resultado-venta";
    }
    
    @GetMapping("crear")
	public String formularioInmueble(Inmueble inmueble) {
		return "crear";
	}
    
    @PostMapping("crear")
	public String crearInmueble(@Valid Inmueble inmueble, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "crear";
		}

		servicio.crearInmueble(inmueble);

		return "redirect:/inmuebles";
	}
    
    @GetMapping("resumen")
    public String resumenInmuebles(Inmueble inmueble, Model model) {
    	model.addAttribute("inmuebles", servicio.listarInmueblesPorNombreYPrecio());
		return "resumen";
    	
    }
}
