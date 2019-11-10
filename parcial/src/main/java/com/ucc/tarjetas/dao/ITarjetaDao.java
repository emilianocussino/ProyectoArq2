package com.ucc.tarjetas.dao;

import com.ucc.tarjetas.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITarjetaDao extends JpaRepository<Tarjeta, Long> {
    Tarjeta findTarjetaByid(Long id);
    Tarjeta findTarjetaByNumero(Long numero);
}
