package com.mainpackageproject.redemprendimientos.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Entidad que representa un usuario en el sistema.
 * Incluye información como email, contraseña, fecha de creación, estado y tipo de usuario.
 */
@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

    /**
     * Identificador único del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    /**
     * Correo electrónico del usuario.
     */
    @Column(name = "email_usuario", nullable = false, unique = true, length = 100)
    private String emailUsuario;

    /**
     * Contraseña del usuario.
     */
    @Column(name = "password_usuario", nullable = false, length = 100)
    private String passwordUsuario;

    /**
     * Fecha de creación del usuario.
     */
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    /**
     * Fecha de la última actualización del usuario.
     */
    @Column(name = "actualizado")
    private LocalDateTime actualizado;

    /**
     * Estado del usuario (activo o inactivo).
     */
    @Column(name = "estado_usuario")
    private Byte estadoUsuario;

    /**
     * Tipo de usuario asociado.
     * Relación muchos a uno con la entidad TipoUsuario.
     */
    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;
}
