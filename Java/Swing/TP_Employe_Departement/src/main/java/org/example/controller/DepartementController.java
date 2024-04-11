package org.example.controller;

import org.example.dao.DepartementDao;
import org.example.model.Departement;

import java.util.List;

public class DepartementController {

    private DepartementDao departementDao;

    public DepartementController() {
        this.departementDao = new DepartementDao();
    }

    public List<Departement> getAllDepartements() {
        return departementDao.getAll();
    }
}
