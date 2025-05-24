package com.gco.producto.dominio.usecase.movimiento;


import com.gco.producto.dominio.entities.Movimiento;
import com.gco.producto.dominio.gateway.RepositorioMovimientoGateway;
import org.springframework.stereotype.Component;

@Component
public class CrearMovimientoUseCase {

    private final RepositorioMovimientoGateway repositorioMovimientoGateway;

    public CrearMovimientoUseCase(RepositorioMovimientoGateway repositorioMovimientoGateway) {
        this.repositorioMovimientoGateway =repositorioMovimientoGateway;
    }

    public void ejecutar(Movimiento movimiento) {
         this.repositorioMovimientoGateway.agregar(movimiento);
    }
}
