package com.informatori.api.repository;



import com.informatori.api.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

        @Query(value = "select * from comentario where post_id = ?1 order by fecha_creacion desc", nativeQuery = true)
        List<Comentario> findByPost(Integer post_id);

}
