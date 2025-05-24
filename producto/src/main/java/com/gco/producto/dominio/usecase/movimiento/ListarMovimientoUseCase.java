package com.gco.producto.dominio.usecase.movimiento;


import com.gco.producto.dominio.entities.Movimiento;
import com.gco.producto.dominio.gateway.RepositorioMovimientoGateway;
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
