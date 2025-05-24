package com.gco.producto.dominio.gateway;

import com.gco.producto.dominio.entities.Movimiento;

import java.util.List;

public interface RepositorioMovimientoGateway {

    void agregar(Movimiento movimiento);
     List<Movimiento> getAll();
}