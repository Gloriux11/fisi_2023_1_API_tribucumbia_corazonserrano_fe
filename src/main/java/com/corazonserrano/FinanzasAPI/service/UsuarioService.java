package com.corazonserrano.FinanzasAPI.service;

import com.corazonserrano.FinanzasAPI.model.Usuario;
import com.corazonserrano.FinanzasAPI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveUsuario(Usuario savedUsuario) {
        Usuario usuario = new Usuario();
        usuario.setUserName(savedUsuario.getUserName());
        usuario.setPassword(savedUsuario.getPassword());
        return usuarioRepository.save(savedUsuario);
    }

    public Optional<Usuario> findByUserId(Integer id) {
        Usuario usuario = usuarioRepository.findByUserId(id);

        return Optional.ofNullable(usuario);
    }
}

