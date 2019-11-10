package com.ucc.tarjetas.service;

import com.ucc.tarjetas.dao.ITarjetaDao;
import com.ucc.tarjetas.dao.IUsuarioDao;
import com.ucc.tarjetas.dto.UsuarioDto;
import com.ucc.tarjetas.exception.EntidadNoEncontradaException;
import com.ucc.tarjetas.model.Tarjeta;
import com.ucc.tarjetas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {


    @Autowired
    private IUsuarioDao usuarioDao;
    @Autowired
    private ITarjetaDao tarjetaDao;

    @Override
    public Usuario crearUsuario(UsuarioDto usuarioDto) {

        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        usuario.setDNI(usuarioDto.getDni());
        usuario.setTarjetas(usuarioDto.getTarjetas());
        asignarUsuarioATarjeta(usuarioDto, usuario);
        return usuarioDao.save(usuario);
    }

    @Override
    public Usuario verUsuario(Long id) {
        Usuario usuario = usuarioDao.findUsuarioById(id);
        if (usuario != null) {
            return usuario;
        } else {
            throw new EntidadNoEncontradaException(HttpStatus.NOT_FOUND, "Usuario no existente.");
        }
    }

    private void asignarUsuarioATarjeta(UsuarioDto usuarioDto, Usuario usuario) {
        if (usuarioDto.getTarjetas() != null) {
            for (int i = 0; i < usuarioDto.getTarjetas().size(); i++) {
                Tarjeta tarjeta = usuarioDto.getTarjetas().get(i);
                tarjeta.setUsuario(usuario);
                tarjetaDao.save(tarjeta);
            }
        }
    }


}




