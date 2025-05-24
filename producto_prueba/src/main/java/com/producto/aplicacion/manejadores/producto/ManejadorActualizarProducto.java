package com.producto.aplicacion.manejadores.producto;

import com.producto.aplicacion.comando.ComandoProducto;
import com.producto.dominio.entities.Producto;
import com.producto.dominio.usecase.producto.ActualizarProductoUseCase;
import com.producto.aplicacion.factories.ProductoFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorActualizarProducto {

    private final ActualizarProductoUseCase actualizarProductoUseCase;
    private final ProductoFactory productoFactory;

    public ManejadorActualizarProducto(ActualizarProductoUseCase actualizarProductoUseCase, ProductoFactory productoFactory) {
        this.actualizarProductoUseCase = actualizarProductoUseCase;
        this.productoFactory = productoFactory;
    }

    @Transactional
    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.productoFactory.factoryProducto(comandoProducto);
        this.actualizarProductoUseCase.ejecutar(producto);
    }
}
