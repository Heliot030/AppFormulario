package com.demo.controller;

import com.demo.entity.Usuario;
import com.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/registro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "index";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "redirect:/registro?exito";
    }
}
