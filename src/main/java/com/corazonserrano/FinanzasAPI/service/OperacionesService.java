package com.corazonserrano.FinanzasAPI.service;

import com.corazonserrano.FinanzasAPI.model.Operaciones;
import com.corazonserrano.FinanzasAPI.repository.OperacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OperacionesService {
    @Autowired
    OperacionesRepository operacionesRepository;
/*
    public List<Operaciones> obtenerOperaciones(String usuario, String tipoie) {
        List<Operaciones> operaciones = (List<Operaciones>) operacionesRepository.findByLoginAndTipoie(usuario, tipoie);
        return operaciones;
    }
*/
    public ArrayList<Operaciones> obtenerOperaciones(){
        return (ArrayList<Operaciones>) operacionesRepository.findAll();
    }

    public ArrayList<Operaciones> obtenerIngresos(String tipoie){
        return operacionesRepository.findByIngresos(tipoie);
    }
}