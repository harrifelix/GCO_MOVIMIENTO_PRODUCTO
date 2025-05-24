package com.producto.dominio.usecase.producto;

import com.producto.dominio.entities.Producto;
import com.producto.dominio.gateway.RepositorioProductoGateway;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProductoByNombreUseCase {

    private final RepositorioProductoGateway repositorioProductoGateway;

    public ObtenerProductoByNombreUseCase(RepositorioProductoGateway repositorioProductoGateway) {
        this.repositorioProductoGateway = repositorioProductoGateway;
    }

    public Producto ejecutar(String isbn) {
        return this.repositorioProductoGateway.obtenerByNombre(isbn);
    }
}
