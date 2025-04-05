package com.mainpackageproject.redemprendimientos.repository;

import com.mainpackageproject.redemprendimientos.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones de acceso a datos de la entidad Region.
 * Proporciona métodos básicos de CRUD para las regiones registradas en el sistema.
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

}
