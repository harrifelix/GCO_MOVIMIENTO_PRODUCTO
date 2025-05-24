package com.producto.aplicacion.manejadores.movimiento;

import com.producto.aplicacion.comando.ComandoMovimiento;
import com.producto.aplicacion.factories.MovimientoFactory;
import com.producto.dominio.entities.Movimiento;
import com.producto.dominio.usecase.movimiento.ListarMovimientoUseCase;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Component
public class ManejadorListarMovimiento {

    private final ListarMovimientoUseCase listarMovimientoUseCase;
    private final MovimientoFactory movimientoFactory;

    public ManejadorListarMovimiento( ListarMovimientoUseCase listarMovimientoUseCase, MovimientoFactory movimientoFactory) {
        this.listarMovimientoUseCase = listarMovimientoUseCase;
        this.movimientoFactory = movimientoFactory;
    }

    @Transactional
    public List<Movimiento> ejecutar(ComandoMovimiento comandoMovimiento) {
        Movimiento movimiento = this.movimientoFactory.crearPrestamo(comandoMovimiento);
       return this.listarMovimientoUseCase.ejecutar();
    }
}
