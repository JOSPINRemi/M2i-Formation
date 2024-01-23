package org.example.exerciceproduit.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exerciceproduit.entities.Produit;
import org.example.exerciceproduit.service.ProduitService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "produits", value = "/produits")
public class ProduitsServlet extends HttpServlet {
    private List<Produit> produits;
    private ProduitService produitService;

    public void init() {
        produits = new ArrayList<>();
        produitService = new ProduitService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        produits = produitService.findAll();
        request.setAttribute("produits", produits);
        request.getRequestDispatcher("produits.jsp").forward(request, response);
    }
}