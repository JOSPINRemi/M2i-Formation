package org.example.tpjee_hopital.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.tpjee_hopital.entities.Patient;
import org.example.tpjee_hopital.services.PatientService;
import org.example.tpjee_hopital.utils.Path;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@WebServlet("/")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class PatientServlet extends HttpServlet {
    private PatientService patientService;

    public void init() {
        patientService = new PatientService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (isLogged(request)) {
            try {
                switch (request.getServletPath()) {
                    case "/new":
                        showNewPatientForm(request, response);
                        break;
                    case "/insert":
                    case "/update":
                        insertOrUpdatePatient(request, response);
                        break;
                    case "/details":
                        showPatient(request, response);
                        break;
                    case "/edit":
                        showEditPatientForm(request, response);
                        break;
                    case "/delete":
                        deletePatient(request, response);
                        break;
                    default:
                        listPatients(request, response);
                        break;
                }
            } catch (Exception e) {
                throw new ServletException(e);
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    private void showNewPatientForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Path.VIEW_PATH + "form-patient.jsp").forward(request, response);
    }

    private void insertOrUpdatePatient(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part imagePart = request.getPart("image");

        String fileType = imagePart.getContentType();

        if (fileType.equalsIgnoreCase("image/png")) {

            byte[] imageBytes = null;
            if (imagePart != null) {
                InputStream inputStream = imagePart.getInputStream();
                imageBytes = inputStream.readAllBytes();
            }
            Patient patient = new Patient();
            patient.setLastName(request.getParameter("lastname"));
            patient.setFirstName(request.getParameter("firstname"));
            LocalDate localBirthDate = LocalDate.parse(request.getParameter("birthdate"));
            patient.setBirthDate(Date.from(localBirthDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            patient.setProfilePicture(imageBytes);
            Long id = request.getParameter("id") != null ? Long.valueOf(request.getParameter("id")) : null;

            if (id != null) {
                patient.setId(id);
            }

            if (patientService.createOrUpdate(patient)) {
                response.sendRedirect("list");
            } else {
                response.sendRedirect(Path.VIEW_PATH + "form-patient.jsp");
            }
        } else {
            response.sendRedirect(Path.VIEW_PATH + "form-patient.jsp");
        }
    }

    private void listPatients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("patients", patientService.findAll());
        request.getRequestDispatcher(Path.VIEW_PATH + "patients.jsp").forward(request, response);
    }

    private void showPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") != null) {
            Long id = Long.parseLong((request.getParameter("id")));
            Patient patient = patientService.findById(id);
            request.setAttribute("patient", patient);
            request.getRequestDispatcher(Path.VIEW_PATH+"patient.jsp").forward(request,response);
        }
        else {
            request.setAttribute("patients", patientService.findAll());
            request.getRequestDispatcher(Path.VIEW_PATH+"patients.jsp").forward(request,response);
        }
    }

    private void showEditPatientForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Patient existingPatient = patientService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher(Path.VIEW_PATH+"form-patient.jsp");
        request.setAttribute("patient", existingPatient);
        dispatcher.forward(request, response);
    }

    private void deletePatient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Patient patient = patientService.findById(id);
        if(patient != null){
            patientService.delete(patient);
        }
        response.sendRedirect("list");
    }

    private boolean isLogged(HttpServletRequest req) {
        HttpSession session = req.getSession();
        return session.getAttribute("logged") != null && (boolean) session.getAttribute("logged");
    }
}