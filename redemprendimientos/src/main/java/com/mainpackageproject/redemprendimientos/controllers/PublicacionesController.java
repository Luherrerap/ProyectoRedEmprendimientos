package com.mainpackageproject.redemprendimientos.controllers;

import com.mainpackageproject.redemprendimientos.models.Publicaciones;
import com.mainpackageproject.redemprendimientos.service.PublicacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con las publicaciones.
 * Proporciona endpoints para crear, obtener, editar y eliminar publicaciones.
 */
@RestController
@RequestMapping("/api/publicaciones")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class PublicacionesController {

    @Autowired
    private PublicacionesService publicacionesService;

    /**
     * Crea una nueva publicación asociada a un emprendimiento.
     *
     * @param session           Sesión HTTP para obtener el ID del usuario autenticado.
     * @param idEmprendimiento  ID del emprendimiento al que pertenece la publicación.
     * @param publicacion       Objeto con los datos de la publicación a crear.
     * @return La publicación creada o un estado de error si ocurre un problema.
     */
    @PostMapping("/crear/{idEmprendimiento}")
    public ResponseEntity<Publicaciones> crearPublicacion(HttpSession session,
                                                            @PathVariable Integer idEmprendimiento,
                                                            @RequestBody Publicaciones publicacion) {
        Integer idUsuario = (Integer) session.getAttribute("userId");
        if (idUsuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        try {
            Publicaciones nuevaPublicacion = publicacionesService.crearPublicacion(idUsuario, idEmprendimiento, publicacion);
            return ResponseEntity.ok(nuevaPublicacion);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Obtiene todas las publicaciones asociadas a un emprendimiento.
     *
     * @param idEmprendimiento ID del emprendimiento cuyas publicaciones se desean obtener.
     * @return Una lista de publicaciones asociadas al emprendimiento.
     */
    @GetMapping("/emprendimiento/{idEmprendimiento}")
    public ResponseEntity<List<Publicaciones>> obtenerPorEmprendimiento(@PathVariable Integer idEmprendimiento) {
        List<Publicaciones> publicaciones = publicacionesService.obtenerPublicacionesPorEmprendimiento(idEmprendimiento);
        return ResponseEntity.ok(publicaciones);
    }

    /**
     * Obtiene todas las publicaciones realizadas por un usuario específico.
     *
     * @param idUsuario ID del usuario cuyas publicaciones se desean obtener.
     * @return Una lista de publicaciones realizadas por el usuario.
     */
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Publicaciones>> obtenerPorUsuario(@PathVariable Integer idUsuario) {
        List<Publicaciones> publicaciones = publicacionesService.obtenerPublicacionesPorUsuario(idUsuario);
        return ResponseEntity.ok(publicaciones);
    }

    /**
     * Edita una publicación existente.
     *
     * @param idPublicacion    ID de la publicación a editar.
     * @param nuevaPublicacion Objeto con los nuevos datos de la publicación.
     * @return La publicación actualizada o un estado 404 si no se encuentra.
     */
    @PutMapping("/editar/{idPublicacion}")
    public ResponseEntity<Publicaciones> editarPublicacion(@PathVariable Integer idPublicacion,
                                                            @RequestBody Publicaciones nuevaPublicacion) {
        try {
            Publicaciones publicacionEditada = publicacionesService.editarPublicacion(idPublicacion, nuevaPublicacion);
            return ResponseEntity.ok(publicacionEditada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina una publicación por su ID.
     *
     * @param idPublicacion ID de la publicación a eliminar.
     * @return Un estado 204 si se elimina correctamente.
     */
    @DeleteMapping("/eliminar/{idPublicacion}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable Integer idPublicacion) {
        publicacionesService.eliminarPublicacion(idPublicacion);
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtiene todas las publicaciones registradas en el sistema.
     *
     * @return Una lista de todas las publicaciones.
     */
    @GetMapping("/todas")
    public ResponseEntity<List<Publicaciones>> obtenerTodasPublicaciones() {
        List<Publicaciones> publicaciones = publicacionesService.obtenerTodasPublicaciones();
        return ResponseEntity.ok(publicaciones);
    }
}
