package com.devoir.metier.service;

import com.devoir.metier.dao.ClasseDao;
import com.devoir.metier.dao.SectorDao;
import com.devoir.metier.dto.ClasseDTO;
import com.devoir.metier.entity.Classe;
import com.devoir.metier.entity.Sector;
import com.devoir.metier.exception.NotFoundException;
import com.devoir.metier.mapper.ClasseMapper;
import java.util.List;
import java.util.stream.Collectors;

public class ClasseServiceImpl implements ClasseService {
    private final ClasseDao classeDao;
    private final SectorDao sectorDao;

    public ClasseServiceImpl(ClasseDao classeDao, SectorDao sectorDao) {
        this.classeDao = classeDao;
        this.sectorDao = sectorDao;
    }

    @Override
    public List<ClasseDTO> getAllClasses() {
        return classeDao.findAll().stream()
                .map(ClasseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClasseDTO getClasseById(int id) {
        Classe classe = classeDao.findById(id);
        if (classe == null) {
            throw new NotFoundException("Classe non trouvé id: " + id);
        }
        return ClasseMapper.toDto(classe);
    }

    @Override
    public void addClasse(ClasseDTO dto) {
        Sector sector = sectorDao.findById(dto.getSectorId());
        if (sector == null) {
            throw new NotFoundException("Sector non trouvé id: " + dto.getSectorId());
        }
        Classe classe = ClasseMapper.toEntity(dto, sector);
        classeDao.save(classe);
    }

    @Override
    public void updateClasse(ClasseDTO dto) {
        Classe existing = classeDao.findById(dto.getId());
        if (existing == null) {
            throw new NotFoundException("Classe non trouvé id: " + dto.getId());
        }
        Sector sector = sectorDao.findById(dto.getSectorId());
        if (sector == null) {
            throw new NotFoundException("Sector non trouvé id: " + dto.getSectorId());
        }
        Classe classe = ClasseMapper.toEntity(dto, sector);
        classeDao.update(classe);
    }

    @Override
    public void deleteClasse(int id) {
        if (classeDao.findById(id) == null) {
            throw new NotFoundException("Classe non trouvé id: " + id);
        }
        classeDao.delete(id);
    }
}
