package com.ucc.tarjetas.model;

import javax.persistence.*;

@Entity
@Table(name = "operacion", schema = "tarjetas")
public class Operacion extends ObjetoGenerico {

    public Operacion() {
    }

    public Operacion(Tarjeta tarjeta, Long monto, String codigo, String estado, String autorizacion, TipoOperacion tipoOperacion) {
        this.tarjeta = tarjeta;
        this.monto = monto;
        this.codigo = codigo;
        this.estado = estado;
        this.autorizacion = autorizacion;
        this.tipoOperacion = tipoOperacion;
    }

    @ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
    @JoinColumn(name = "tarjeta_id")
    private Tarjeta tarjeta;

    @Column(name = "monto", length = 200, nullable = false)
    private Long monto;

    @Column(name = "codigo", length = 200, nullable = false)
    private String codigo;

    @Column(name = "estado", length = 200, nullable = false)
    private String estado;

    @Column(name = "autorizacion", length = 200, nullable = false)
    private String autorizacion;

    @Column(name = "tipoOperacion", length = 200, nullable = false)
    private TipoOperacion tipoOperacion;

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
}
