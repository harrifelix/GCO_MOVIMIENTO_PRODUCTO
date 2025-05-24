package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.dominio.entities.Producto;
import com.gco.producto.dominio.usecase.producto.ObtenerProductoUseCase;
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
