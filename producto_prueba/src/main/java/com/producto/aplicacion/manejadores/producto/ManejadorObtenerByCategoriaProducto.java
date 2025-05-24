package com.producto.aplicacion.manejadores.producto;

import com.producto.dominio.entities.Producto;
import com.producto.dominio.usecase.producto.ObtenerProductoByCategoriaUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerByCategoriaProducto {

    private final ObtenerProductoByCategoriaUseCase obtenerProductoByCategoriaUseCase;

    public ManejadorObtenerByCategoriaProducto(ObtenerProductoByCategoriaUseCase obtenerProductoByCategoriaUseCase) {
        this.obtenerProductoByCategoriaUseCase = obtenerProductoByCategoriaUseCase;
    }

    @Transactional
    public Producto ejecutar(String isbn) {
        return this.obtenerProductoByCategoriaUseCase.ejecutar(isbn);
    }
}
