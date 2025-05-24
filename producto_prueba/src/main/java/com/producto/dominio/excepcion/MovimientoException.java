package com.producto.dominio.excepcion;

public class MovimientoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MovimientoException(String message) {
        super(message);
    }
}
