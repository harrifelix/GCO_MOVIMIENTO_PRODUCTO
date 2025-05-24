package com.producto.aplicacion.manejadores.producto;

import com.producto.aplicacion.comando.ComandoProducto;
import com.producto.dominio.entities.Producto;
import com.producto.dominio.usecase.producto.CrearProductoUseCase;
import com.producto.aplicacion.factories.ProductoFactory;
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
