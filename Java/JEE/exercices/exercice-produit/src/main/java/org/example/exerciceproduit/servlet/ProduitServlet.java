package org.example.exerciceproduit.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exerciceproduit.entities.Produit;
import org.example.exerciceproduit.service.ProduitService;

import java.io.IOException;

@WebServlet(name = "produit", value = "/produit")
public class ProduitServlet extends HttpServlet {
    private Produit produit;
    private ProduitService produitService;
    private int id;
    private String mode;

    public void init() {
        produitService = new ProduitService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        id = Integer.parseInt(request.getParameter("id"));
        mode = request.getParameter("mode");

        produit = produitService.findById(id);
        if (mode == null) {
            request.setAttribute("produit", produit);
            request.getRequestDispatcher("produit.jsp").forward(request, response);
        } else {
            switch (mode) {
                case "delete":
                    produitService.delete(produit);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}