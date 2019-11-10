package com.ucc.tarjetas.dto;

import com.ucc.tarjetas.model.TipoOperacion;
import com.ucc.tarjetas.model.Usuario;

import javax.validation.Valid;

public class TarjetaDto {

    public TarjetaDto() {
    }

    public TarjetaDto(Long numero, Long saldo, Usuario usuario, TipoOperacion tipoOperacion) {
        this.numero = numero;
        this.saldo = saldo;
        this.usuario = usuario;
        this.tipoOperacion = tipoOperacion;
    }

    @Valid
    private Long numero;

    @Valid
    private Long saldo;

    @Valid
    private Usuario usuario;

    @Valid
    private TipoOperacion tipoOperacion;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
}
