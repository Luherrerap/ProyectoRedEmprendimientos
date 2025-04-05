package com.mainpackageproject.redemprendimientos.service;

import com.mainpackageproject.redemprendimientos.models.InformacionEmprendimiento;
import com.mainpackageproject.redemprendimientos.repository.InformacionEmprendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar las operaciones relacionadas con la información de los emprendimientos.
 * Proporciona métodos para crear, actualizar, consultar y eliminar emprendimientos.
 */
@Service
public class InformacionEmprendimientoService {

    @Autowired
    private InformacionEmprendimientoRepository infoEmprendimientoRepository;

    /**
     * Crea o actualiza un emprendimiento.
     * Si la fecha de creación o el estado no están definidos, se asignan valores por defecto.
     *
     * @param emprendimiento Objeto con los datos del emprendimiento a guardar o actualizar.
     * @return El emprendimiento guardado o actualizado.
     */
    public InformacionEmprendimiento guardarOActualizar(InformacionEmprendimiento emprendimiento) {
        if (emprendimiento.getFechaCreacionEmprendimiento() == null) {
            emprendimiento.setFechaCreacionEmprendimiento(LocalDateTime.now());
        }
        if (emprendimiento.getEstadoEmprendimiento() == null) {
            emprendimiento.setEstadoEmprendimiento(true);
        }
        return infoEmprendimientoRepository.save(emprendimiento);
    }

    /**
     * Obtiene todos los emprendimientos registrados en el sistema.
     *
     * @return Una lista de todos los emprendimientos.
     */
    public List<InformacionEmprendimiento> obtenerTodos() {
        return infoEmprendimientoRepository.findAll();
    }

    /**
     * Busca un emprendimiento por su ID.
     *
     * @param id ID del emprendimiento a buscar.
     * @return Un Optional que contiene el emprendimiento si existe, o vacío si no.
     */
    public Optional<InformacionEmprendimiento> obtenerPorId(Integer id) {
        return infoEmprendimientoRepository.findById(id);
    }

    /**
     * Elimina un emprendimiento por su ID.
     *
     * @param id ID del emprendimiento a eliminar.
     */
    public void eliminarPorId(Integer id) {
        infoEmprendimientoRepository.deleteById(id);
    }

    /**
     * Obtiene los emprendimientos asociados a una región específica.
     *
     * @param idRegion ID de la región cuyos emprendimientos se desean obtener.
     * @return Una lista de emprendimientos asociados a la región.
     */
    public List<InformacionEmprendimiento> obtenerPorRegion(Integer idRegion) {
        return infoEmprendimientoRepository.findByRegion_IdRegion(idRegion);
    }

    /**
     * Obtiene los emprendimientos asociados a un tipo específico.
     *
     * @param idTipo ID del tipo de emprendimiento a buscar.
     * @return Una lista de emprendimientos asociados al tipo.
     */
    public List<InformacionEmprendimiento> obtenerPorTipo(Integer idTipo) {
        return infoEmprendimientoRepository.findByTipoEmprendimiento_IdTipoEmprendimiento(idTipo);
    }

    /**
     * Obtiene los emprendimientos asociados a un usuario específico.
     *
     * @param idUsuario ID del usuario cuyos emprendimientos se desean obtener.
     * @return Una lista de emprendimientos asociados al usuario.
     */
    public List<InformacionEmprendimiento> obtenerPorUsuario(Integer idUsuario) {
        return infoEmprendimientoRepository.findByUsuario_IdUsuario(idUsuario);
    }
}
