package com.caribe.sur.Pruebas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormularioController {

    @GetMapping("/formulario")
    public String mostrarFormulario() {
        return "formulario"; // Busca formulario.html en templates
    }

    @PostMapping("/procesar")
    public String procesarFormulario(@RequestParam String nombre, Model model) {
        model.addAttribute("saludo", "Hola, " + nombre + "!");
        return "resultado"; // Muestra resultado.html
    }
}