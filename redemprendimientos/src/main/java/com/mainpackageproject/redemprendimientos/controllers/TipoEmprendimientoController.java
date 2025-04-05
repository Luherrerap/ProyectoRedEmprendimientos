package com.mainpackageproject.redemprendimientos.controllers;

import com.mainpackageproject.redemprendimientos.models.TipoEmprendimiento;
import com.mainpackageproject.redemprendimientos.service.TipoEmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con los tipos de emprendimiento.
 * Proporciona endpoints para obtener todos los tipos de emprendimiento y buscar uno por su ID.
 */
@RestController
@RequestMapping("/api/tipos-emprendimiento")
@CrossOrigin(origins = "*")
public class TipoEmprendimientoController {

    @Autowired
    private TipoEmprendimientoService tipoEmprendimientoService;

    /**
     * Obtiene todos los tipos de emprendimiento registrados en el sistema.
     *
     * @return Una lista de todos los tipos de emprendimiento.
     */
    @GetMapping
    public List<TipoEmprendimiento> obtenerTodos() {
        return tipoEmprendimientoService.getAllTiposEmprendimiento();
    }

    /**
     * Obtiene un tipo de emprendimiento específico por su ID.
     *
     * @param id ID del tipo de emprendimiento a buscar.
     * @return El tipo de emprendimiento encontrado o null si no existe.
     */
    @GetMapping("/{id}")
    public TipoEmprendimiento obtenerPorId(@PathVariable Integer id) {
        return tipoEmprendimientoService.getTipoEmprendimientoById(id);
    }
}

