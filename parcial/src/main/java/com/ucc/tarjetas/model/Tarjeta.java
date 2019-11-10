package com.ucc.tarjetas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity

@Table(name = "tarjeta", schema = "tarjetas")
public class Tarjeta extends ObjetoGenerico {

    public Tarjeta(){}
    public Tarjeta(Long numero, Long saldo, Usuario usuario, List<Operacion> operaciones) {
        this.numero = numero;
        this.saldo = saldo;
        this.usuario = usuario;
        this.operaciones = operaciones;
    }

    @Column(name = "numero", length = 300, nullable = false)
    private Long numero;

    @Column(name = "saldo", length = 200, nullable = false)
    private Long saldo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class, cascade=CascadeType.ALL)
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy="tarjeta", cascade=CascadeType.ALL)
    private List<Operacion> operaciones;

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operacion> operaciones) {
        this.operaciones = operaciones;
    }

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

    public Long getId() {
        return id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
