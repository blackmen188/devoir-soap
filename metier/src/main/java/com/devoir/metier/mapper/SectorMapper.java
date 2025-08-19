package com.devoir.metier.mapper;

import com.devoir.metier.dto.SectorDTO;
import com.devoir.metier.entity.Sector;

public class SectorMapper {
    public static SectorDTO toDto(Sector sector) {
        return new SectorDTO(
            sector.getId(),
            sector.getNom()
        );
    }

    public static Sector toEntity(SectorDTO dto) {
        return new Sector(
            dto.getId(),
            dto.getNom()
        );
    }
}
