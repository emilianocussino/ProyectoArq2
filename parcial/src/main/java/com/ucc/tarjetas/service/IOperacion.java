package com.ucc.tarjetas.service;

import com.ucc.tarjetas.dto.OperacionDto;
import com.ucc.tarjetas.model.Operacion;

import java.util.List;

public interface IOperacion {
    Operacion autorizar(OperacionDto operacionDto);
    List<Operacion> operacionesPorTarjeta (Long idTarjeta);


}
