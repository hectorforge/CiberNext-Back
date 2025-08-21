package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.DocumentoDto;
import pe.edu.cibernext.services.DocumentoService;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService documentoService;

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoDto> obtenerPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(documentoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<DocumentoDto>> listarTodos() {
        return ResponseEntity.ok(documentoService.listarTodos());
    }

    @GetMapping("/unidad/{unidadId}")
    public ResponseEntity<List<DocumentoDto>> listarPorUnidad(@PathVariable Long unidadId) {
        return ResponseEntity.ok(documentoService.listarPorUnidad(unidadId));
    }


    @PostMapping
    public ResponseEntity<DocumentoDto> registrar(@RequestBody DocumentoDto dto) {
        return ResponseEntity.ok(documentoService.registrar(dto));
    }


}





