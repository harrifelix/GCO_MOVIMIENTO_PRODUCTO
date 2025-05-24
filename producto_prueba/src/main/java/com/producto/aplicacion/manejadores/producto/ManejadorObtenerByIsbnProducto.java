package com.producto.aplicacion.manejadores.producto;

import com.producto.dominio.entities.Producto;
import com.producto.dominio.usecase.producto.ObtenerProductoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerByIsbnProducto {

    private final ObtenerProductoUseCase servicioObtenerProducto;

    public ManejadorObtenerByIsbnProducto(ObtenerProductoUseCase servicioObtenerProducto) {
        this.servicioObtenerProducto = servicioObtenerProducto;
    }

    @Transactional
    public Producto ejecutar(String isbn) {
        return this.servicioObtenerProducto.ejecutar(isbn);
    }
}
