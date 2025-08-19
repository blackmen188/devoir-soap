package com.devoir.metier.service;

import com.devoir.metier.dto.SectorDTO;
import java.util.List;

public interface SectorService {
    List<SectorDTO> getAllSectors();
    SectorDTO getSectorById(int id);
    void addSector(SectorDTO dto);
    void updateSector(SectorDTO dto);
    void deleteSector(int id);
}
