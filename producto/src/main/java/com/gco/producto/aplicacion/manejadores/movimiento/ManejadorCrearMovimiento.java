package com.gco.producto.aplicacion.manejadores.movimiento;

import com.gco.producto.aplicacion.comando.ComandoMovimiento;
import com.gco.producto.aplicacion.factories.MovimientoFactory;
import com.gco.producto.dominio.entities.Movimiento;
import com.gco.producto.dominio.usecase.movimiento.CrearMovimientoUseCase;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearMovimiento {

    private final CrearMovimientoUseCase crearMovimientoUseCase;
    private final MovimientoFactory movimientoFactory;

    public ManejadorCrearMovimiento(CrearMovimientoUseCase crearMovimientoUseCase, MovimientoFactory movimientoFactory) {
        this.crearMovimientoUseCase = crearMovimientoUseCase;
        this.movimientoFactory = movimientoFactory;
    }

    @Transactional
    public void ejecutar(ComandoMovimiento comandoMovimiento) {
        Movimiento movimiento = this.movimientoFactory.crearPrestamo(comandoMovimiento);
        this.crearMovimientoUseCase.ejecutar(movimiento);
    }
}
