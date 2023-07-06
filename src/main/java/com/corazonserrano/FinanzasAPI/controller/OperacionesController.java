package com.corazonserrano.FinanzasAPI.controller;

import com.corazonserrano.FinanzasAPI.model.Operaciones;
import com.corazonserrano.FinanzasAPI.service.OperacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/operaciones")
public class OperacionesController {
    @Autowired
    private OperacionesService operacionesService;

    @RequestMapping(method = RequestMethod.GET, path = "/getOperaciones")
    @ResponseBody
    public List<Operaciones> obtenerOperaciones(@RequestParam String usuario, @RequestParam String tipoie) {
        return operacionesService.obtenerOperaciones(usuario, tipoie);
    }

}

