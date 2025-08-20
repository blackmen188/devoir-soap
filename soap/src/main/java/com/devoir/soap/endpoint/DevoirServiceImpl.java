package com.devoir.soap.endpoint;

import com.devoir.metier.dto.ClasseDTO;
import com.devoir.metier.dto.SectorDTO;
import com.devoir.metier.service.ClasseService;
import com.devoir.metier.service.SectorService;

import javax.jws.WebService;
import java.util.List;

@WebService(
        endpointInterface = "com.devoir.soap.endpoint.DevoirService",
        serviceName = "DevoirService"
)
public class DevoirServiceImpl implements DevoirService {

    private final ClasseService classeService;
    private final SectorService sectorService;

    public DevoirServiceImpl() {

        this.classeService = new com.devoir.metier.service.ClasseServiceImpl(
                new com.devoir.metier.dao.ClasseDaoImpl(),
                new com.devoir.metier.dao.SectorDaoImpl()
        );
        this.sectorService = new com.devoir.metier.service.SectorServiceImpl(
                new com.devoir.metier.dao.SectorDaoImpl()
        );
    }

    @Override
    public List<ClasseDTO> getAllClasses() {
        return classeService.getAllClasses();
    }

    @Override
    public ClasseDTO getClasseById(int id) {
        return classeService.getClasseById(id);
    }

    @Override
    public ClasseDTO addClasse(ClasseDTO dto) {
        classeService.addClasse(dto);
        return dto;
    }

    @Override
    public ClasseDTO updateClasse(ClasseDTO dto) {
        classeService.updateClasse(dto);
        return dto;
    }

    @Override
    public void deleteClasse(int id) {
        classeService.deleteClasse(id);
    }

    @Override
    public List<SectorDTO> getAllSectors() {
        return sectorService.getAllSectors();
    }

    @Override
    public SectorDTO getSectorById(int id) {
        return sectorService.getSectorById(id);
    }

    @Override
    public SectorDTO addSector(SectorDTO dto) {
        sectorService.addSector(dto);
        return dto;
    }

    @Override
    public SectorDTO updateSector(SectorDTO dto) {
        sectorService.updateSector(dto);
        return dto;
    }

    @Override
    public void deleteSector(int id) {
        sectorService.deleteSector(id);
    }
}