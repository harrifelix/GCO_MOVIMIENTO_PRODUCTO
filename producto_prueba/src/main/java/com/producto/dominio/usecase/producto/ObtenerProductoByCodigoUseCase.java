package com.producto.dominio.usecase.producto;

import com.producto.dominio.entities.Producto;
import com.producto.dominio.gateway.RepositorioProductoGateway;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProductoByCodigoUseCase {

    private final RepositorioProductoGateway repositorioProductoGateway;

    public ObtenerProductoByCodigoUseCase(RepositorioProductoGateway repositorioProductoGateway) {
        this.repositorioProductoGateway = repositorioProductoGateway;
    }

    public Producto ejecutar(String isbn) {
        return this.repositorioProductoGateway.obtenerByCodigo(isbn);
    }
}
