package com.mainpackageproject.redemprendimientos.repository;

import com.mainpackageproject.redemprendimientos.models.DatosUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de la entidad DatosUsuario.
 * Proporciona métodos para realizar consultas personalizadas relacionadas con los datos de usuario.
 */
@Repository
public interface DatosUsuarioRepository extends JpaRepository<DatosUsuario, Integer> {

    /**
     * Obtiene una lista de datos de usuario asociados a un usuario específico.
     *
     * @param idUsuario ID del usuario cuyos datos se desean obtener.
     * @return Una lista de datos de usuario asociados al usuario.
     */
    List<DatosUsuario> findByUsuario_IdUsuario(Integer idUsuario);

}
