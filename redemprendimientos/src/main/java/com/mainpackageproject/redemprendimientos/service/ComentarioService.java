package com.mainpackageproject.redemprendimientos.service;

import com.mainpackageproject.redemprendimientos.models.Comentario;
import com.mainpackageproject.redemprendimientos.models.Usuario;
import com.mainpackageproject.redemprendimientos.models.InformacionEmprendimiento;
import com.mainpackageproject.redemprendimientos.repository.ComentarioRepository;
import com.mainpackageproject.redemprendimientos.repository.UsuarioRepository;
import com.mainpackageproject.redemprendimientos.repository.InformacionEmprendimientoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar las operaciones relacionadas con los comentarios.
 * Proporciona métodos para crear, obtener, editar y eliminar comentarios.
 */
@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private InformacionEmprendimientoRepository emprendimientoRepository;

    /**
     * Crea un nuevo comentario asociado a un usuario y un emprendimiento.
     *
     * @param idUsuario        ID del usuario que realiza el comentario.
     * @param idEmprendimiento ID del emprendimiento al que pertenece el comentario.
     * @param comentario       Objeto con los datos del comentario a crear.
     * @return El comentario creado.
     * @throws RuntimeException Si el usuario o el emprendimiento no se encuentran.
     */
    public Comentario crearComentario(Integer idUsuario, Integer idEmprendimiento, Comentario comentario) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        Optional<InformacionEmprendimiento> emprendimientoOpt = emprendimientoRepository.findById(idEmprendimiento);

        if (usuarioOpt.isPresent() && emprendimientoOpt.isPresent()) {
            comentario.setUsuario(usuarioOpt.get());
            comentario.setFechaComentario(LocalDateTime.now());
            return comentarioRepository.save(comentario);
        } else {
            throw new RuntimeException("Usuario o Emprendimiento no encontrado");
        }
    }

    /**
     * Obtiene los comentarios asociados a una publicación específica.
     *
     * @param idPublicacion ID de la publicación cuyos comentarios se desean obtener.
     * @return Una lista de comentarios asociados a la publicación.
     */
    public List<Comentario> obtenerComentariosPorPublicacion(Integer idPublicacion) {
        return comentarioRepository.findByPublicaciones_IdPublicaciones(idPublicacion);
    }

    /**
     * Obtiene los comentarios realizados por un usuario específico.
     *
     * @param idUsuario ID del usuario cuyos comentarios se desean obtener.
     * @return Una lista de comentarios realizados por el usuario.
     */
    public List<Comentario> obtenerComentariosPorUsuario(Integer idUsuario) {
        return comentarioRepository.findByUsuario_IdUsuario(idUsuario);
    }

    /**
     * Edita un comentario existente.
     *
     * @param idComentario    ID del comentario a editar.
     * @param nuevoComentario Objeto con los nuevos datos del comentario.
     * @return El comentario actualizado.
     * @throws RuntimeException Si el comentario no se encuentra.
     */
    public Comentario editarComentario(Integer idComentario, Comentario nuevoComentario) {
        Optional<Comentario> comentarioOpt = comentarioRepository.findById(idComentario);

        if (comentarioOpt.isPresent()) {
            Comentario comentario = comentarioOpt.get();
            comentario.setContenidoComentario(nuevoComentario.getContenidoComentario());
            return comentarioRepository.save(comentario);
        } else {
            throw new RuntimeException("Comentario no encontrado");
        }
    }

    /**
     * Elimina un comentario por su ID.
     *
     * @param idComentario ID del comentario a eliminar.
     */
    public void eliminarComentario(Integer idComentario) {
        comentarioRepository.deleteById(idComentario);
    }

    /**
     * Obtiene todos los comentarios registrados en el sistema.
     *
     * @return Una lista de todos los comentarios.
     */
    public List<Comentario> obtenerTodosComentarios() {
        return comentarioRepository.findAll();
    }
}
