package pe.edu.cibernext.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibernext.jwt.JwtUtil;
import pe.edu.cibernext.models.UsuarioEntity;
import pe.edu.cibernext.models.dto.auth.UsuarioLoginDto;
import pe.edu.cibernext.models.dto.auth.UsuarioRegisterDto;
import pe.edu.cibernext.services.AuthService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDto request) {
        try {
            UsuarioEntity usuario = authService.login(request);
            Map<String, Object> claims = new HashMap<>();
            claims.put("roles", usuario.getRoles().stream().map(e -> e.getNombre()).toList());
            String token = jwtUtil.generateToken(usuario.getEmail(), claims);
            return ResponseEntity.ok(Map.of("token", token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UsuarioRegisterDto dto) {
        try {
            UsuarioEntity nuevoUsuario = authService.register(dto);
            return ResponseEntity.ok(Map.of(
                    "message", "Usuario registrado. Revisa tu correo para obtener tu contraseña inicial",
                    "usuario", nuevoUsuario.getEmail()
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok(Map.of("message", "Sesion cerrada con éxito"));
    }
}