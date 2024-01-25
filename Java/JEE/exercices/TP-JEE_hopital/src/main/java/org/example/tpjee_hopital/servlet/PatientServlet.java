package org.example.tpjee_hopital.servlet;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.tpjee_hopital.services.PatientService;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class PatientServlet extends HttpServlet {
    private PatientService patientService;

    public void init() {
        patientService = new PatientService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}