package com.ucc.tarjetas.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class ObjetoGenerico {
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO) //Automatically generated value
    public Long id;


}