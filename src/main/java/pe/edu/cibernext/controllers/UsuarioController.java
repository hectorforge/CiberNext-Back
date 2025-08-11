package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.UsuarioDto;
import pe.edu.cibernext.models.dto.UsuarioRegistroDto;
import pe.edu.cibernext.services.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final  UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> registrarUsuario(@RequestBody UsuarioRegistroDto dto) {
        return ResponseEntity.ok(usuarioService.registrar(dto));
    }

    // TODO: Corregir la funcionalidad de este endpoint
    // Debe recibir un id de curricula en la url
    // para mantener la nomenclatura de los endpoints
    // @PutMapping("/{id}")
    @PutMapping("/actualizar")
    public ResponseEntity<UsuarioDto> actualizarUsuario(@RequestBody UsuarioDto dto) {
        return ResponseEntity.ok(usuarioService.actualizar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    // TODO: Corregir la funcionalidad de este endpoint
    // Debe recibir el string de búsqueda por POST
    // para mantener la nomenclatura de los endpoints
    //  @PostMapping("/buscar")
    @GetMapping("/buscarPorFiltro")
    public ResponseEntity<List<UsuarioDto>> buscarUsuariosPorFiltro(@RequestParam String filtro) {
        return ResponseEntity.ok(usuarioService.buscarPorFiltro(filtro));
    }
}
