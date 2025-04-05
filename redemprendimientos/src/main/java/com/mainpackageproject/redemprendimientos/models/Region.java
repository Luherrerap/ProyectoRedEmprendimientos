package com.mainpackageproject.redemprendimientos.models;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa una región en el sistema.
 * Las regiones están asociadas a los emprendimientos y usuarios.
 */
@Data
@Entity
@Table(name = "Region")
public class Region {

    /**
     * Identificador único de la región.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_region")
    private Integer idRegion;

    /**
     * Nombre de la región.
     */
    @Column(name = "nombre_region", nullable = false, length = 100)
    private String nombreRegion;
}
