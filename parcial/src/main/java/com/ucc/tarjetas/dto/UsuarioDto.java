package com.ucc.tarjetas.dto;

import com.ucc.tarjetas.model.Tarjeta;

import javax.validation.Valid;
import java.util.List;


public class UsuarioDto {

    private Long id;

    @Valid
    private String nombre;

    @Valid
    private String apellido;

    @Valid
    private Long dni;

    private List<Tarjeta> tarjetas;

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, @Valid String nombre, @Valid String apellido, @Valid Long dni, @Valid List<Tarjeta> tarjetas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.tarjetas = tarjetas;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }
}
