package com.informatori.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.informatori.api.model.Usuario;
import com.informatori.api.service.UsuarioService;


@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping ("createuser")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario){
        usuarioService.createUser(usuario);
        ResponseEntity <String> responseEntity = new ResponseEntity("usuario creado", HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("deleteuser")
    public ResponseEntity<String> eliminarUsuario (@RequestBody Usuario usuario) {
        usuarioService.deleteUser(usuario);
        ResponseEntity<String> responseEntity = new ResponseEntity("usuario eliminado", HttpStatus.OK);
        return responseEntity;
    }
    @PutMapping ("edituser")
    public ResponseEntity<Usuario> editarUsuarios(@RequestBody Usuario usuario) {
        Usuario usuario1 = usuarioService.updateUser(usuario);
        ResponseEntity<Usuario> responseEntity = new ResponseEntity(usuario1, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping ("showusers")
    public ResponseEntity<List<Usuario>> mostrarUsuarios() {
        List<Usuario> usuarios = usuarioService.findUser();
        ResponseEntity<List<Usuario>> responseEntity = new ResponseEntity(usuarios, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping ("usersbycity")
    public ResponseEntity<List<Usuario>> usuariosRcia() {
        List<Usuario> usuarios = usuarioService.findUserRcia();
        ResponseEntity<List<Usuario>> responseEntity = new ResponseEntity(usuarios, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping ("usersbydate")
    public ResponseEntity<List<Usuario>> usuariosPorFecha(@RequestParam String date) {
        List<Usuario> usuarios = usuarioService.findByDate(date);
        ResponseEntity<List<Usuario>> responseEntity = new ResponseEntity(usuarios, HttpStatus.OK);
        return responseEntity;
    }
}
