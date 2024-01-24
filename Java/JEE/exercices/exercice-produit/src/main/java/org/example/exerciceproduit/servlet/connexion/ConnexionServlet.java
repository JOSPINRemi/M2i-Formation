package org.example.exerciceproduit.servlet.connexion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.exerciceproduit.entities.Utilisateur;
import org.example.exerciceproduit.service.ProduitService;

import java.io.IOException;

@WebServlet(name = "connexion", value = "/connexion")
public class ConnexionServlet extends HttpServlet {

    private ProduitService produitService;
    private Utilisateur utilisateur;

    @Override
    public void init() throws ServletException {
        produitService = new ProduitService();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/views/connexion/connexion.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        utilisateur = produitService.findUserById(1);

        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setNom(req.getParameter("username"));
        utilisateur1.setMotDePasse(req.getParameter("password"));
        if (utilisateur.equals(utilisateur1)) {
            HttpSession session = req.getSession();
            session.setAttribute("loggedIn", true);
            resp.sendRedirect("produits");
        }
        else {
            System.out.println("Problème de connexion");
            resp.sendRedirect("connexion");
        }
    }
}
