package com.producto.dominio.usecase.producto;

import com.producto.dominio.entities.Producto;
import com.producto.dominio.gateway.RepositorioProductoGateway;
import org.springframework.stereotype.Component;
import  java.util.*;

@Component
public class ListarProductoUseCase {

    private final RepositorioProductoGateway repositorioProductoGateway;

    public ListarProductoUseCase(RepositorioProductoGateway repositorioProductoGateway) {
        this.repositorioProductoGateway = repositorioProductoGateway;
    }

    public List<Producto> ejecutar() {
        return this.repositorioProductoGateway.getAll();
    }
}
