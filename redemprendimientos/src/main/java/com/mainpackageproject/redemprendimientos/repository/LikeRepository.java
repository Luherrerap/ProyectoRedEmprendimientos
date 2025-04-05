package com.mainpackageproject.redemprendimientos.repository;

import com.mainpackageproject.redemprendimientos.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de la entidad Like.
 * Proporciona métodos para realizar consultas personalizadas relacionadas con los likes.
 */
@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {

        /**
        * Obtiene la cantidad de likes asociados a un emprendimiento específico.
        *
        * @param idEmprendimiento ID del emprendimiento cuyos likes se desean contar.
        * @return El número de likes asociados al emprendimiento.
        */
        Integer countByInformacionEmprendimiento_IdInformacionEmprendimiento(Integer idEmprendimiento);

        /**
         * Obtiene la cantidad de likes asociados a una publicación específica.
        *
        * @param idPublicacion ID de la publicación cuyos likes se desean contar.
        * @return El número de likes asociados a la publicación.
        */
        Integer countByPublicaciones_IdPublicaciones(Integer idPublicacion);

        /**
        * Verifica si un usuario específico ya dio like a un emprendimiento.
        *
        * @param idUsuario       ID del usuario.
        * @param idEmprendimiento ID del emprendimiento.
        * @return Un Optional que contiene el like si existe, o vacío si no.
        */
        Optional<Like> findByUsuario_IdUsuarioAndInformacionEmprendimiento_IdInformacionEmprendimiento(Integer idUsuario, Integer idEmprendimiento);

        /**
        * Verifica si un usuario específico ya dio like a una publicación.
        *
        * @param idUsuario     ID del usuario.
        * @param idPublicacion ID de la publicación.
        * @return Un Optional que contiene el like si existe, o vacío si no.
        */
        Optional<Like> findByUsuario_IdUsuarioAndPublicaciones_IdPublicaciones(Integer idUsuario, Integer idPublicacion);
}
