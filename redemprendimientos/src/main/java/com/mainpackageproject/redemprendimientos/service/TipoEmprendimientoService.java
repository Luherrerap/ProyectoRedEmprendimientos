package com.mainpackageproject.redemprendimientos.service;

import com.mainpackageproject.redemprendimientos.models.TipoEmprendimiento;
import com.mainpackageproject.redemprendimientos.repository.TipoEmprendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para gestionar las operaciones relacionadas con los tipos de emprendimiento.
 * Proporciona métodos para obtener todos los tipos de emprendimiento y buscar uno por su ID.
 */
@Service
public class TipoEmprendimientoService {

    @Autowired
    private TipoEmprendimientoRepository tipoEmprendimientoRepository;

    /**
     * Obtiene todos los tipos de emprendimiento registrados en el sistema.
     *
     * @return Una lista de todos los tipos de emprendimiento.
     */
    public List<TipoEmprendimiento> getAllTiposEmprendimiento() {
        return tipoEmprendimientoRepository.findAll();
    }

    /**
     * Obtiene un tipo de emprendimiento específico por su ID.
     *
     * @param id ID del tipo de emprendimiento a buscar.
     * @return El tipo de emprendimiento encontrado o null si no existe.
     */
    public TipoEmprendimiento getTipoEmprendimientoById(Integer id) {
        return tipoEmprendimientoRepository.findById(id)
                .orElse(null);
    }
}
