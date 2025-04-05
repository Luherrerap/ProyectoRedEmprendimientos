package com.mainpackageproject.redemprendimientos.models;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa un tipo de emprendimiento en el sistema.
 * Los tipos de emprendimiento clasifican los diferentes proyectos registrados.
 */
@Data
@Entity
@Table(name = "Tipo_emprendimiento")
public class TipoEmprendimiento {

    /**
     * Identificador único del tipo de emprendimiento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_emprendimiento")
    private Integer idTipoEmprendimiento;

    /**
     * Nombre del tipo de emprendimiento.
     */
    @Column(name = "nombre_tipo_emprendimiento", nullable = false, length = 100)
    private String nombreTipoEmprendimiento;
}
