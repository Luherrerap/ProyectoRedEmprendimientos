package com.mainpackageproject.redemprendimientos.repository;

import com.mainpackageproject.redemprendimientos.models.InformacionEmprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de la entidad InformacionEmprendimiento.
 * Proporciona métodos para realizar consultas personalizadas relacionadas con los emprendimientos.
 */
@Repository
public interface InformacionEmprendimientoRepository extends JpaRepository<InformacionEmprendimiento, Integer> {

    /**
     * Obtiene una lista de emprendimientos asociados a un usuario específico.
     *
     * @param idUsuario ID del usuario cuyos emprendimientos se desean obtener.
     * @return Una lista de emprendimientos asociados al usuario.
     */
    List<InformacionEmprendimiento> findByUsuario_IdUsuario(Integer idUsuario);

    /**
     * Obtiene una lista de emprendimientos asociados a un tipo específico.
     *
     * @param idTipoEmprendimiento ID del tipo de emprendimiento.
     * @return Una lista de emprendimientos asociados al tipo.
     */
    List<InformacionEmprendimiento> findByTipoEmprendimiento_IdTipoEmprendimiento(Integer idTipoEmprendimiento);

    /**
     * Obtiene una lista de emprendimientos asociados a una región específica.
     *
     * @param idRegion ID de la región cuyos emprendimientos se desean obtener.
     * @return Una lista de emprendimientos asociados a la región.
     */
    List<InformacionEmprendimiento> findByRegion_IdRegion(Integer idRegion);

    /**
     * Elimina todos los emprendimientos asociados a un usuario específico.
     *
     * @param idUsuario ID del usuario cuyos emprendimientos se desean eliminar.
     */
    void deleteByUsuario_IdUsuario(Integer idUsuario);
}
