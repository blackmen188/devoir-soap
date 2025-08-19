package com.devoir.soap.endpoint;

import com.devoir.metier.dao.ClasseDao;
import com.devoir.metier.dao.ClasseDaoImpl;
import com.devoir.metier.dao.SectorDao;
import com.devoir.metier.dao.SectorDaoImpl;
import com.devoir.metier.service.ClasseService;
import com.devoir.metier.service.ClasseServiceImpl;
import com.devoir.metier.service.SectorService;
import com.devoir.metier.service.SectorServiceImpl;

public class ServiceFactory {
    private static ClasseService classeService;
    private static SectorService sectorService;

    public static synchronized ClasseService getClasseService() {
        if (classeService == null) {
            ClasseDao classeDao = new ClasseDaoImpl();
            SectorDao sectorDao = new SectorDaoImpl();
            classeService = new ClasseServiceImpl(classeDao, sectorDao);
        }
        return classeService;
    }

    public static synchronized SectorService getSectorService() {
        if (sectorService == null) {
            SectorDao sectorDao = new SectorDaoImpl();
            sectorService = new SectorServiceImpl(sectorDao);
        }
        return sectorService;
    }
}
