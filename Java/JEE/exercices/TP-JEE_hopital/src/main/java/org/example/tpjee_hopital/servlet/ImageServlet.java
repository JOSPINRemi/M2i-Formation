package org.example.tpjee_hopital.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.tpjee_hopital.entities.Patient;
import org.example.tpjee_hopital.services.PatientService;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet {
    private PatientService patientService;

    public void init() {
        patientService = new PatientService();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Patient patient = patientService.findById(id);
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        if (patient.getProfilePicture() != null) {
            out.write(patient.getProfilePicture());
        } else {
            out.write(null);
        }
        out.close();
    }
}
