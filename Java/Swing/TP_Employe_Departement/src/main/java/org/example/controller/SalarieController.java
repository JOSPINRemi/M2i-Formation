package org.example.controller;

import org.example.dao.SalarieDao;
import org.example.model.Salarie;

import java.util.List;

public class SalarieController {

    private SalarieDao salarieDao;

    public SalarieController() {
        salarieDao = new SalarieDao();
    }

    public boolean addSalarie(Salarie salarie) {
        if (salarieDao.add(salarie) > 0) {
            return true;
        } else return false;
    }

    public List<Salarie> getAllSalaries() {
        return salarieDao.getAll();
    }

    public boolean deleteSalarie(int id) {
        if (salarieDao.delete(id) == 1) {
            return true;
        } else return false;
    }
}
