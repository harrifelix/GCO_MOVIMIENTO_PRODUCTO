package com.producto.aplicacion.factories;

import com.producto.aplicacion.comando.ComandoProducto;
import com.producto.dominio.entities.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoFactory {

    public Producto factoryProducto(ComandoProducto comandoProducto) {
        return new Producto(
                comandoProducto.getId(), comandoProducto.getNombre()
                , comandoProducto.getDescripcion(), comandoProducto.getPrecio(),comandoProducto.getStock()
                ,comandoProducto.getCategoria(),comandoProducto.getCodigo(),comandoProducto.getFechaCreacion());

    }
}
