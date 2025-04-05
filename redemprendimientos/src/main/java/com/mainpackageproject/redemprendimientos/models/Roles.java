package com.mainpackageproject.redemprendimientos.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Entidad que representa los roles en el sistema.
 * Los roles están asociados a los usuarios y definen permisos o niveles de acceso.
 */
@Data
@Entity
@Table(name = "Roles")
public class Roles {

    /**
     * Identificador único del rol.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles")
    private Integer idRoles;

    /**
     * Nombre del rol.
     */
    @Column(name = "nombre_rol", nullable = false, length = 255)
    private String nombreRol;

    /**
     * Fecha en la que se creó el rol.
     */
    @Column(name = "fecha_creado", nullable = false)
    private LocalDateTime fechaCreado;

    /**
     * Fecha de la última modificación del rol.
     */
    @Column(name = "modificado", nullable = false)
    private LocalDateTime modificado;

    /**
     * Usuario asociado al rol.
     * Relación muchos a uno con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
