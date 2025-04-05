package com.mainpackageproject.redemprendimientos.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Entidad que representa una publicación en el sistema.
 * Incluye información como título, contenido, fecha de creación, imagen, estado,
 * y relaciones con un usuario y un emprendimiento.
 */
@Data
@Entity
@Table(name = "Publicaciones")
public class Publicaciones {

    /**
     * Identificador único de la publicación.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicaciones")
    private Integer idPublicaciones;

    /**
     * Título de la publicación.
     */
    @Column(name = "titulo_publicacion", nullable = false, length = 250)
    private String tituloPublicacion;

    /**
     * Contenido de la publicación.
     */
    @Column(name = "contenido_publicacion", nullable = false, columnDefinition = "MEDIUMTEXT")
    private String contenidoPublicacion;

    /**
     * Fecha de creación de la publicación.
     * Este campo no es actualizable.
     */
    @Column(name = "fecha_creacion_publicacion", updatable = false)
    private LocalDateTime fechaCreacionPublicacion;

    /**
     * URL de la imagen asociada a la publicación.
     */
    @Column(name = "imagen_publicacion", length = 255)
    private String imagenPublicacion;

    /**
     * Estado de la publicación (activo o inactivo).
     */
    @Column(name = "estado_publicacion")
    private Boolean estadoPublicacion;

    /**
     * Usuario que creó la publicación.
     * Relación muchos a uno con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    /**
     * Emprendimiento asociado a la publicación.
     * Relación muchos a uno con la entidad InformacionEmprendimiento.
     */
    @ManyToOne
    @JoinColumn(name = "id_emprendimiento", nullable = false)
    private InformacionEmprendimiento informacionEmprendimiento;

    /**
     * Método que se ejecuta antes de persistir la publicación.
     * Establece la fecha de creación y el estado por defecto.
     */
    @PrePersist
    protected void onCreate() {
        this.fechaCreacionPublicacion = LocalDateTime.now();
        this.estadoPublicacion = true;
    }
}
