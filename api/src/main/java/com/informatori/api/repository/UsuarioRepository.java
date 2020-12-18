package com.informatori.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.informatori.api.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public void deleteByEmail(String email);
    public Usuario findByEmail(String email);

    @Query(value = "select * from usuario where fecha >= ?1", nativeQuery = true)
    List<Usuario> findUserByDate(String date);

}
