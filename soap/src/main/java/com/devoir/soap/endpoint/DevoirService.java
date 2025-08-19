package com.devoir.soap.endpoint;

import com.devoir.metier.dto.ClasseDTO;
import com.devoir.metier.dto.SectorDTO;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface DevoirService {
    List<ClasseDTO> getAllClasses();
    ClasseDTO getClasseById(int id);
    void addClasse(ClasseDTO dto);
    void updateClasse(ClasseDTO dto);
    void deleteClasse(int id);
    
    List<SectorDTO> getAllSectors();
    SectorDTO getSectorById(int id);
    void addSector(SectorDTO dto);
    void updateSector(SectorDTO dto);
    void deleteSector(int id);
}
