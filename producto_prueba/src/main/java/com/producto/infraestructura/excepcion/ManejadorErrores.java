package com.producto.infraestructura.excepcion;

import com.producto.dominio.excepcion.MovimientoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ManejadorErrores extends ResponseEntityExceptionHandler {

    private static final String OCURRIO_UN_ERROR = "Ha ocurrido un error comuniquese con el admin.";

    private static final ConcurrentHashMap<String, Integer> CODIGOS = new ConcurrentHashMap<>();

    public ManejadorErrores() {
        CODIGOS.put(MovimientoException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> resultado;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS.get(excepcionNombre);

        if (codigo != null) {
            Error error = new Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            Error error = new Error(excepcionNombre, OCURRIO_UN_ERROR);
            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resultado;
    }
}
