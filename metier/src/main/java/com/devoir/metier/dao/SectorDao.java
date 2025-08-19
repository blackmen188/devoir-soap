package com.devoir.metier.dao;

import com.devoir.metier.entity.Sector;
import java.util.List;

public interface SectorDao {
    Sector findById(int id);
    List<Sector> findAll();
    void save(Sector sector);
    void update(Sector sector);
    void delete(int id);
}
