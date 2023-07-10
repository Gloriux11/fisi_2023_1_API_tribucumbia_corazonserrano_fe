package com.corazonserrano.FinanzasAPI.service;

import com.corazonserrano.FinanzasAPI.exception.PresupuestoNotFoundException;
import com.corazonserrano.FinanzasAPI.model.Presupuesto;
import com.corazonserrano.FinanzasAPI.repository.PresupuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PresupuestoService {

    @Autowired
    private PresupuestoRepository presupuestoRepository;

    public PresupuestoService(PresupuestoRepository presupuestoRepository) {
        this.presupuestoRepository = presupuestoRepository;
    }

    public Presupuesto savePresupuesto(Presupuesto presupuesto) {
        return presupuestoRepository.save(presupuesto);
    }

    public Presupuesto getPresupuesto(Integer idUsuario) {
        return presupuestoRepository.findByIdPresupuestoAndIdUsuario(idUsuario);
    }

    public Presupuesto updatePresupuesto(Integer id, Presupuesto presupuesto) {
        Optional<Presupuesto> existingPresupuesto = presupuestoRepository.findById(id);
        if (existingPresupuesto.isPresent()) {
            Presupuesto updatedPresupuesto = existingPresupuesto.get();
            updatedPresupuesto.setIdUsuario(presupuesto.getIdUsuario());
            updatedPresupuesto.setFechaInicio(presupuesto.getFechaInicio());
            updatedPresupuesto.setFechaFin(presupuesto.getFechaFin());
            updatedPresupuesto.setMonto(presupuesto.getMonto());
            return presupuestoRepository.save(updatedPresupuesto);
        } else {
            throw new PresupuestoNotFoundException();
        }
    }


    public void deletePresupuesto(Integer id) {
        presupuestoRepository.deleteById(id);
    }
}
