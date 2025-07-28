package pe.edu.cibernext.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<Object> manejarRecursoNoEncontrado(RecursoNoEncontradoException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("mensaje", ex.getMessage());
        body.put("codigo", "NOT_FOUND");
        body.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    // Opcional: otros errores generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> manejarErroresGenerales(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("mensaje", "Error interno del servidor");
        body.put("codigo", "INTERNAL_ERROR");
        body.put("detalles", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}