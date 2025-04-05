package com.mainpackageproject.redemprendimientos.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Entidad que representa la información de un emprendimiento en el sistema.
 * Incluye detalles como nombre, descripción, imagen, fecha de creación, estado,
 * tipo de emprendimiento, usuario asociado y región.
 */
@Data
@Entity
@Table(name = "Informacion_emprendimiento")
public class InformacionEmprendimiento {

    /**
     * Identificador único de la información del emprendimiento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informacion_emprendimiento")
    private Integer idInformacionEmprendimiento;

    /**
     * Nombre del emprendimiento.
     */
    @Column(name = "nombre_emprendimiento", nullable = false, length = 100)
    private String nombreEmprendimiento;

    /**
     * Descripción del emprendimiento.
     */
    @Column(name = "descripcion_emprendimiento", nullable = false, columnDefinition = "MEDIUMTEXT")
    private String descripcionEmprendimiento;

    /**
     * URL de la imagen asociada al emprendimiento.
     */
    @Column(name = "imagen_emprendimiento_url", length = 255)
    private String imagenEmprendimientoUrl;

    /**
     * Fecha de creación del emprendimiento.
     */
    @Column(name = "fecha_creacion_emprendimiento")
    private LocalDateTime fechaCreacionEmprendimiento;

    /**
     * Estado del emprendimiento (activo o inactivo).
     */
    @Column(name = "estado_emprendimiento")
    private Boolean estadoEmprendimiento;

    /**
     * Tipo de emprendimiento asociado.
     * Relación muchos a uno con la entidad TipoEmprendimiento.
     */
    @ManyToOne
    @JoinColumn(name = "id_tipo_emprendimiento", nullable = false)
    private TipoEmprendimiento tipoEmprendimiento;

    /**
     * Usuario asociado al emprendimiento.
     * Relación muchos a uno con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    /**
     * Región asociada al emprendimiento.
     * Relación muchos a uno con la entidad Región.
     */
    @ManyToOne
    @JoinColumn(name = "id_region", nullable = false)
    private Region region;
}
