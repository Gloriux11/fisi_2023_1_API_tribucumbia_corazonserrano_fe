package com.corazonserrano.FinanzasAPI.controller;

import com.corazonserrano.FinanzasAPI.exception.PresupuestoNotFoundException;
import com.corazonserrano.FinanzasAPI.model.Presupuesto;
import com.corazonserrano.FinanzasAPI.service.PresupuestoService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ux-presupuesto/appww/servicio-al-cliente/v1")
public class PresupuestoController {

    @Autowired
    private PresupuestoService presupuestoService;

    public PresupuestoController(PresupuestoService presupuestoService) {
        this.presupuestoService = presupuestoService;
    }

    @PostMapping("/nuevo")
    public Presupuesto crearPresupuesto(@RequestBody Presupuesto presupuesto) {
        return presupuestoService.savePresupuesto(presupuesto);
    }

    @GetMapping("/obtenerpresupuesto/{idUsuario}")
    public Presupuesto obtenerPresupuesto(@PathVariable("idUsuario") Integer idUsuario ) {
        return presupuestoService.getPresupuesto(idUsuario);
    }

    //V2
    @RequestMapping(method = RequestMethod.GET, path = "/obtener-presupuesto")
    @ResponseBody
    public Presupuesto obtenerPresupuestoPorID(@RequestParam Integer idUsuario ) {
        return presupuestoService.getPresupuesto(idUsuario);
    }

    @PutMapping("/editar/{id}")
    public Presupuesto actualizarPresupuesto(@PathVariable("id") Integer id, @RequestBody Presupuesto presupuesto) {
        return presupuestoService.updatePresupuesto(id, presupuesto);
    }

    @DeleteMapping("/{idPresupuesto}")
    public void eliminarPresupuesto(@PathVariable("idPresupuesto") Integer idPresupuesto) {
        presupuestoService.deletePresupuesto(idPresupuesto);
    }

}
