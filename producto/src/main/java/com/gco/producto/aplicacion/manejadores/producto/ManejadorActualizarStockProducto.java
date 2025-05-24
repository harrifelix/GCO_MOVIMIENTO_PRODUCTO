package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.aplicacion.comando.ComandoProducto;
import com.gco.producto.aplicacion.factories.ProductoFactory;
import com.gco.producto.dominio.entities.Producto;
import com.gco.producto.dominio.usecase.producto.CrearProductoUseCase;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorActualizarStockProducto {

    private final CrearProductoUseCase crearProductoUseCase;
    private final ProductoFactory productoFactory;

    public ManejadorActualizarStockProducto(CrearProductoUseCase crearProductoUseCase, ProductoFactory productoFactory) {
        this.crearProductoUseCase = crearProductoUseCase;
        this.productoFactory = productoFactory;
    }

    @Transactional
    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.productoFactory.factoryProducto(comandoProducto);
        this.crearProductoUseCase.ejecutar(producto);
    }
}
