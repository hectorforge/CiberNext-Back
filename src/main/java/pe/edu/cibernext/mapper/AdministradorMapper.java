package pe.edu.cibernext.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.AdministradorEntity;
import pe.edu.cibernext.models.dto.AdministradorDto;

@Component
public class AdministradorMapper {

  //  private final PasswordEncoder passwordEncoder;

    public AdministradorEntity toEntity(AdministradorDto dto) {
        if (dto == null) return null;
        AdministradorEntity entity = new AdministradorEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setDni(dto.getDni());
        entity.setEmail(dto.getEmail());
        entity.setTelefono(dto.getTelefono());
        entity.setFotoPerfil(dto.getFotoPerfil());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public AdministradorDto toDto(AdministradorEntity entity, boolean includePassword) {
        if (entity == null) return null;
        AdministradorDto dto = new AdministradorDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setDni(entity.getDni());
        dto.setEmail(entity.getEmail());
        dto.setTelefono(entity.getTelefono());
        dto.setFotoPerfil(entity.getFotoPerfil());
        if (includePassword) {
            dto.setPassword(entity.getPassword());
        }
        return dto;
    }
}