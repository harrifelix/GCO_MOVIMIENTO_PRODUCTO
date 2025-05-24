package com.gco.producto.infraestructura.entrypoints;
import com.gco.producto.aplicacion.manejadores.movimiento.ManejadorCrearMovimiento;
import com.gco.producto.aplicacion.manejadores.producto.ManejadorListarProductos;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.gco.producto.dominio.entities.Producto;

@RestController
@RequestMapping("/movimiento")
public class MovimientoProducto {

    private final ManejadorListarProductos
            manejadorObtenerMovimiento;

    private final ManejadorCrearMovimiento manejadorCrearMovimiento;

    public MovimientoProducto(ManejadorListarProductos manejadorObtenerMovimiento ,
                               ManejadorCrearMovimiento manejadorCrearMovimiento
            ) {
        this.manejadorCrearMovimiento = manejadorCrearMovimiento;
        this.manejadorObtenerMovimiento=manejadorObtenerMovimiento;
    }

    @GetMapping()
    public List<Producto> obtenerProductos() {
        return this.manejadorObtenerMovimiento.ejecutar();
    }


}
