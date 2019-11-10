package com.ucc.tarjetas.service;

import com.ucc.tarjetas.dto.UsuarioDto;
import com.ucc.tarjetas.model.Usuario;

public interface IUsuarioService {
    public Usuario crearUsuario(UsuarioDto usuarioDto);
    public Usuario verUsuario(Long id);
}
