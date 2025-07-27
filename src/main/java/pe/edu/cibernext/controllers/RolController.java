package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.RolConUsuariosDto;
import pe.edu.cibernext.models.dto.RolDto;
import pe.edu.cibernext.services.RolService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {

    @Autowired
    RolService rolService;


    @GetMapping("/ListarRoles")
    public ResponseEntity<List<RolDto>> listarTodos() {
        return ResponseEntity.ok(rolService.listarTodos());
    }

    @GetMapping("/ListarRolesConUsuarios")
    public ResponseEntity<List<RolConUsuariosDto>> listarConUsuarios() {
        return ResponseEntity.ok(rolService.listarRolesConUsuarios());
    }

    @GetMapping("/BuscarRol/{id}")
    public ResponseEntity<RolConUsuariosDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rolService.buscarPorId(id));
    }

    @PostMapping("/RegistrarRol")
    public ResponseEntity<RolDto> registrar(@RequestBody RolDto dto) {
        return ResponseEntity.ok(rolService.registrar(dto));
    }

    @PutMapping("/ActualizarRol")
    public ResponseEntity<RolDto> actualizar(@RequestBody RolDto dto) {
        return ResponseEntity.ok(rolService.actualizar(dto));
    }

    @DeleteMapping("/EliminarRol/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rolService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
