package com.producto.dominio.usecase.producto;

import com.producto.dominio.entities.Producto;
import com.producto.dominio.gateway.RepositorioProductoGateway;
import org.springframework.stereotype.Component;

@Component
public class EliminarProductoUseCase {

    private final RepositorioProductoGateway repositorioProductoGateway;

    public EliminarProductoUseCase(RepositorioProductoGateway repositorioProductoGateway) {
        this.repositorioProductoGateway = repositorioProductoGateway;
    }

    public void ejecutar(Producto producto) {
        this.repositorioProductoGateway.agregar(producto);
    }
}
