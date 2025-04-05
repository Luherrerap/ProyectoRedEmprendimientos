package com.mainpackageproject.redemprendimientos.service;

import com.mainpackageproject.redemprendimientos.models.TipoUsuario;
import com.mainpackageproject.redemprendimientos.models.Usuario;
import com.mainpackageproject.redemprendimientos.repository.UsuarioRepository;
import com.mainpackageproject.redemprendimientos.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar las operaciones relacionadas con los usuarios.
 * Proporciona métodos para registrar, buscar, listar y eliminar usuarios.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    /**
     * Registra un nuevo usuario en el sistema.
     * Establece valores predeterminados como la fecha de creación, estado y tipo de usuario.
     * Además, encripta la contraseña antes de guardar.
     *
     * @param usuario Objeto con los datos del usuario a registrar.
     * @return El usuario registrado.
     * @throws RuntimeException Si el tipo de usuario por defecto no se encuentra.
     */
    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setActualizado(LocalDateTime.now());
        usuario.setEstadoUsuario((byte) 1);

        TipoUsuario tipoUsuarioDefault = tipoUsuarioRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Tipo de usuario con ID 1 no encontrado"));
        usuario.setTipoUsuario(tipoUsuarioDefault);

        usuario.setPasswordUsuario(passwordEncoder.encode(usuario.getPasswordUsuario()));

        return usuarioRepository.save(usuario);
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id ID del usuario a buscar.
     * @return Un Optional que contiene el usuario si existe, o vacío si no.
     */
    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email Correo electrónico del usuario a buscar.
     * @return Un Optional que contiene el usuario si existe, o vacío si no.
     */
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmailUsuario(email);
    }

    /**
     * Obtiene una lista de todos los usuarios registrados en el sistema.
     *
     * @return Una lista de usuarios.
     */
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id ID del usuario a eliminar.
     */
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
