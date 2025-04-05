package com.mainpackageproject.redemprendimientos.controllers;

import com.mainpackageproject.redemprendimientos.models.DatosUsuario;
import com.mainpackageproject.redemprendimientos.service.DatosUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Controlador para gestionar las operaciones relacionadas con los datos de usuario.
 * Proporciona endpoints para obtener, crear, actualizar y eliminar datos de perfil de usuario.
 */
@RestController
@RequestMapping("/api/datosusuario")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class DatosUsuarioController {

    @Autowired
    private DatosUsuarioService datosUsuarioService;

    /**
     * Obtiene los datos de usuario asociados a un ID de usuario específico.
     *
     * @param idUsuario ID del usuario cuyos datos se desean obtener.
     * @return Una lista de datos de usuario asociados al ID proporcionado.
     */
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<DatosUsuario>> obtenerDatosPorUsuario(@PathVariable Integer idUsuario) {
        List<DatosUsuario> datos = datosUsuarioService.obtenerDatosPorIdUsuario(idUsuario);
        return ResponseEntity.ok(datos != null ? datos : new ArrayList<>());
    }

    /**
     * Crea o actualiza el perfil de usuario asociado a un ID de usuario.
     *
     * @param datosUsuario Objeto con los datos del perfil de usuario a guardar.
     * @param idUsuario    ID del usuario al que se asociarán los datos.
     * @return Los datos de usuario guardados o actualizados.
     */
    @PostMapping("/guardar/{idUsuario}")
    public ResponseEntity<DatosUsuario> guardarDatosUsuario(@RequestBody DatosUsuario datosUsuario,
                                                            @PathVariable Integer idUsuario) {
        try {
            DatosUsuario datosGuardados = datosUsuarioService.guardarDatosUsuario(datosUsuario, idUsuario);
            return ResponseEntity.ok(datosGuardados);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Actualiza los datos de un perfil de usuario existente.
     *
     * @param idDatosUsuario ID de los datos de usuario a actualizar.
     * @param nuevosDatos    Objeto con los nuevos datos del perfil de usuario.
     * @return Los datos de usuario actualizados o un estado 404 si no se encuentran.
     */
    @PutMapping("/actualizar/{idDatosUsuario}")
    public ResponseEntity<DatosUsuario> actualizarDatosUsuario(@PathVariable Integer idDatosUsuario,
                                                                @RequestBody DatosUsuario nuevosDatos) {
        try {
            DatosUsuario actualizados = datosUsuarioService.actualizarDatosUsuario(idDatosUsuario, nuevosDatos);
            return ResponseEntity.ok(actualizados);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina los datos de un perfil de usuario por su ID.
     *
     * @param idDatosUsuario ID de los datos de usuario a eliminar.
     * @return Un estado 204 si se elimina correctamente.
     */
    @DeleteMapping("/eliminar/{idDatosUsuario}")
    public ResponseEntity<Void> eliminarDatosUsuario(@PathVariable Integer idDatosUsuario) {
        datosUsuarioService.eliminarDatosUsuario(idDatosUsuario);
        return ResponseEntity.noContent().build();
    }
}
