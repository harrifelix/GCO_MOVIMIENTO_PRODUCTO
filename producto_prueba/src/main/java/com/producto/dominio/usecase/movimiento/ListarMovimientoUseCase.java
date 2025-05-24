package com.producto.dominio.usecase.movimiento;


import com.producto.dominio.entities.Movimiento;
import com.producto.dominio.gateway.RepositorioMovimientoGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarMovimientoUseCase {

    private final RepositorioMovimientoGateway repositorioMovimientoGateway;

    public ListarMovimientoUseCase(RepositorioMovimientoGateway repositorioMovimientoGateway) {
        this.repositorioMovimientoGateway =repositorioMovimientoGateway;
    }

    public List<Movimiento> ejecutar() {
      return  this.repositorioMovimientoGateway.getAll();
    }
}
