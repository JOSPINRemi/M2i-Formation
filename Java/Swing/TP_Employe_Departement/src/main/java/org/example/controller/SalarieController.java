package org.example.controller;

import org.example.dao.SalarieDao;
import org.example.model.Salarie;

import java.util.List;

public class SalarieController {

    private SalarieDao salarieDao;

    public SalarieController() {
        salarieDao = new SalarieDao();
    }

    public List<Salarie> getAllSalaries() {
        return salarieDao.getAll();
    }
}
