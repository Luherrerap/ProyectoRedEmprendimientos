package com.mainpackageproject.redemprendimientos.controllers;

import com.mainpackageproject.redemprendimientos.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gestionar las operaciones relacionadas con los likes.
 * Proporciona endpoints para agregar, quitar y obtener el número de likes en emprendimientos y publicaciones.
 */
@RestController
@RequestMapping("/api/likes")
@CrossOrigin(origins = "*")
public class LikeController {

    @Autowired
    private LikeService likeService;

    /**
     * Agrega o quita un like a un emprendimiento.
     *
     * @param idEmprendimiento ID del emprendimiento al que se le agregará o quitará el like.
     * @param idUsuario        ID del usuario que realiza la acción.
     * @return Un mensaje indicando si se agregó o quitó el like.
     */
    @PostMapping("/emprendimiento/{idEmprendimiento}/usuario/{idUsuario}")
    public String toggleLikeEmprendimiento(@PathVariable Integer idEmprendimiento, @PathVariable Integer idUsuario) {
        return likeService.toggleLikeEmprendimiento(idUsuario, idEmprendimiento);
    }

    /**
     * Agrega o quita un like a una publicación.
     *
     * @param idPublicacion ID de la publicación a la que se le agregará o quitará el like.
     * @param idUsuario     ID del usuario que realiza la acción.
     * @return Un mensaje indicando si se agregó o quitó el like.
     */
    @PostMapping("/publicacion/{idPublicacion}/usuario/{idUsuario}")
    public String toggleLikePublicacion(@PathVariable Integer idPublicacion, @PathVariable Integer idUsuario) {
        return likeService.toggleLikePublicacion(idUsuario, idPublicacion);
    }

    /**
     * Obtiene el número de likes de un emprendimiento.
     *
     * @param idEmprendimiento ID del emprendimiento cuyos likes se desean obtener.
     * @return El número de likes del emprendimiento.
     */
    @GetMapping("/emprendimiento/{idEmprendimiento}")
    public Integer obtenerLikesEmprendimiento(@PathVariable Integer idEmprendimiento) {
        return likeService.obtenerLikesEmprendimiento(idEmprendimiento);
    }

    /**
     * Obtiene el número de likes de una publicación.
     *
     * @param idPublicacion ID de la publicación cuyos likes se desean obtener.
     * @return El número de likes de la publicación.
     */
    @GetMapping("/publicacion/{idPublicacion}")
    public Integer obtenerLikesPublicacion(@PathVariable Integer idPublicacion) {
        return likeService.obtenerLikesPublicacion(idPublicacion);
    }
}
