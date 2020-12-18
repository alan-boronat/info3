package com.informatori.api.controller;

import com.informatori.api.model.Comentario;

import com.informatori.api.service.ComentarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("createcomment")
    public ResponseEntity<String> crearComentario(@RequestBody Comentario comentario){
        comentarioService.createComment(comentario);
        ResponseEntity <String> responseEntity = new ResponseEntity("comentario creado", HttpStatus.OK);
        return responseEntity;
    }
    @PutMapping("editcomment")
    public ResponseEntity<Comentario> editarPosts(@RequestBody Comentario comentario) {
        Comentario newComment = comentarioService.updateComment(comentario);
        ResponseEntity<Comentario> responseEntity = new ResponseEntity(newComment, HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("deletecomment")
    public ResponseEntity<String> eliminarComment (@RequestBody Comentario comentario) {
        comentarioService.deleteComment(comentario);
        ResponseEntity<String> responseEntity = new ResponseEntity("comment eliminado", HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping ("showcomments")
    public ResponseEntity <List<Comentario>> mostrarComments (@RequestParam Integer postid, @RequestParam (required = false) Integer max){
        List<Comentario> comentarios = comentarioService.searchComment(postid, max);
        ResponseEntity<List<Comentario>> responseEntity = new ResponseEntity<>(comentarios, HttpStatus.OK);
        return responseEntity;
    }
}
