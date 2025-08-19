package com.devoir.metier.service;

import com.devoir.metier.dto.ClasseDTO;
import java.util.List;

public interface ClasseService {
    List<ClasseDTO> getAllClasses();
    ClasseDTO getClasseById(int id);
    void addClasse(ClasseDTO dto);
    void updateClasse(ClasseDTO dto);
    void deleteClasse(int id);
}
