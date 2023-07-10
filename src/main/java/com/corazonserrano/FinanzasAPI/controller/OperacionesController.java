package com.corazonserrano.FinanzasAPI.controller;

import com.corazonserrano.FinanzasAPI.exception.UsuarioNotFoundException;
import com.corazonserrano.FinanzasAPI.model.Operaciones;
import com.corazonserrano.FinanzasAPI.model.Usuario;
import com.corazonserrano.FinanzasAPI.service.OperacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @GetMapping("/listar-egresos/{idUsuario}")
    public List<Operaciones> obtenerOperacionesPorTipoIEyUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        String tipoie = "E";
        return operacionesService.obtenerOperacionesPorTipoIEyUsuario(idUsuario, tipoie);
    }

    @GetMapping("/listar-ingresos/{idUsuario}")
    public List<Operaciones> obtenerOperacionesPorTipoIyUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        String tipoie = "I";
        return operacionesService.obtenerOperacionesPorTipoIEyUsuario(idUsuario, tipoie);
    }
    //ESTOS DOS SON NUEVOS CON GET
    @RequestMapping(method = RequestMethod.GET, path = "/listar-ingresos2")
    @ResponseBody
    public List<Operaciones> obtenerOperacionesIngresos(@RequestParam Integer idUsuario) {
        String tipoie = "I";
        return operacionesService.obtenerOperacionesPorTipoIEyUsuario(idUsuario, tipoie);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/listar-egresos2")
    @ResponseBody
    public List<Operaciones> obtenerOperacionesEgresos(@RequestParam Integer idUsuario) {
        String tipoie = "E";
        return operacionesService.obtenerOperacionesPorTipoIEyUsuario(idUsuario, tipoie);
    }


}

