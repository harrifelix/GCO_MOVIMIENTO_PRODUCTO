package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.dominio.entities.Producto;
import com.gco.producto.dominio.usecase.producto.ListarProductoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import  java.util.*;

@Service
public class ManejadorListarProductos {

    private final ListarProductoUseCase listarProductoUseCase;

    public ManejadorListarProductos(ListarProductoUseCase listarProductoUseCase) {
        this.listarProductoUseCase = listarProductoUseCase;
    }

    @Transactional
    public List<Producto> ejecutar() {
        return this.listarProductoUseCase.ejecutar();
    }
}
