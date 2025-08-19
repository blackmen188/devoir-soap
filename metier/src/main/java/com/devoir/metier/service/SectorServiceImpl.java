package com.devoir.metier.service;

import com.devoir.metier.dao.SectorDao;
import com.devoir.metier.dto.SectorDTO;
import com.devoir.metier.entity.Sector;
import com.devoir.metier.exception.NotFoundException;
import com.devoir.metier.mapper.SectorMapper;
import java.util.List;
import java.util.stream.Collectors;

public class SectorServiceImpl implements SectorService {
    private final SectorDao sectorDao;

    public SectorServiceImpl(SectorDao sectorDao) {
        this.sectorDao = sectorDao;
    }

    @Override
    public List<SectorDTO> getAllSectors() {
        return sectorDao.findAll().stream()
                .map(SectorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SectorDTO getSectorById(int id) {
        Sector sector = sectorDao.findById(id);
        if (sector == null) {
            throw new NotFoundException("Sector non trouvé id: " + id);
        }
        return SectorMapper.toDto(sector);
    }

    @Override
    public void addSector(SectorDTO dto) {
        Sector sector = SectorMapper.toEntity(dto);
        sectorDao.save(sector);
    }

    @Override
    public void updateSector(SectorDTO dto) {
        Sector existing = sectorDao.findById(dto.getId());
        if (existing == null) {
            throw new NotFoundException("Sector non trouvé id: " + dto.getId());
        }
        Sector sector = SectorMapper.toEntity(dto);
        sectorDao.update(sector);
    }

    @Override
    public void deleteSector(int id) {
        if (sectorDao.findById(id) == null) {
            throw new NotFoundException("Sector non trouvé id: " + id);
        }
        sectorDao.delete(id);
    }
}
