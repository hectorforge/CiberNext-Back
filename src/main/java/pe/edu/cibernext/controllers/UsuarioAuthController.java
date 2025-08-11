package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.jwt.JwtUtil;
import pe.edu.cibernext.models.UsuarioEntity;
import pe.edu.cibernext.models.dto.auth.UsuarioPasswordDto;
import pe.edu.cibernext.models.dto.auth.UsuarioUpdateDto;
import pe.edu.cibernext.security.user.CustomUserDetails;
import pe.edu.cibernext.services.AuthService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsuarioAuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @GetMapping("/me")
    public ResponseEntity<?> getProfile(
            @AuthenticationPrincipal CustomUserDetails user) {

        System.out.println(user);

        return ResponseEntity.ok(Map.of(
                "nombre",user.getUsuario().getNombre(),
                "apellido",user.getUsuario().getApellido(),
                "nombreCompleto", user.getUsuarioCompleto(),
                "email", user.getUsuario().getEmail(),
                "dni", user.getUsuario().getDni(),
                "roles", user.getUsuario().getRoles()
        ));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProfile(
            @AuthenticationPrincipal CustomUserDetails user,
            @RequestBody UsuarioUpdateDto dto) {
        try {
            UsuarioEntity updated = authService.updateProfile(user.getUsuario().getEmail(), dto);

            // Generar nuevo token con los datos actualizados
            Map<String, Object> claims = new HashMap<>();
            claims.put("roles", updated.getRoles());
            String newToken = jwtUtil.generateToken(updated.getEmail(), claims);

            return ResponseEntity.ok(Map.of(
                    "message", "Perfil actualizado con éxito",
                    "usuario", updated,
                    "token", newToken
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", e.getMessage())
            );
        }
    }


    @PutMapping("/update/password")
    public ResponseEntity<?> changePassword(
            @AuthenticationPrincipal CustomUserDetails user,
            @RequestBody UsuarioPasswordDto dto) {
        try {
            authService.changePassword(user.getUsuario().getEmail(), dto);
            return ResponseEntity.ok(
                    java.util.Map.of("message", "Contraseña actualizada con éxito")
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                    java.util.Map.of("error", e.getMessage())
            );
        }
    }
}