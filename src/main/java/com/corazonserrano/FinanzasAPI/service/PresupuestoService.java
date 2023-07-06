package com.corazonserrano.FinanzasAPI.service;

import com.corazonserrano.FinanzasAPI.exception.PresupuestoNotFoundException;
import com.corazonserrano.FinanzasAPI.model.Presupuesto;
import com.corazonserrano.FinanzasAPI.repository.PresupuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PresupuestoService {
/*
    @Autowired
    private PresupuestoRepository presupuestoRepository;

    public Presupuesto savePresupuesto(Presupuesto presupuesto) {
        return presupuestoRepository.save(presupuesto);
    }

    public Optional<Presupuesto> getPresupuesto(Integer idPresupuesto) {
        return presupuestoRepository.findById(idPresupuesto);
    }

    public Presupuesto updatePresupuesto(Integer idPresupuesto, Presupuesto presupuesto) {
        Optional<Presupuesto> existingPresupuesto = presupuestoRepository.findById(idPresupuesto);
        if (existingPresupuesto.isPresent()) {
            Presupuesto updatedPresupuesto = existingPresupuesto.get();
            updatedPresupuesto.setLogin(presupuesto.getLogin());
            updatedPresupuesto.setFecha(presupuesto.getFecha());
            updatedPresupuesto.setMonto(presupuesto.getMonto());
            return presupuestoRepository.save(updatedPresupuesto);
        } else {
            throw new PresupuestoNotFoundException();
        }
    }*/
}
