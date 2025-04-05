package com.mainpackageproject.redemprendimientos.service;

import com.mainpackageproject.redemprendimientos.models.Like;
import com.mainpackageproject.redemprendimientos.repository.LikeRepository;
import com.mainpackageproject.redemprendimientos.repository.UsuarioRepository;
import com.mainpackageproject.redemprendimientos.repository.InformacionEmprendimientoRepository;
import com.mainpackageproject.redemprendimientos.repository.PublicacionesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Servicio para gestionar las operaciones relacionadas con los likes.
 * Proporciona métodos para agregar, quitar y consultar likes en emprendimientos y publicaciones.
 */
@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private InformacionEmprendimientoRepository emprendimientoRepository;

    @Autowired
    private PublicacionesRepository publicacionesRepository;

    /**
     * Agrega o quita un like a un emprendimiento.
     *
     * @param idUsuario        ID del usuario que realiza la acción.
     * @param idEmprendimiento ID del emprendimiento al que se le agregará o quitará el like.
     * @return Un mensaje indicando si se agregó o quitó el like.
     */
    public String toggleLikeEmprendimiento(Integer idUsuario, Integer idEmprendimiento) {
        Optional<Like> likeOpt = likeRepository.findByUsuario_IdUsuarioAndInformacionEmprendimiento_IdInformacionEmprendimiento(idUsuario, idEmprendimiento);

        if (likeOpt.isPresent()) {
            likeRepository.delete(likeOpt.get());
            return "Like removido del emprendimiento.";
        } else {
            Like like = new Like();
            like.setUsuario(usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
            like.setInformacionEmprendimiento(emprendimientoRepository.findById(idEmprendimiento).orElseThrow(() -> new RuntimeException("Emprendimiento no encontrado")));
            likeRepository.save(like);
            return "Like agregado al emprendimiento.";
        }
    }

    /**
     * Agrega o quita un like a una publicación.
     *
     * @param idUsuario     ID del usuario que realiza la acción.
     * @param idPublicacion ID de la publicación a la que se le agregará o quitará el like.
     * @return Un mensaje indicando si se agregó o quitó el like.
     */
    public String toggleLikePublicacion(Integer idUsuario, Integer idPublicacion) {
        Optional<Like> likeOpt = likeRepository.findByUsuario_IdUsuarioAndPublicaciones_IdPublicaciones(idUsuario, idPublicacion);

        if (likeOpt.isPresent()) {
            likeRepository.delete(likeOpt.get());
            return "Like removido de la publicación.";
        } else {
            Like like = new Like();
            like.setUsuario(usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
            like.setPublicaciones(publicacionesRepository.findById(idPublicacion).orElseThrow(() -> new RuntimeException("Publicación no encontrada")));
            likeRepository.save(like);
            return "Like agregado a la publicación.";
        }
    }

    /**
     * Obtiene el número de likes asociados a un emprendimiento.
     *
     * @param idEmprendimiento ID del emprendimiento cuyos likes se desean consultar.
     * @return El número de likes asociados al emprendimiento.
     */
    public Integer obtenerLikesEmprendimiento(Integer idEmprendimiento) {
        return likeRepository.countByInformacionEmprendimiento_IdInformacionEmprendimiento(idEmprendimiento);
    }

    /**
     * Obtiene el número de likes asociados a una publicación.
     *
     * @param idPublicacion ID de la publicación cuyos likes se desean consultar.
     * @return El número de likes asociados a la publicación.
     */
    public Integer obtenerLikesPublicacion(Integer idPublicacion) {
        return likeRepository.countByPublicaciones_IdPublicaciones(idPublicacion);
    }
}
