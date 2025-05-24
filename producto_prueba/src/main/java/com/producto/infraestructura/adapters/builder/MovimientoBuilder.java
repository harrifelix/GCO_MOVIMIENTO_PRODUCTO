package com.producto.infraestructura.adapters.builder;

import com.producto.dominio.entities.Movimiento;
import com.producto.infraestructura.adapters.entidad.MovimientoEntity;
import org.springframework.stereotype.Component;

@Component
public final class MovimientoBuilder {



    public MovimientoBuilder(){

    }

    public static MovimientoEntity buildMovimientoEntity(Movimiento movimiento) {

        MovimientoEntity movimientoEntity = new MovimientoEntity();
        movimientoEntity.setProducto(ProductoBuilder.convertirToEntity(movimiento.getProducto()));
        movimientoEntity.setTipo(movimiento.getTipo());
        movimientoEntity.setCantidad(movimiento.getCantidad());
        movimientoEntity.setFecha(movimiento.getFecha());
        movimientoEntity.setDescripcion(movimiento.getDescripcion());
        return movimientoEntity;
    }
}
