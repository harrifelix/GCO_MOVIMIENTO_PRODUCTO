package com.producto.aplicacion.manejadores.producto;

import com.producto.dominio.entities.Producto;
import com.producto.dominio.usecase.producto.ObtenerProductoByNombreUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerByNombreProducto {

    private final ObtenerProductoByNombreUseCase obtenerProductoByNombreUseCase;

    public ManejadorObtenerByNombreProducto(ObtenerProductoByNombreUseCase obtenerProductoByNombreUseCase) {
        this.obtenerProductoByNombreUseCase = obtenerProductoByNombreUseCase;
    }

    @Transactional
    public Producto ejecutar(String isbn) {
        return this.obtenerProductoByNombreUseCase.ejecutar(isbn);
    }
}
