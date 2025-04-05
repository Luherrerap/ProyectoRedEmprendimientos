package com.mainpackageproject.redemprendimientos.controllers;

import com.mainpackageproject.redemprendimientos.models.Comentario;
import com.mainpackageproject.redemprendimientos.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con los comentarios.
 * Proporciona endpoints para crear, obtener, editar y eliminar comentarios.
 */
@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier frontend
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    /**
     * Crea un nuevo comentario asociado a un usuario y un emprendimiento.
     *
     * @param idUsuario          ID del usuario que realiza el comentario.
     * @param idEmprendimiento   ID del emprendimiento al que pertenece el comentario.
     * @param comentario          Objeto con los datos del comentario a crear.
     * @return El comentario creado.
     */
    @PostMapping("/usuario/{idUsuario}/emprendimiento/{idEmprendimiento}")
    public Comentario crearComentario(@PathVariable Integer idUsuario,
                                        @PathVariable Integer idEmprendimiento,
                                        @RequestBody Comentario comentario) {
        return comentarioService.crearComentario(idUsuario, idEmprendimiento, comentario);
    }

    /**
     * Obtiene todos los comentarios registrados.
     *
     * @return Una lista de todos los comentarios.
     */
    @GetMapping
    public List<Comentario> obtenerTodosComentarios() {
        return comentarioService.obtenerTodosComentarios();
    }

    /**
     * Obtiene los comentarios realizados por un usuario específico.
     *
     * @param idUsuario ID del usuario cuyos comentarios se desean obtener.
     * @return Una lista de comentarios realizados por el usuario.
     */
    @GetMapping("/usuario/{idUsuario}")
    public List<Comentario> obtenerComentariosPorUsuario(@PathVariable Integer idUsuario) {
        return comentarioService.obtenerComentariosPorUsuario(idUsuario);
    }

    /**
     * Obtiene los comentarios asociados a una publicación específica.
     *
     * @param idPublicacion ID de la publicación cuyos comentarios se desean obtener.
     * @return Una lista de comentarios asociados a la publicación.
     */
    @GetMapping("/publicacion/{idPublicacion}")
    public List<Comentario> obtenerComentariosPorPublicacion(@PathVariable Integer idPublicacion) {
        return comentarioService.obtenerComentariosPorPublicacion(idPublicacion);
    }

    /**
     * Edita un comentario existente.
     *
     * @param idComentario    ID del comentario a editar.
     * @param nuevoComentario Objeto con los nuevos datos del comentario.
     * @return El comentario actualizado.
     */
    @PutMapping("/{idComentario}")
    public Comentario editarComentario(@PathVariable Integer idComentario,
                                        @RequestBody Comentario nuevoComentario) {
        return comentarioService.editarComentario(idComentario, nuevoComentario);
    }

    /**
     * Elimina un comentario existente.
     *
     * @param idComentario ID del comentario a eliminar.
     */
    @DeleteMapping("/{idComentario}")
    public void eliminarComentario(@PathVariable Integer idComentario) {
        comentarioService.eliminarComentario(idComentario);
    }
}

