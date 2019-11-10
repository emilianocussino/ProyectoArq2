package com.ucc.tarjetas.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario", schema = "tarjetas")
public class Usuario extends ObjetoGenerico {

    @Column(name = "nombre", length = 300, nullable = false)
    private String nombre;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, Long DNI, List<Tarjeta> tarjetas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.tarjetas = tarjetas;
    }

    @Column(name = "apellido", length = 200, nullable = false)
    private String apellido;

    @Column(name = "DNI", length = 200, nullable = false)
    private Long DNI;

    //@OneToMany(mappedBy = "usuario", cascade = {CascadeType.ALL})
    @OneToMany(fetch = FetchType.LAZY, mappedBy="usuario", cascade = {CascadeType.ALL})
    private List<Tarjeta> tarjetas;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long DNI) {
        this.DNI = DNI;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }


}
