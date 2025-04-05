package com.mainpackageproject.redemprendimientos.service;

import com.mainpackageproject.redemprendimientos.models.Region;
import com.mainpackageproject.redemprendimientos.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Servicio para gestionar las operaciones relacionadas con las regiones.
 * Proporciona métodos para obtener todas las regiones y buscar una región por su ID.
 */
@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    /**
     * Obtiene todas las regiones registradas en el sistema.
     *
     * @return Una lista de todas las regiones.
     */
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    /**
     * Obtiene una región específica por su ID.
     *
     * @param id ID de la región a buscar.
     * @return La región encontrada o null si no existe.
     */
    public Region getRegionById(Integer id) {
        return regionRepository.findById(id)
                .orElse(null); // Puedes manejar con excepción si prefieres
    }
}
