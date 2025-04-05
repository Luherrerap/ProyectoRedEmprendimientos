package com.mainpackageproject.redemprendimientos.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Entidad que representa un comentario en el sistema.
 * Los comentarios están asociados a un usuario y a una publicación.
 */
@Data
@Entity
@Table(name = "Comentario")
public class Comentario {

    /**
     * Identificador único del comentario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Integer idComentario;

    /**
     * Contenido del comentario.
     */
    @Column(name = "contenido", columnDefinition = "MEDIUMTEXT")
    private String contenidoComentario;

    /**
     * Fecha en la que se realizó el comentario.
     */
    @Column(name = "fecha_comentario")
    private LocalDateTime fechaComentario;

    /**
     * Usuario que realizó el comentario.
     * Relación muchos a uno con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    /**
     * Publicación a la que pertenece el comentario.
     * Relación muchos a uno con la entidad Publicaciones.
     */
    @ManyToOne
    @JoinColumn(name = "id_publicaciones", nullable = false)
    private Publicaciones publicaciones;
}
