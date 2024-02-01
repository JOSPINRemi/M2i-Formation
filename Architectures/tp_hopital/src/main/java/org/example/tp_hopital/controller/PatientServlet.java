package org.example.tp_hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.tp_hopital.repository.PatientRepository;
import org.example.tp_hopital.service.PatientService;
import org.example.tp_hopital.utils.HibernateSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.example.tp_hopital.utils.Path;

import java.io.IOException;


@WebServlet("/")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class PatientServlet extends HttpServlet {

    private PatientService patientService;


    public void init() {
        patientService = new PatientService(HibernateSession.getSessionFactory(), new PatientRepository());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            switch (req.getServletPath()){
                default:
                    patients(req, resp);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void patients(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("patients", patientService.findAll());
        try {
            request.getRequestDispatcher(Path.VIEW_PATH + "patients.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
