package com.corazonserrano.FinanzasAPI.repository;

import com.corazonserrano.FinanzasAPI.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.id =:id")
    Usuario findByUserId(Integer id);
}
