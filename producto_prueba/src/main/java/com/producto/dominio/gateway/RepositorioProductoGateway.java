package com.producto.dominio.gateway;


import com.producto.dominio.entities.Producto;

import  java.util.*;

public interface RepositorioProductoGateway {

    void agregar(Producto producto);

    void actualizar(Producto producto);

    void eliminar(Producto producto);

    Producto obtenerById(String id);

    List<Producto> getAll();


     Producto obtenerByNombre(String id) ;


     Producto obtenerByCodigo(String id);


     Producto obtenerByCategoria(String id) ;
}
