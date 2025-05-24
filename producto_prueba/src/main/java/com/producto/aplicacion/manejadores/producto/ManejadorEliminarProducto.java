package com.producto.aplicacion.manejadores.producto;

import com.producto.aplicacion.comando.ComandoProducto;
import com.producto.dominio.usecase.producto.EliminarProductoUseCase;
import com.producto.aplicacion.factories.ProductoFactory;
import com.producto.dominio.entities.Producto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorEliminarProducto {

    private final EliminarProductoUseCase eliminarProductoUseCase;
    private final ProductoFactory productoFactory;

    public ManejadorEliminarProducto( ProductoFactory productoFactory, EliminarProductoUseCase eliminarProductoUseCase) {
        this.eliminarProductoUseCase = eliminarProductoUseCase;
        this.productoFactory = productoFactory;
    }

    @Transactional
    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.productoFactory.factoryProducto(comandoProducto);
        this.eliminarProductoUseCase.ejecutar(producto);
    }
}
