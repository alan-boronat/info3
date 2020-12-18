package com.informatori.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.informatori.api.model.Post;
import com.informatori.api.service.PostService;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("createpost")
    public ResponseEntity<String> crearPost(@RequestBody Post post){
        postService.createPost(post);
        ResponseEntity <String> responseEntity = new ResponseEntity("post creado", HttpStatus.OK);
        return responseEntity;
    }
    @PutMapping ("editpost")
    public ResponseEntity<Post> editarPosts(@RequestBody Post post) {
        Post postNew = postService.updatePost(post);
        ResponseEntity<Post> responseEntity = new ResponseEntity(postNew, HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("deletepost")
    public ResponseEntity<String> eliminarPost (@RequestBody Post post) {
        postService.deletePost(post);
        ResponseEntity<String> responseEntity = new ResponseEntity("post eliminado", HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("showposts")
    public ResponseEntity<List<Post>> mostrarPosts() {
        List<Post> posts = postService.findPost();
        ResponseEntity<List<Post>> responseEntity = new ResponseEntity(posts, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping ("titlebywords")
    public ResponseEntity<List<Post>> postsPorPalabra(@RequestParam String word) {
        List<Post> posts = postService.findByWord(word);
        ResponseEntity<List<Post>> responseEntity = new ResponseEntity(posts, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("unpublishedposts")
    public ResponseEntity<List<Post>> mostrarPostsNoPublicados() {
        List<Post> posts = postService.findPostNotPublish();
        ResponseEntity<List<Post>> responseEntity = new ResponseEntity(posts, HttpStatus.OK);
        return responseEntity;
    }

}
