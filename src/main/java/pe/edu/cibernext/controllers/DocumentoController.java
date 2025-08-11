package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.DocumentoDto;
import pe.edu.cibernext.models.dto.DocumentoRespuestaDto;
import pe.edu.cibernext.services.DocumentoService;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService documentoService;

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoRespuestaDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(documentoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<DocumentoRespuestaDto>> listarTodos() {
        return ResponseEntity.ok(documentoService.listarTodos());
    }

    //TODO: Este endpoint debe estar en el controlador de Unidad
    // y debe recibir un id de unidad en la url
    // para mantener la nomenclatura de los endpoints
    // @GetMapping("/unidad/{unidadId}/documentos")
    @GetMapping("/listarPorUnidad/{unidadId}")
    public ResponseEntity<List<DocumentoRespuestaDto>> listarPorUnidad(@PathVariable Long unidadId) {
        return ResponseEntity.ok(documentoService.listarPorUnidad(unidadId));
    }


    @PostMapping
    public ResponseEntity<DocumentoDto> registrar(@RequestBody DocumentoDto dto) {
        return ResponseEntity.ok(documentoService.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoDto> actualizar(@RequestBody DocumentoDto dto) {
        return ResponseEntity.ok(documentoService.actualizar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        documentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

// TODO: Falta implementar
// - Subir documento (endpoint para subir un archivo y asociarlo a un curso, unidad de aprendizaje,
// - Lista de documentos por curso
// - Descargar documento (endpoint para descargar el archivo del documento)
