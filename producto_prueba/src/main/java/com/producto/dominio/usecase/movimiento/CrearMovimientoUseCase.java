package com.producto.dominio.usecase.movimiento;


import com.producto.dominio.gateway.RepositorioMovimientoGateway;
import com.producto.dominio.entities.Movimiento;
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
