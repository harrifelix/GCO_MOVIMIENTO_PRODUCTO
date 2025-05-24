package com.producto.dominio.gateway;

import com.producto.dominio.entities.Movimiento;

import java.util.List;

public interface RepositorioMovimientoGateway {

    void agregar(Movimiento movimiento);
     List<Movimiento> getAll();
}