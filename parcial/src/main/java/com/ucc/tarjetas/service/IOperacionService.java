package com.ucc.tarjetas.service;

import com.ucc.tarjetas.dao.IOperacionDao;
import com.ucc.tarjetas.dao.ITarjetaDao;
import com.ucc.tarjetas.dto.OperacionDto;
import com.ucc.tarjetas.model.Operacion;
import com.ucc.tarjetas.model.Tarjeta;
import com.ucc.tarjetas.model.TipoOperacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOperacionService implements IOperacion {

    @Autowired
    ITarjetaService tarjetaService;

    @Autowired
    ITarjetaDao tarjetaDao;

    @Autowired
    IOperacionDao operacionDao;


    @Override
    public Operacion autorizar(OperacionDto operacionDto) {
        Operacion operacion;
        Tarjeta tarjeta = tarjetaService.obtenerTarjeta(operacionDto.getTarjeta().getId());
        if (operacionDto.getTipoOperacion().equals(TipoOperacion.CREDITO)) {
            operacion = autorizarCredito(operacionDto, tarjeta);
        } else {
            operacion = autorizarDebito(operacionDto, tarjeta);
        }
        return operacion;
    }

    @Override
    public List<Operacion> operacionesPorTarjeta(Long idTarjeta) {
        return operacionDao.encontrarOperacionesPorTarjetaId(idTarjeta);
    }

    private Operacion autorizarCredito(OperacionDto operacionDto, Tarjeta tarjeta) {
        Operacion operacion = new Operacion();
        operacion.setTarjeta(tarjeta);
        operacion.setMonto(operacionDto.getMonto());
        operacion.setTipoOperacion(operacionDto.getTipoOperacion());
        Long saldoDeLaTarjeta = tarjeta.getSaldo();
        Long saldoACargar = operacionDto.getMonto();
        operacion.setAutorizacion("01");
        operacion.setCodigo("01");
        operacion.setEstado("APROBADA");
        tarjeta.setSaldo(saldoDeLaTarjeta + saldoACargar);
        List<Operacion> operacionesDeLaTarjeta = tarjeta.getOperaciones();
        operacionesDeLaTarjeta.add(operacion);
        tarjeta.setOperaciones(operacionesDeLaTarjeta);
        tarjetaDao.save(tarjeta);
        return operacionDao.save(operacion);
    }

    private Operacion autorizarDebito(OperacionDto operacionDto, Tarjeta tarjeta) {
        Operacion operacion = new Operacion();
        operacion.setTarjeta(tarjeta);
        operacion.setMonto(operacionDto.getMonto());
        operacion.setTipoOperacion(operacionDto.getTipoOperacion());
        Long saldoDeLaTarjeta = tarjeta.getSaldo();
        Long saldoAPagar = operacionDto.getMonto();

        if (saldoDeLaTarjeta >= saldoAPagar) {
            operacion.setAutorizacion("01");
            operacion.setCodigo("01");
            operacion.setEstado("APROBADA");
            tarjeta.setSaldo(saldoDeLaTarjeta - saldoAPagar);
            List<Operacion> operacionesDeLaTarjeta = tarjeta.getOperaciones();
            operacionesDeLaTarjeta.add(operacion);
            tarjeta.setOperaciones(operacionesDeLaTarjeta);
            tarjetaDao.save(tarjeta);
        } else {
            operacion.setAutorizacion("02");
            operacion.setCodigo("02");
            operacion.setEstado("RECHAZADA");
        }
        return operacionDao.save(operacion);
    }





}
