package com.mainpackageproject.redemprendimientos.controllers;

import com.mainpackageproject.redemprendimientos.service.EstadisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.*;

/**
 * Controlador para gestionar las estadísticas relacionadas con los emprendimientos.
 * Proporciona endpoints para obtener estadísticas como el total de emprendimientos,
 * emprendimientos por categoría, región y género.
 */
@RestController
@RequestMapping("/api/estadisticas")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class EstadisticasController {

    @Autowired
    private EstadisticasService estadisticasService;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Obtiene el total de emprendimientos registrados en el sistema.
     *
     * @return El número total de emprendimientos.
     */
    @GetMapping("/total")
    public Long obtenerTotalEmprendimientos() {
        return estadisticasService.obtenerTotalEmprendimientos();
    }

    /**
     * Obtiene la cantidad de emprendimientos agrupados por categoría.
     *
     * @return Una lista de objetos donde cada elemento contiene el nombre de la categoría
     *         y la cantidad de emprendimientos asociados.
     */
    @GetMapping("/por-categoria")
    public List<Object[]> obtenerEmprendimientosPorCategoria() {
        String jpql = "SELECT e.tipoEmprendimiento.nombreTipoEmprendimiento, COUNT(e) " +
                        "FROM InformacionEmprendimiento e " +
                        "GROUP BY e.tipoEmprendimiento.nombreTipoEmprendimiento";
        return entityManager.createQuery(jpql, Object[].class).getResultList();
    }

    /**
     * Obtiene la cantidad de emprendimientos agrupados por región.
     *
     * @return Una lista de objetos donde cada elemento contiene el nombre de la región
     *         y la cantidad de emprendimientos asociados.
     */
    @GetMapping("/por-region")
    public List<Object[]> obtenerEmprendimientosPorRegion() {
        String jpql = "SELECT e.region.nombreRegion, COUNT(e) " +
                        "FROM InformacionEmprendimiento e " +
                        "GROUP BY e.region.nombreRegion";
        return entityManager.createQuery(jpql, Object[].class).getResultList();
    }

    /**
     * Obtiene la cantidad de emprendimientos agrupados por género.
     *
     * @return Una lista de mapas donde cada mapa contiene el género y la cantidad de emprendimientos asociados.
     */
    @GetMapping("/por-genero")
    public List<Map<String, Object>> obtenerEmprendimientosPorGenero() {
        List<Object[]> results = estadisticasService.obtenerEmprendimientosPorGenero();
        List<Map<String, Object>> response = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> item = new HashMap<>();
            item.put("genero", result[0]);
            item.put("cantidad", result[1]);
            response.add(item);
        }
        return response;
    }
}

