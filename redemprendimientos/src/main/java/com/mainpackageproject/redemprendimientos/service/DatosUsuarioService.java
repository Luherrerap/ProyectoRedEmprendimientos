package com.mainpackageproject.redemprendimientos.service;

import com.mainpackageproject.redemprendimientos.models.DatosUsuario;
import com.mainpackageproject.redemprendimientos.models.Usuario;
import com.mainpackageproject.redemprendimientos.repository.DatosUsuarioRepository;
import com.mainpackageproject.redemprendimientos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar las operaciones relacionadas con los datos personales de los usuarios.
 * Proporciona métodos para crear, actualizar, consultar y eliminar datos de usuario.
 */
@Service
public class DatosUsuarioService {

    @Autowired
    private DatosUsuarioRepository datosUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Obtiene los datos personales asociados a un usuario específico.
     *
     * @param idUsuario ID del usuario cuyos datos se desean obtener.
     * @return Una lista de datos personales asociados al usuario.
     */
    public List<DatosUsuario> obtenerDatosPorIdUsuario(Integer idUsuario) {
        return datosUsuarioRepository.findByUsuario_IdUsuario(idUsuario);
    }

    /**
     * Crea o actualiza los datos personales de un usuario.
     *
     * @param datosUsuario Objeto con los datos personales a guardar.
     * @param idUsuario    ID del usuario al que se asociarán los datos.
     * @return Los datos personales guardados o actualizados.
     * @throws RuntimeException Si el usuario no se encuentra.
     */
    public DatosUsuario guardarDatosUsuario(DatosUsuario datosUsuario, Integer idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (usuarioOptional.isPresent()) {
            datosUsuario.setUsuario(usuarioOptional.get());
            return datosUsuarioRepository.save(datosUsuario);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    /**
     * Actualiza los datos personales existentes de un usuario.
     *
     * @param idDatosUsuario ID de los datos personales a actualizar.
     * @param nuevosDatos    Objeto con los nuevos datos personales.
     * @return Los datos personales actualizados.
     * @throws RuntimeException Si los datos personales no se encuentran.
     */
    public DatosUsuario actualizarDatosUsuario(Integer idDatosUsuario, DatosUsuario nuevosDatos) {
        Optional<DatosUsuario> existente = datosUsuarioRepository.findById(idDatosUsuario);
        if (existente.isPresent()) {
            DatosUsuario datos = existente.get();
            datos.setNombreUsuario(nuevosDatos.getNombreUsuario());
            datos.setApellidosUsuario(nuevosDatos.getApellidosUsuario());
            datos.setBiografiaUsuario(nuevosDatos.getBiografiaUsuario());
            datos.setPaisUsuario(nuevosDatos.getPaisUsuario());
            datos.setEtnia(nuevosDatos.getEtnia());
            datos.setGenero(nuevosDatos.getGenero());
            datos.setRegion(nuevosDatos.getRegion());
            return datosUsuarioRepository.save(datos);
        } else {
            throw new RuntimeException("DatosUsuario no encontrado");
        }
    }

    /**
     * Elimina los datos personales de un usuario por su ID.
     *
     * @param idDatosUsuario ID de los datos personales a eliminar.
     */
    public void eliminarDatosUsuario(Integer idDatosUsuario) {
        datosUsuarioRepository.deleteById(idDatosUsuario);
    }
}
