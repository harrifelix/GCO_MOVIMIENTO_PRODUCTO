package com.producto.aplicacion.factories;

import com.producto.aplicacion.comando.ComandoMovimiento;
import com.producto.dominio.entities.Movimiento;
import org.springframework.stereotype.Component;

@Component
public class MovimientoFactory {

    public Movimiento crearPrestamo(ComandoMovimiento comandoMovimiento) {
        return new Movimiento(comandoMovimiento.getId(),comandoMovimiento.getProducto()
        ,comandoMovimiento.getTipo(),comandoMovimiento.getCantidad()
                ,comandoMovimiento.getFecha(),comandoMovimiento.getDescripción());
    }
}
