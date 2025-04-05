package com.mainpackageproject.redemprendimientos.controllers;

import com.mainpackageproject.redemprendimientos.models.TipoUsuario;
import com.mainpackageproject.redemprendimientos.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con los tipos de usuario.
 * Proporciona endpoints para obtener todos los tipos de usuario registrados en el sistema.
 */
@RestController
@RequestMapping("/api/tipousuario")
@CrossOrigin(origins = "*")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    /**
     * Obtiene todos los tipos de usuario registrados en el sistema.
     *
     * @return Una lista de todos los tipos de usuario.
     */
    @GetMapping
    public ResponseEntity<List<TipoUsuario>> obtenerTiposUsuario() {
        List<TipoUsuario> tipos = tipoUsuarioService.obtenerTodosLosTipos();
        return ResponseEntity.ok(tipos);
    }
}