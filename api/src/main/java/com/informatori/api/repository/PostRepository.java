package com.informatori.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.informatori.api.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByTituloContains(String word);

    @Query(value = "select * from post where publicado = false", nativeQuery = true)
    List<Post> findPostNotPublish();
}

