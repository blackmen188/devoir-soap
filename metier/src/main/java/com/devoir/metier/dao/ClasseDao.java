package com.devoir.metier.dao;

import com.devoir.metier.entity.Classe;
import java.util.List;

public interface ClasseDao {
    Classe findById(int id);
    List<Classe> findAll();
    void save(Classe classe);
    void update(Classe classe);
    void delete(int id);
}
