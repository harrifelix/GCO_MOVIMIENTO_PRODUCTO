package com.producto.aplicacion.manejadores.producto;

import com.producto.dominio.usecase.producto.ObtenerProductoByCodigoUseCase;
import com.producto.dominio.entities.Producto;
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
