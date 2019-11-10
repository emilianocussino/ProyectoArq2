package com.ucc.tarjetas.controller;

import com.ucc.tarjetas.dto.OperacionDto;
import com.ucc.tarjetas.dto.OperacionesPorTarjetaDto;
import com.ucc.tarjetas.model.Operacion;
import com.ucc.tarjetas.service.IOperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/operacion")
public class OperacionController {

    @Autowired
    IOperacionService operacionService;

    @PostMapping(path = "/autorizar")
    public @ResponseBody Operacion autorizar(@RequestBody OperacionDto operacionDto) {
        return operacionService.autorizar(operacionDto);
    }

    @GetMapping(path = "/listadoDeOperaciones")
    public @ResponseBody List<Operacion> listarOperaciones(@RequestBody OperacionesPorTarjetaDto operacionesPorTarjetaDto){
        return operacionService.operacionesPorTarjeta(operacionesPorTarjetaDto.getTarjeta().getId());
    }

}
