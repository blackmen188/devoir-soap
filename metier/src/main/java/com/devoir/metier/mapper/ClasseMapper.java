package com.devoir.metier.mapper;

import com.devoir.metier.dto.ClasseDTO;
import com.devoir.metier.entity.Classe;
import com.devoir.metier.entity.Sector;

public class ClasseMapper {
    public static ClasseDTO toDto(Classe classe) {
        return new ClasseDTO(
            classe.getId(),
            classe.getLibelle(),
            classe.getDescription(),
            classe.getSector().getId()
        );
    }

    public static Classe toEntity(ClasseDTO dto, Sector sector) {
        return new Classe(
            dto.getId(),
            dto.getLibelle(),
            dto.getDescription(),
            sector
        );
    }
}
