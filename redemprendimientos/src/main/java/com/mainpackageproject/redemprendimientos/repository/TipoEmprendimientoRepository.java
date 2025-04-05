package com.mainpackageproject.redemprendimientos.repository;

import com.mainpackageproject.redemprendimientos.models.TipoEmprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de la entidad TipoEmprendimiento.
 * Proporciona métodos básicos de CRUD para los tipos de emprendimiento registrados en el sistema.
 */
@Repository
public interface TipoEmprendimientoRepository extends JpaRepository<TipoEmprendimiento, Integer> {

}
