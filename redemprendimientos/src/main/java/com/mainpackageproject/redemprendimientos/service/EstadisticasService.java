package com.mainpackageproject.redemprendimientos.service;

import com.mainpackageproject.redemprendimientos.repository.InformacionEmprendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.*;

/**
 * Servicio para gestionar las estadísticas relacionadas con los emprendimientos.
 * Proporciona métodos para obtener estadísticas como el total de emprendimientos,
 * emprendimientos por categoría, región y género.
 */
@Service
public class EstadisticasService {

    @Autowired
    private InformacionEmprendimientoRepository emprendimientoRepository;

    @Autowired
    private EntityManager entityManager;

    /**
     * Obtiene el número total de emprendimientos registrados en el sistema.
     *
     * @return El número total de emprendimientos.
     */
    public Long obtenerTotalEmprendimientos() {
        return emprendimientoRepository.count();
    }

    /**
     * Obtiene la cantidad de emprendimientos agrupados por categoría.
     *
     * @return Una lista de objetos donde cada elemento contiene el nombre de la categoría
     *         y la cantidad de emprendimientos asociados.
     */
    @SuppressWarnings("unchecked")
    public List<Object[]> obtenerEmprendimientosPorCategoria() {
        String jpql = "SELECT e.categoria.nombre, COUNT(e) FROM InformacionEmprendimiento e GROUP BY e.categoria.nombre";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    /**
     * Obtiene la cantidad de emprendimientos agrupados por región.
     *
     * @return Una lista de objetos donde cada elemento contiene el nombre de la región
     *         y la cantidad de emprendimientos asociados.
     */
    @SuppressWarnings("unchecked")
    public List<Object[]> obtenerEmprendimientosPorRegion() {
        String jpql = "SELECT e.region.nombre, COUNT(e) FROM InformacionEmprendimiento e GROUP BY e.region.nombre";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    /**
     * Obtiene la cantidad de emprendimientos agrupados por género.
     *
     * @return Una lista de objetos donde cada elemento contiene el género
     *         y la cantidad de emprendimientos asociados.
     */
    @SuppressWarnings("unchecked")
    public List<Object[]> obtenerEmprendimientosPorGenero() {
        String jpql = "SELECT d.genero, COUNT(e) " +
                    "FROM InformacionEmprendimiento e " +
                    "JOIN DatosUsuario d ON e.usuario.idUsuario = d.usuario.idUsuario " +
                    "GROUP BY d.genero";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }
}