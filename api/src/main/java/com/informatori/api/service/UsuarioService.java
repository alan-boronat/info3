package com.informatori.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.informatori.api.model.Usuario;
import com.informatori.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUser (Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteUser (Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    public Usuario updateUser (Usuario usuario){
        Usuario usuario1 = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuario.getNombre()!=null){
            usuario1.setNombre(usuario.getNombre());
        }
        if (usuario.getApellido()!=null){
            usuario1.setApellido(usuario.getApellido());
        }
        if (usuario.getPassword()!=null){
            usuario1.setPassword(usuario.getPassword());
        }
        if (usuario.getCiudad()!=null){
            usuario1.setCiudad(usuario.getCiudad());
        }
        if (usuario.getProvincia()!=null){
            usuario1.setProvincia(usuario.getProvincia());
        }
        if (usuario.getPais()!=null){
            usuario1.setPais(usuario.getPais());
        }
        return usuarioRepository.save(usuario1);
    }
    public List<Usuario> findUser (){
        return usuarioRepository.findAll();
    }
    public List<Usuario> findUserRcia (){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<Usuario> usuariosRcia = new ArrayList<>();
        for (Usuario usuario: usuarios) {
            if (usuario.getCiudad().toUpperCase().equals("RESISTENCIA")){
                usuariosRcia.add(usuario);
            }
        }
        return usuariosRcia;
    }
    public List<Usuario> findByDate (String date){
        return usuarioRepository.findUserByDate(date);
    }
}
