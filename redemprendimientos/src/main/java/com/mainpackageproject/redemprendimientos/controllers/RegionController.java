package com.mainpackageproject.redemprendimientos.controllers;

import com.mainpackageproject.redemprendimientos.models.Region;
import com.mainpackageproject.redemprendimientos.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con las regiones.
 * Proporciona endpoints para obtener todas las regiones y buscar una región por su ID.
 */
@RestController
@RequestMapping("/api/regiones")
public class RegionController {

    @Autowired
    private RegionService regionService;

    /**
     * Obtiene todas las regiones registradas en el sistema.
     *
     * @return Una lista de todas las regiones.
     */
    @GetMapping
    public List<Region> obtenerTodasRegiones() {
        return regionService.getAllRegions();
    }

    /**
     * Obtiene una región específica por su ID.
     *
     * @param id ID de la región a buscar.
     * @return La región encontrada o null si no existe.
     */
    @GetMapping("/{id}")
    public Region obtenerRegionPorId(@PathVariable Integer id) {
        return regionService.getRegionById(id);
    }
}
