package com.informatori.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import com.informatori.api.model.Comentario;
import com.informatori.api.model.Post;
import com.informatori.api.model.Usuario;
import com.informatori.api.repository.ComentarioRepository;
import com.informatori.api.repository.PostRepository;
import com.informatori.api.repository.UsuarioRepository;

@Service
public class ComentarioService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Comentario createComment (Comentario comentario){
        Usuario usuario = usuarioRepository.findById(comentario.getAutor().getId()).get();
        Post post = postRepository.findById(comentario.getPost().getPost_id()).get();
        post.getComment().add(comentario);
        comentario.setPost(post);
        comentario.setAutor(usuario);
        usuario.getComentarios().add(comentario);
        usuarioRepository.save(usuario);
        postRepository.save(post);
        return comentarioRepository.save(comentario);
    }
    public Comentario updateComment (Comentario comentario){
        Comentario newComment = comentarioRepository.findById(comentario.getComment_id()).get();
        if (comentario.getComentario()!=null){
            newComment.setComentario(comentario.getComentario());
        }

        return comentarioRepository.save(newComment);
    }
    public void deleteComment (Comentario comentario){
        comentarioRepository.delete(comentario);
    }
    public List<Comentario> searchComment (Integer post_id, Integer max){
        List<Comentario> comentarios = comentarioRepository.findByPost(post_id);
        if (max != null){
            comentarios = new ArrayList<>(comentarios.subList(0,max));
        }
        return comentarios;
    }
}
