package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.UsuarioDto;
import pe.edu.cibernext.services.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/ObtenerUsuarioPorId/{id}")
    public ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @GetMapping("/ListarUsuarios")
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @PostMapping("/RegistrarUsuario")
    public ResponseEntity<UsuarioDto> registrarUsuario(@RequestBody UsuarioDto dto) {
        return ResponseEntity.ok(usuarioService.registrar(dto));
    }

    @PutMapping("/ActualizarUsuario")
    public ResponseEntity<UsuarioDto> actualizarUsuario(@RequestBody UsuarioDto dto) {
        return ResponseEntity.ok(usuarioService.actualizar(dto));
    }

    @DeleteMapping("/EliminarUsuarioPorId/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/BuscarUsuariosPorFiltro")
    public ResponseEntity<List<UsuarioDto>> buscarUsuariosPorFiltro(@RequestParam String filtro) {
        return ResponseEntity.ok(usuarioService.buscarPorFiltro(filtro));
    }
}
