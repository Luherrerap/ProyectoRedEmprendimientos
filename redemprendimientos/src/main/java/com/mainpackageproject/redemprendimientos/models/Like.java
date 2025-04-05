package com.mainpackageproject.redemprendimientos.models;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa un "like" en el sistema.
 * Los likes pueden estar asociados a un usuario, un emprendimiento o una publicación.
 */
@Data
@Entity
@Table(name = "likes")
public class Like {

    /**
     * Identificador único del like.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_like")
    private Integer idLike;

    /**
     * Usuario que realizó el like.
     * Relación muchos a uno con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    /**
     * Emprendimiento al que se le dio el like (opcional).
     * Relación muchos a uno con la entidad InformacionEmprendimiento.
     */
    @ManyToOne
    @JoinColumn(name = "id_informacion_emprendimiento")
    private InformacionEmprendimiento informacionEmprendimiento;

    /**
     * Publicación a la que se le dio el like (opcional).
     * Relación muchos a uno con la entidad Publicaciones.
     */
    @ManyToOne
    @JoinColumn(name = "id_publicaciones")
    private Publicaciones publicaciones;
}
