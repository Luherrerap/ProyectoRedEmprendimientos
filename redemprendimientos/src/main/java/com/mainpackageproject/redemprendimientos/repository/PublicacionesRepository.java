package com.mainpackageproject.redemprendimientos.repository;

import com.mainpackageproject.redemprendimientos.models.Publicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de la entidad Publicaciones.
 * Proporciona métodos para realizar consultas personalizadas relacionadas con las publicaciones.
 */
@Repository
public interface PublicacionesRepository extends JpaRepository<Publicaciones, Integer> {

    /**
     * Obtiene una lista de publicaciones realizadas por un usuario específico.
     *
     * @param idUsuario ID del usuario cuyas publicaciones se desean obtener.
     * @return Una lista de publicaciones asociadas al usuario.
     */
    List<Publicaciones> findByUsuario_IdUsuario(Integer idUsuario);

    /**
     * Obtiene una lista de publicaciones asociadas a un emprendimiento específico.
     *
     * @param idEmprendimiento ID del emprendimiento cuyas publicaciones se desean obtener.
     * @return Una lista de publicaciones asociadas al emprendimiento.
     */
    List<Publicaciones> findByInformacionEmprendimiento_IdInformacionEmprendimiento(Integer idEmprendimiento);
}


