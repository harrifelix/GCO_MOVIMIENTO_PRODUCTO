package com.producto.infraestructura.entrypoints;

import com.producto.aplicacion.comando.ComandoMovimiento;
import com.producto.aplicacion.comando.ComandoProducto;
import com.producto.aplicacion.manejadores.movimiento.ManejadorCrearMovimiento;
import com.producto.aplicacion.manejadores.producto.*;
import com.producto.dominio.entities.Producto;
import com.producto.infraestructura.entrypoints.enums.TipoMovimientoEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ControladorProducto {

    private final ManejadorListarProductos
            manejadorObtenerMovimiento;

    private final ManejadorCrearProducto manejadorCrearProducto;

    private final ManejadorEliminarProducto manejadorEliminarProducto;

    private final ManejadorActualizarProducto manejadorActualizarProducto;

    private final ManejadorCrearMovimiento manejadorCrearMovimiento;

    private final ManejadorObtenerByCategoriaProducto manejadorObtenerByCategoriaProducto;


    private final ManejadorObtenerByCodigoProducto manejadorObtenerByCodigoProducto;


    private final ManejadorObtenerByNombreProducto manejadorObtenerByNombreProducto;

    public static final String FEHCA_CON_FORMATO = "dd-MM-yyyy";
    public static final String TIME_ZONE = "America/Bogota";

    public ControladorProducto(ManejadorListarProductos manejadorObtenerMovimiento ,ManejadorCrearProducto manejadorCrearProducto
    ,ManejadorEliminarProducto manejadorEliminarProducto
    ,ManejadorActualizarProducto manejadorActualizarProducto
    ,ManejadorCrearMovimiento manejadorCrearMovimiento
    ,ManejadorObtenerByCategoriaProducto manejadorObtenerByCategoriaProducto
    ,ManejadorObtenerByCodigoProducto manejadorObtenerByCodigoProducto
    ,ManejadorObtenerByNombreProducto manejadorObtenerByNombreProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorObtenerMovimiento=manejadorObtenerMovimiento;
        this.manejadorEliminarProducto=manejadorEliminarProducto;
        this.manejadorActualizarProducto=manejadorActualizarProducto;
        this.manejadorCrearMovimiento=manejadorCrearMovimiento;
        this.manejadorObtenerByCategoriaProducto=manejadorObtenerByCategoriaProducto;
        this.manejadorObtenerByCodigoProducto=manejadorObtenerByCodigoProducto;
                this.manejadorObtenerByNombreProducto=manejadorObtenerByNombreProducto;
    }

    @GetMapping()
    public List<Producto> obtenerProductoPrestadoById() {
        return this.manejadorObtenerMovimiento.ejecutar();
    }

    @GetMapping("byNombre/{nombre}")
    public Producto getByNombre(@PathVariable(name = "nombre") String nombre) {
        return this.manejadorObtenerByNombreProducto.ejecutar(nombre);
    }

    @GetMapping("byCategoria/{categoria}")
    public Producto getByCategoria(@PathVariable(name = "categoria") String categoria) {
        return this.manejadorObtenerByCategoriaProducto.ejecutar(categoria);
    }

    @GetMapping("byCodigo/{codigo}")
    public Producto getByCodigo(@PathVariable(name = "codigo") String codigo) {
        return this.manejadorObtenerByCodigoProducto.ejecutar(codigo);
    }

    @DeleteMapping()
    public void Eliminar(@RequestBody ComandoProducto comandoProducto){
        this.manejadorEliminarProducto.ejecutar(comandoProducto);
    }

    @PutMapping()
    public void actualizar(@RequestBody ComandoProducto comandoProducto){
        this.manejadorActualizarProducto.ejecutar(comandoProducto);
    }

    @PostMapping
    public ResponseEntity agregar(@RequestBody ComandoProducto comandoProducto) {

        this.agregarProducto(comandoProducto.getId(),comandoProducto.getNombre(),
                comandoProducto.getDescripcion(),
                comandoProducto.getPrecio()
                        ,comandoProducto.getStock()
                        ,comandoProducto.getCategoria()
        ,comandoProducto.getCodigo()
                        ,comandoProducto.getFechaCreacion());

        //Si todo va Ok  se retorna el body con su datos
        return ResponseEntity.ok(comandoProducto);
    }

    private void agregarProducto(int id, String nombre, String descripcion, double precio, int stock, String categoría, String codigo, Date fechaCreacion) {
        ComandoProducto comandoProducto = new ComandoProducto(id
                , nombre,descripcion,precio,stock,categoría,codigo,fechaCreacion);
        this.manejadorCrearProducto.ejecutar(comandoProducto);

       /* Producto producto=new Producto(id ,nombre,descripcion,precio,stock,categoría,codigo,fechaCreacion);

        agregarMovimiento(producto,0, TipoMovimientoEnum.ENTRADA
        ,descripcion , 1, fechaCreacion);*/
    }

    private void agregarMovimiento(Producto producto, int id, TipoMovimientoEnum tipo, String descripcion, int cantidad, Date fechaCreación) {
        ComandoMovimiento comandoMovimiento = new ComandoMovimiento(id,producto,tipo,cantidad,fechaCreación,descripcion);
        this.manejadorCrearMovimiento.ejecutar(comandoMovimiento);
    }
}
