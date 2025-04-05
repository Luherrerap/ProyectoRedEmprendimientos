package com.mainpackageproject.redemprendimientos.repository;

import com.mainpackageproject.redemprendimientos.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de la entidad Comentario.
 * Proporciona métodos para realizar consultas personalizadas relacionadas con los comentarios.
 */
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

    /**
     * Obtiene una lista de comentarios realizados por un usuario específico.
     *
     * @param idUsuario ID del usuario cuyos comentarios se desean obtener.
     * @return Una lista de comentarios asociados al usuario.
     */
    List<Comentario> findByUsuario_IdUsuario(Integer idUsuario);

    /**
     * Obtiene una lista de comentarios asociados a una publicación específica.
     *
     * @param idPublicacion ID de la publicación cuyos comentarios se desean obtener.
     * @return Una lista de comentarios asociados a la publicación.
     */
    List<Comentario> findByPublicaciones_IdPublicaciones(Integer idPublicacion);
}
