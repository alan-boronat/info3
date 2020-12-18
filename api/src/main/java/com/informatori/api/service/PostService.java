package com.informatori.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.informatori.api.model.Post;
import com.informatori.api.model.Usuario;
import com.informatori.api.repository.PostRepository;
import com.informatori.api.repository.UsuarioRepository;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Post createPost (Post post){
        Usuario usuario = usuarioRepository.findByEmail(post.getAutor().getEmail());
        post.setAutor(usuario);
        usuario.getPosts().add(post);
        usuarioRepository.save(usuario);
        return postRepository.save(post);
    }
    public Post updatePost (Post post){
        Post postNew = postRepository.findById(post.getPost_id()).get();
        if (post.getTitulo()!=null){
            postNew.setTitulo(post.getTitulo());
        }
        if (post.getDescripcion()!=null){
            postNew.setDescripcion(post.getDescripcion());
        }
        if (post.getContenido()!=null){
            postNew.setContenido(post.getContenido());
        }
        return postRepository.save(postNew);
    }
    public void deletePost (Post post){
        postRepository.delete(post);
    }
    public List<Post> findPost (){
        return postRepository.findAll();
    }
    public List<Post> findByWord (String word){
        return postRepository.findByTituloContains(word);
    }
    public List<Post> findPostNotPublish (){
        return postRepository.findPostNotPublish();
    }
}
