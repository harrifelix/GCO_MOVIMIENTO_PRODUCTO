package com.producto.infraestructura.entrypoints;
import com.producto.aplicacion.manejadores.producto.ManejadorListarProductos;
import com.producto.dominio.entities.Producto;
import com.producto.aplicacion.manejadores.movimiento.ManejadorCrearMovimiento;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
