package com.mainpackageproject.redemprendimientos.controllers;

import com.mainpackageproject.redemprendimientos.models.InformacionEmprendimiento;
import com.mainpackageproject.redemprendimientos.service.InformacionEmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador para gestionar las operaciones relacionadas con la información de los emprendimientos.
 * Proporciona endpoints para crear, actualizar, obtener y eliminar emprendimientos.
 */
@RestController
@RequestMapping("/api/emprendimientos")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class InformacionEmprendimientoController {

    @Autowired
    private InformacionEmprendimientoService infoEmprendimientoService;

    /**
     * Crea o actualiza un emprendimiento.
     *
     * @param emprendimiento Objeto con los datos del emprendimiento a guardar o actualizar.
     * @return El emprendimiento guardado o actualizado.
     */
    @PostMapping("/guardar")
    public ResponseEntity<InformacionEmprendimiento> guardarOActualizar(@RequestBody InformacionEmprendimiento emprendimiento) {
        InformacionEmprendimiento nuevoEmprendimiento = infoEmprendimientoService.guardarOActualizar(emprendimiento);
        return ResponseEntity.ok(nuevoEmprendimiento);
    }

    /**
     * Obtiene todos los emprendimientos registrados.
     *
     * @return Una lista de todos los emprendimientos.
     */
    @GetMapping("/todos")
    public ResponseEntity<List<InformacionEmprendimiento>> obtenerTodos() {
        List<InformacionEmprendimiento> lista = infoEmprendimientoService.obtenerTodos();
        return ResponseEntity.ok(lista);
    }

    /**
     * Obtiene un emprendimiento por su ID.
     *
     * @param id ID del emprendimiento a buscar.
     * @return El emprendimiento encontrado o un estado 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<InformacionEmprendimiento> obtenerPorId(@PathVariable Integer id) {
        Optional<InformacionEmprendimiento> emprendimiento = infoEmprendimientoService.obtenerPorId(id);
        return emprendimiento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Elimina un emprendimiento por su ID.
     *
     * @param id ID del emprendimiento a eliminar.
     * @return Un estado 204 si se elimina correctamente.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Integer id) {
        infoEmprendimientoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtiene los emprendimientos asociados a una región específica.
     *
     * @param idRegion ID de la región cuyos emprendimientos se desean obtener.
     * @return Una lista de emprendimientos asociados a la región.
     */
    @GetMapping("/region/{idRegion}")
    public ResponseEntity<List<InformacionEmprendimiento>> obtenerPorRegion(@PathVariable Integer idRegion) {
        List<InformacionEmprendimiento> lista = infoEmprendimientoService.obtenerPorRegion(idRegion);
        return ResponseEntity.ok(lista);
    }

    /**
     * Obtiene los emprendimientos asociados a un tipo específico.
     *
     * @param idTipo ID del tipo de emprendimiento a buscar.
     * @return Una lista de emprendimientos asociados al tipo.
     */
    @GetMapping("/tipo/{idTipo}")
    public ResponseEntity<List<InformacionEmprendimiento>> obtenerPorTipo(@PathVariable Integer idTipo) {
        List<InformacionEmprendimiento> lista = infoEmprendimientoService.obtenerPorTipo(idTipo);
        return ResponseEntity.ok(lista);
    }

    /**
     * Obtiene los emprendimientos asociados a un usuario específico.
     *
     * @param idUsuario ID del usuario cuyos emprendimientos se desean obtener.
     * @return Una lista de emprendimientos asociados al usuario.
     */
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<InformacionEmprendimiento>> obtenerPorUsuario(@PathVariable Integer idUsuario) {
        List<InformacionEmprendimiento> lista = infoEmprendimientoService.obtenerPorUsuario(idUsuario);
        return ResponseEntity.ok(lista);
    }
}

