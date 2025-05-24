package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.aplicacion.comando.ComandoProducto;
import com.gco.producto.aplicacion.factories.ProductoFactory;
import com.gco.producto.dominio.entities.Producto;
import com.gco.producto.dominio.usecase.producto.ActualizarProductoUseCase;
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
