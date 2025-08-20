package com.devoir.soap.endpoint;

import com.devoir.metier.dto.ClasseDTO;
import com.devoir.metier.dto.SectorDTO;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface DevoirService {
    List<ClasseDTO> getAllClasses();
    ClasseDTO getClasseById(int id);
    ClasseDTO addClasse(ClasseDTO dto);
    ClasseDTO updateClasse(ClasseDTO dto);
    void deleteClasse(int id);
    
    List<SectorDTO> getAllSectors();
    SectorDTO getSectorById(int id);
    SectorDTO addSector(SectorDTO dto);
    SectorDTO updateSector(SectorDTO dto);
    void deleteSector(int id);
}
