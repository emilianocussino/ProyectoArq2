package com.ucc.tarjetas.service;

import com.ucc.tarjetas.dao.ITarjetaDao;
import com.ucc.tarjetas.dao.IUsuarioDao;
import com.ucc.tarjetas.dto.TarjetaDeUsuarioDto;
import com.ucc.tarjetas.dto.TarjetaDto;
import com.ucc.tarjetas.exception.EntidadNoEncontradaException;
import com.ucc.tarjetas.model.Tarjeta;
import com.ucc.tarjetas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaService implements ITarjetaService {

    @Autowired
    ITarjetaDao tarjetaDao;

    @Autowired
    IUsuarioDao usuarioDao;

    @Autowired
    IUsuarioService usuarioService;

    @Override
    public Tarjeta crearTarjeta(TarjetaDto tarjetaDto) {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setNumero(tarjetaDto.getNumero());
        tarjeta.setSaldo(tarjetaDto.getSaldo());
        return tarjetaDao.save(tarjeta);
    }

    @Override
    public Tarjeta asociarTarjetaConUsuario(TarjetaDeUsuarioDto tarjetaDeUsuarioDto) {
        Usuario usuario = usuarioService.verUsuario(tarjetaDeUsuarioDto.getIdUsuario());
        Tarjeta tarjeta = obtenerTarjeta(tarjetaDeUsuarioDto.getIdTarjeta());
        agregarTarjetaALaListaDeTarjetas(usuario, tarjeta);
        tarjeta.setUsuario(usuario);
        return tarjetaDao.save(tarjeta);
    }


    private void agregarTarjetaALaListaDeTarjetas(Usuario usuario, Tarjeta tarjeta) {
        List<Tarjeta> tarjetas = usuario.getTarjetas();
        tarjetas.add(tarjeta);
        usuario.setTarjetas(tarjetas);
        usuarioDao.save(usuario);
    }

    public Tarjeta obtenerTarjeta(Long idTarjeta) {
        Tarjeta tarjeta = tarjetaDao.findTarjetaByid(idTarjeta);
        if (tarjeta != null) {
            return tarjeta;
        } else {
            throw new EntidadNoEncontradaException(HttpStatus.NOT_FOUND, "Tarjeta no existente.");
        }
    }

    public Tarjeta obtenerTarjetaPorNumero(Long numero) {
        Tarjeta tarjeta = tarjetaDao.findTarjetaByNumero(numero);
        if (tarjeta != null) {
            return tarjeta;
        } else {
            throw new EntidadNoEncontradaException(HttpStatus.NOT_FOUND, "Tarjeta no existente.");
        }
    }


}
