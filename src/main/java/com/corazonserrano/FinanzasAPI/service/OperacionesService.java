package com.corazonserrano.FinanzasAPI.service;

import com.corazonserrano.FinanzasAPI.model.Operaciones;
import com.corazonserrano.FinanzasAPI.repository.OperacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OperacionesService {

    @Autowired private OperacionesRepository operacionesRepository;

    public ArrayList<Operaciones> obtenerOperaciones(){
        return (ArrayList<Operaciones>) operacionesRepository.findAll();
    }

    public OperacionesService(OperacionesRepository operacionRepository) {
        this.operacionesRepository = operacionRepository;
    }

    public List<Operaciones> obtenerOperacionesPorTipoIE(String tipoie) {
        return operacionesRepository.findByTipoie(tipoie);
    }

}