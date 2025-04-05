package com.mainpackageproject.redemprendimientos.repository;

import com.mainpackageproject.redemprendimientos.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de la entidad Roles.
 * Proporciona métodos básicos de CRUD para los roles registrados en el sistema.
 */
@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
