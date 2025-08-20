package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.AdministradorDto;
import pe.edu.cibernext.services.AdministradorService;
import java.util.List;

@RestController
@RequestMapping("/api/administradores")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorService service;

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<AdministradorDto>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<AdministradorDto> registrar(@RequestBody AdministradorDto dto) {
        return ResponseEntity.ok(service.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministradorDto> actualizar(@PathVariable Long id, @RequestBody AdministradorDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.actualizar(dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        service.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<AdministradorDto>> buscarPorFiltro(@RequestParam String filtro) {
        return ResponseEntity.ok(service.buscarPorFiltro(filtro));
    }
}
