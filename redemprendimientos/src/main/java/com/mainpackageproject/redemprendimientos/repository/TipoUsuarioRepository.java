package com.mainpackageproject.redemprendimientos.repository;

import com.mainpackageproject.redemprendimientos.models.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de la entidad TipoUsuario.
 * Proporciona métodos básicos de CRUD para los tipos de usuario registrados en el sistema.
 */
@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

}