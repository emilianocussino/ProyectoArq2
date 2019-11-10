package com.ucc.tarjetas.service;

import com.ucc.tarjetas.dto.TarjetaDeUsuarioDto;
import com.ucc.tarjetas.dto.TarjetaDto;
import com.ucc.tarjetas.dto.OperacionDto;
import com.ucc.tarjetas.model.Tarjeta;

public interface ITarjetaService {
    public Tarjeta crearTarjeta(TarjetaDto tarjetaDto);
    public Tarjeta asociarTarjetaConUsuario(TarjetaDeUsuarioDto tarjetaDeUsuarioDto);
    public Tarjeta obtenerTarjeta(Long idTarjeta);
}
