package com.mainpackageproject.redemprendimientos.models;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa un tipo de usuario en el sistema.
 * Los tipos de usuario definen roles o categorías para los usuarios registrados.
 */
@Entity
@Table(name = "Tipo_usuario")
@Data
public class TipoUsuario {

    /**
     * Identificador único del tipo de usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
    private int idTipoUsuario;

    /**
     * Nombre del tipo de usuario.
     */
    @Column(name = "nombre_tipo", nullable = false, length = 50)
    private String nombreTipoUsuario;

    /**
     * Descripción del tipo de usuario.
     */
    @Column(name = "descripcion", columnDefinition = "TINYTEXT")
    private String descripcionTipoUsuario;

    /**
     * Estado del tipo de usuario (activo o inactivo).
     */
    @Column(name = "estado_tipo_usuario")
    private Integer estadoTipoUsuario;
}
