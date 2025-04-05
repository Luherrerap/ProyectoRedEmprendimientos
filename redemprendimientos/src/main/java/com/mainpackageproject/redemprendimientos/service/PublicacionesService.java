package com.mainpackageproject.redemprendimientos.service;

import com.mainpackageproject.redemprendimientos.models.Publicaciones;
import com.mainpackageproject.redemprendimientos.models.Usuario;
import com.mainpackageproject.redemprendimientos.models.InformacionEmprendimiento;
import com.mainpackageproject.redemprendimientos.repository.PublicacionesRepository;
import com.mainpackageproject.redemprendimientos.repository.UsuarioRepository;
import com.mainpackageproject.redemprendimientos.repository.InformacionEmprendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar las operaciones relacionadas con las publicaciones.
 * Proporciona métodos para crear, obtener, editar y eliminar publicaciones.
 */
@Service
public class PublicacionesService {

    @Autowired
    private PublicacionesRepository publicacionesRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private InformacionEmprendimientoRepository emprendimientoRepository;

    /**
     * Crea una nueva publicación asociada a un usuario y un emprendimiento.
     *
     * @param idUsuario        ID del usuario que crea la publicación.
     * @param idEmprendimiento ID del emprendimiento al que pertenece la publicación.
     * @param publicacion      Objeto con los datos de la publicación a crear.
     * @return La publicación creada.
     * @throws RuntimeException Si el usuario o el emprendimiento no se encuentran.
     */
    public Publicaciones crearPublicacion(Integer idUsuario, Integer idEmprendimiento, Publicaciones publicacion) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        Optional<InformacionEmprendimiento> emprendimientoOpt = emprendimientoRepository.findById(idEmprendimiento);

        if (usuarioOpt.isPresent() && emprendimientoOpt.isPresent()) {
            publicacion.setUsuario(usuarioOpt.get());
            publicacion.setInformacionEmprendimiento(emprendimientoOpt.get());
            publicacion.setFechaCreacionPublicacion(LocalDateTime.now());
            publicacion.setEstadoPublicacion(true);
            return publicacionesRepository.save(publicacion);
        } else {
            throw new RuntimeException("Usuario o Emprendimiento no encontrado");
        }
    }

    /**
     * Obtiene una lista de publicaciones asociadas a un emprendimiento específico.
     *
     * @param idEmprendimiento ID del emprendimiento cuyas publicaciones se desean obtener.
     * @return Una lista de publicaciones asociadas al emprendimiento.
     */
    public List<Publicaciones> obtenerPublicacionesPorEmprendimiento(Integer idEmprendimiento) {
        return publicacionesRepository.findByInformacionEmprendimiento_IdInformacionEmprendimiento(idEmprendimiento);
    }

    /**
     * Obtiene una lista de publicaciones realizadas por un usuario específico.
     *
     * @param idUsuario ID del usuario cuyas publicaciones se desean obtener.
     * @return Una lista de publicaciones realizadas por el usuario.
     */
    public List<Publicaciones> obtenerPublicacionesPorUsuario(Integer idUsuario) {
        return publicacionesRepository.findByUsuario_IdUsuario(idUsuario);
    }

    /**
     * Edita una publicación existente.
     *
     * @param idPublicacion    ID de la publicación a editar.
     * @param nuevaPublicacion Objeto con los nuevos datos de la publicación.
     * @return La publicación actualizada.
     * @throws RuntimeException Si la publicación no se encuentra.
     */
    public Publicaciones editarPublicacion(Integer idPublicacion, Publicaciones nuevaPublicacion) {
        Optional<Publicaciones> publicacionOpt = publicacionesRepository.findById(idPublicacion);

        if (publicacionOpt.isPresent()) {
            Publicaciones publicacion = publicacionOpt.get();
            publicacion.setContenidoPublicacion(nuevaPublicacion.getContenidoPublicacion());
            publicacion.setTituloPublicacion(nuevaPublicacion.getTituloPublicacion());
            return publicacionesRepository.save(publicacion);
        } else {
            throw new RuntimeException("Publicación no encontrada");
        }
    }

    /**
     * Elimina una publicación por su ID.
     *
     * @param idPublicacion ID de la publicación a eliminar.
     */
    public void eliminarPublicacion(Integer idPublicacion) {
        publicacionesRepository.deleteById(idPublicacion);
    }

    /**
     * Obtiene todas las publicaciones registradas en el sistema.
     *
     * @return Una lista de todas las publicaciones.
     */
    public List<Publicaciones> obtenerTodasPublicaciones() {
        return publicacionesRepository.findAll();
    }
}
