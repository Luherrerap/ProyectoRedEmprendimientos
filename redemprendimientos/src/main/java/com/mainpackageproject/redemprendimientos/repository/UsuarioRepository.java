package com.mainpackageproject.redemprendimientos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.mainpackageproject.redemprendimientos.models.Usuario;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de la entidad Usuario.
 * Proporciona métodos básicos de CRUD y consultas personalizadas relacionadas con los usuarios.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email Correo electrónico del usuario a buscar.
     * @return Un Optional que contiene el usuario si existe, o vacío si no.
     */
    Optional<Usuario> findByEmailUsuario(String email);
}
