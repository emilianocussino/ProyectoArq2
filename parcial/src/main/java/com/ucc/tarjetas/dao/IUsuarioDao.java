package com.ucc.tarjetas.dao;

import com.ucc.tarjetas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario,Long> {
    Usuario findUsuarioById(Long id);
}
