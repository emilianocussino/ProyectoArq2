package com.ucc.tarjetas.dto;

import javax.validation.Valid;

public class TarjetaDeUsuarioDto {

    @Valid
    private Long idUsuario;
    @Valid
    private Long idTarjeta;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }
}
