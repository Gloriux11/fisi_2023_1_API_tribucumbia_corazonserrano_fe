package com.corazonserrano.FinanzasAPI.controller;

import com.corazonserrano.FinanzasAPI.model.Operaciones;
import com.corazonserrano.FinanzasAPI.service.OperacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operaciones")
@CrossOrigin
public class OperacionesController {

    @Autowired
    private OperacionesService operacionesService;

    @GetMapping("listado")
    public List<Operaciones> obtenerPorOperaciones() {
        return operacionesService.obtenerOperaciones();
    }

    public OperacionesController(OperacionesService operacionService) {
        this.operacionesService = operacionService;
    }

    @GetMapping("/filtro/{tipoie}")
    public List<Operaciones> filtrarPorTipoIE(@PathVariable("tipoie") String tipoie) {
        return operacionesService.obtenerOperacionesPorTipoIE(tipoie);
    }

}

