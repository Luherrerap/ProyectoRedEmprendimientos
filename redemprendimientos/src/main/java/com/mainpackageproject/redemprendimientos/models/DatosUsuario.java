package com.mainpackageproject.redemprendimientos.models;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa los datos personales de un usuario en el sistema.
 * Incluye información como nombre, apellidos, biografía, país, etnia y género.
 * Está asociada a un usuario y a una región específica.
 */
@Data
@Entity
@Table(name = "Datos_usuario")
public class DatosUsuario {

    /**
     * Identificador único de los datos del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_datos_usuario")
    private Integer idDatosUsuario;

    /**
     * Nombre del usuario.
     */
    @Column(name = "nombre_usuario", nullable = false, length = 100)
    private String nombreUsuario;

    /**
     * Apellidos del usuario.
     */
    @Column(name = "apellidos_usuario", nullable = false, length = 100)
    private String apellidosUsuario;

    /**
     * Biografía del usuario.
     */
    @Column(name = "biografia_usuario", columnDefinition = "MEDIUMTEXT")
    private String biografiaUsuario;

    /**
     * País de residencia del usuario.
     */
    @Column(name = "pais_usuario", nullable = false, length = 45)
    private String paisUsuario;

    /**
     * Etnia del usuario.
     */
    @Column(name = "etnia", length = 100)
    private String etnia;

    /**
     * Género del usuario.
     */
    @Column(name = "genero", length = 100)
    private String genero;

    /**
     * Usuario al que pertenecen estos datos.
     * Relación muchos a uno con la entidad Usuario.
     */
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    /**
     * Región asociada al usuario.
     * Relación muchos a uno con la entidad Región.
     */
    @ManyToOne
    @JoinColumn(name = "id_region", nullable = false)
    private Region region;
}
