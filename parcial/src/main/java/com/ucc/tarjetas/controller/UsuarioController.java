package com.ucc.tarjetas.controller;

import com.ucc.tarjetas.dto.UsuarioDto;
import com.ucc.tarjetas.model.Usuario;
import com.ucc.tarjetas.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {


    @Autowired
    IUsuarioService usuarioService;

    @PostMapping(path = "/agregarNuevoUsuario")
    public @ResponseBody
    Usuario agregarNuevoUsuario(@RequestBody UsuarioDto usuarioDto) {
        return usuarioService.crearUsuario(usuarioDto);
    }

    @GetMapping(path = "/verUsuario/{id}")
    public @ResponseBody
    Usuario verUsuario(@PathVariable("id") Long id) {
        return usuarioService.verUsuario(id);
    }
}
