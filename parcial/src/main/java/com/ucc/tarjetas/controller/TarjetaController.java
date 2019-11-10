package com.ucc.tarjetas.controller;

import com.ucc.tarjetas.dto.TarjetaDeUsuarioDto;
import com.ucc.tarjetas.dto.TarjetaDto;
import com.ucc.tarjetas.dto.OperacionDto;
import com.ucc.tarjetas.model.Tarjeta;
import com.ucc.tarjetas.service.ITarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tarjeta")
public class TarjetaController {

    @Autowired
    ITarjetaService tarjetaService;

    @PostMapping(path = "/agregarNuevaTarjeta")
    public @ResponseBody
    Tarjeta agregarNuevaTarjeta(@RequestBody TarjetaDto tarjetaDto) {
        return tarjetaService.crearTarjeta(tarjetaDto);
    }

    @PostMapping(path = "/asociarTarjetaConUsuario")
    public @ResponseBody
    Tarjeta asociarTarjetaConUsuario(@RequestBody TarjetaDeUsuarioDto tarjetaDeUsuarioDto) {
        return tarjetaService.asociarTarjetaConUsuario(tarjetaDeUsuarioDto);
    }

}
