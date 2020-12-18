package com.informatori.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Post {

    private Integer post_id;

    private String titulo;
    private String descripcion;
    private String contenido;
    private LocalDate fecha_creacion;
    private Usuario autor;
    private boolean publicado;
    private List<Comentario> comment;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }
    @Column
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Column
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Column
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    @Column
    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    @ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
    @Column
    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "post")
    public List<Comentario> getComment() {
        return comment;
    }

    public void setComment(List<Comentario> comment) {
        this.comment = comment;
    }
}
