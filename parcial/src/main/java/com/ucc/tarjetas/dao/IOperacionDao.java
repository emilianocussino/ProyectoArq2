package com.ucc.tarjetas.dao;

import com.ucc.tarjetas.model.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOperacionDao extends JpaRepository<Operacion, Long> {
    @Query(value = "SELECT * FROM tarjetas.operacion WHERE tarjeta_id = tarjeta_id", nativeQuery = true)
    List<Operacion> encontrarOperacionesPorTarjetaId(Long tarjeta_id);
}
