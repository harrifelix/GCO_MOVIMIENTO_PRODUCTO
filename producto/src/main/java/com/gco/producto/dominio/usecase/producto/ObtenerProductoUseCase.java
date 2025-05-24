package com.gco.producto.dominio.usecase.producto;

import com.gco.producto.dominio.entities.Producto;
import com.gco.producto.dominio.gateway.RepositorioProductoGateway;
import org.springframework.stereotype.Component;
@Component
public class ObtenerProductoUseCase {

    private final RepositorioProductoGateway repositorioProductoGateway;

    public ObtenerProductoUseCase(RepositorioProductoGateway repositorioProductoGateway) {
        this.repositorioProductoGateway = repositorioProductoGateway;
    }

    public Producto ejecutar(String isbn) {
        return this.repositorioProductoGateway.obtenerById(isbn);
    }
}
