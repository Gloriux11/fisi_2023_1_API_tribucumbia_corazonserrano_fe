package com.corazonserrano.FinanzasAPI.controller;

import com.corazonserrano.FinanzasAPI.model.Operaciones;
import com.corazonserrano.FinanzasAPI.service.OperacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/operaciones")
public class OperacionesController {
    @Autowired
    private OperacionesService operacionesService;

    @GetMapping
    public ArrayList<Operaciones> obtenerPorOperaciones() {
        return operacionesService.obtenerOperaciones();
    }

    @GetMapping(path = "/{tipoie}")
    public ArrayList<Operaciones> obtenerPorFiltro(@PathVariable("id") String tipoie) {
        return this.operacionesService.obtenerIngresos(tipoie);
    }

}

