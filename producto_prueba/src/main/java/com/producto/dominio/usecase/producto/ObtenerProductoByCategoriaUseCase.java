package com.producto.dominio.usecase.producto;

import com.producto.dominio.entities.Producto;
import com.producto.dominio.gateway.RepositorioProductoGateway;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProductoByCategoriaUseCase {

    private final RepositorioProductoGateway repositorioProductoGateway;

    public ObtenerProductoByCategoriaUseCase(RepositorioProductoGateway repositorioProductoGateway) {
        this.repositorioProductoGateway = repositorioProductoGateway;
    }

    public Producto ejecutar(String isbn) {
        return this.repositorioProductoGateway.obtenerByCategoria(isbn);
    }
}
