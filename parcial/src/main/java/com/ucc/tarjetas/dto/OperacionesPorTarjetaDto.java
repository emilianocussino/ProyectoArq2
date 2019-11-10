package com.ucc.tarjetas.dto;

import com.ucc.tarjetas.model.Tarjeta;

import javax.validation.Valid;

public class OperacionesPorTarjetaDto {

    public OperacionesPorTarjetaDto(){}

    public OperacionesPorTarjetaDto(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Valid
    private Tarjeta tarjeta;

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
