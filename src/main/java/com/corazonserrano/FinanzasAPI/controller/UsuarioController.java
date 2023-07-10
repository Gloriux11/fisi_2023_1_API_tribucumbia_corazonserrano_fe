package com.corazonserrano.FinanzasAPI.controller;

import com.corazonserrano.FinanzasAPI.exception.UsuarioNotFoundException;
import com.corazonserrano.FinanzasAPI.model.Usuario;
import com.corazonserrano.FinanzasAPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @RequestMapping(method = RequestMethod.POST, path = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getUsuario")
    @ResponseBody
    public Usuario findByUserId(@RequestParam Integer idUsuario) {
        return usuarioService.findByUserId(idUsuario).orElseThrow(UsuarioNotFoundException::new);
    }

}
