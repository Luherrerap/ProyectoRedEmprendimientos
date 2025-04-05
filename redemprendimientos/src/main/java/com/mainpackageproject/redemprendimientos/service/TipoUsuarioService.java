package com.mainpackageproject.redemprendimientos.service;

import com.mainpackageproject.redemprendimientos.models.TipoUsuario;
import com.mainpackageproject.redemprendimientos.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para gestionar las operaciones relacionadas con los tipos de usuario.
 * Proporciona métodos para obtener todos los tipos de usuario registrados en el sistema.
 */
@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    /**
     * Obtiene todos los tipos de usuario registrados en el sistema.
     *
     * @return Una lista de todos los tipos de usuario.
     */
    public List<TipoUsuario> obtenerTodosLosTipos() {
        return tipoUsuarioRepository.findAll();
    }
}
