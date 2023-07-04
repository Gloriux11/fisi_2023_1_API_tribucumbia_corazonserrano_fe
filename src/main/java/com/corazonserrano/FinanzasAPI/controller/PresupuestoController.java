package com.corazonserrano.FinanzasAPI.controller;

import com.corazonserrano.FinanzasAPI.exception.PresupuestoNotFoundException;
import com.corazonserrano.FinanzasAPI.model.Presupuesto;
import com.corazonserrano.FinanzasAPI.service.PresupuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/presupuesto")
public class PresupuestoController {

    @Autowired
    private PresupuestoService presupuestoService;

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public Presupuesto savePresupuesto(@RequestBody Presupuesto presupuesto) {
        return presupuestoService.savePresupuesto(presupuesto);
    }

    @GetMapping(value = "/getPresupuesto")
    public Presupuesto getPresupuesto(@RequestParam Integer idPresupuesto) {
        return presupuestoService.getPresupuesto(idPresupuesto).orElseThrow(PresupuestoNotFoundException::new);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Presupuesto updatePresupuesto(@RequestParam Integer idPresupuesto, @RequestBody Presupuesto presupuesto) {
        return presupuestoService.updatePresupuesto(idPresupuesto, presupuesto);
    }
}
