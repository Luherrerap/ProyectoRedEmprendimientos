package com.mainpackageproject.redemprendimientos.controllers;

import com.mainpackageproject.redemprendimientos.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import com.mainpackageproject.redemprendimientos.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

/**
 * Controlador para gestionar las operaciones relacionadas con los usuarios.
 * Proporciona endpoints para registrar, buscar, listar, eliminar usuarios y manejar sesiones.
 */
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param userData Mapa con los datos del usuario, incluyendo email y contraseña.
     * @return El usuario registrado o un error en caso de fallo.
     */
    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Map<String, String> userData) {
        try {
            String email = userData.get("email");
            String password = userData.get("password");

            Usuario usuario = new Usuario();
            usuario.setEmailUsuario(email);
            usuario.setPasswordUsuario(password);

            Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);

            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id ID del usuario a buscar.
     * @return El usuario encontrado o un estado 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Busca un usuario por su email.
     *
     * @param email Email del usuario a buscar.
     * @return El usuario encontrado o un estado 404 si no existe.
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> obtenerUsuarioPorEmail(@PathVariable String email) {
        Optional<Usuario> usuario = usuarioService.buscarPorEmail(email);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Lista todos los usuarios registrados en el sistema.
     *
     * @return Una lista de usuarios.
     */
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id ID del usuario a eliminar.
     * @return Un estado 204 si se elimina correctamente o 404 si no se encuentra.
     */
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        if (usuarioService.buscarPorId(id).isPresent()) {
            usuarioService.eliminarUsuario(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Inicia sesión para un usuario.
     *
     * @param loginData Mapa con los datos de inicio de sesión (email y contraseña).
     * @param session   Sesión HTTP para almacenar los datos del usuario.
     * @return Un mensaje de éxito con los datos del usuario o un error en caso de fallo.
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> loginData, HttpSession session) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        Optional<Usuario> existingUsuario = usuarioService.buscarPorEmail(email);
        if (existingUsuario.isPresent() && passwordEncoder.matches(password, existingUsuario.get().getPasswordUsuario())) {
            session.setAttribute("userId", existingUsuario.get().getIdUsuario());
            session.setAttribute("email", existingUsuario.get().getEmailUsuario());

            Map<String, String> response = new HashMap<>();
            response.put("message", "Inicio de sesión exitoso");
            response.put("userId", existingUsuario.get().getIdUsuario().toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>(Map.of("error", "email o contraseña inválidos"), HttpStatus.UNAUTHORIZED);
    }

    /**
     * Cierra la sesión del usuario actual.
     *
     * @param session Sesión HTTP a invalidar.
     * @return Un estado 204 si se cierra correctamente.
     */
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.invalidate();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Obtiene los datos del usuario actualmente autenticado.
     *
     * @param session Sesión HTTP para obtener los datos del usuario.
     * @return Un mapa con los datos del usuario o un estado 401 si no está autenticado.
     */
    @GetMapping("/current-user")
    public ResponseEntity<Map<String, Object>> getCurrentUser(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        String email = (String) session.getAttribute("email");

        if (userId != null && email != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("userId", userId);
            response.put("email", email);
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}