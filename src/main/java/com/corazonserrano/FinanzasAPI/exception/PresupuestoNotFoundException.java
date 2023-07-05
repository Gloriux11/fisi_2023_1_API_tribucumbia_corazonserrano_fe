package com.corazonserrano.FinanzasAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PresupuestoNotFoundException extends RuntimeException {
    public PresupuestoNotFoundException() {
        super("No se ha encontrado el presupuesto");
    }
}
