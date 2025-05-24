package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.dominio.entities.Producto;
import com.gco.producto.dominio.usecase.producto.ObtenerProductoByCodigoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerByCodigoProducto {

    private final ObtenerProductoByCodigoUseCase obtenerProductoByCodigoUseCase;

    public ManejadorObtenerByCodigoProducto(ObtenerProductoByCodigoUseCase obtenerProductoByCodigoUseCase) {
        this.obtenerProductoByCodigoUseCase = obtenerProductoByCodigoUseCase;
    }

    @Transactional
    public Producto ejecutar(String isbn) {
        return this.obtenerProductoByCodigoUseCase.ejecutar(isbn);
    }
}
