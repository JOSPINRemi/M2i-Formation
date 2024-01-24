package org.example.exerciceproduit.servlet.produit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.exerciceproduit.entities.Produit;
import org.example.exerciceproduit.service.ProduitService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@WebServlet(name = "produit", value = "/produit")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class ProduitServlet extends HttpServlet {
    private Produit produit;
    private ProduitService produitService;
    private int id;
    private String mode;

    public void init() {
        produitService = new ProduitService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        id = -1;
        mode = null;
        if(request.getParameter("id") != null){
            id = Integer.parseInt(request.getParameter("id"));
        }
        mode = request.getParameter("mode");
        if (id == -1 && mode == null){
            request.getRequestDispatcher("views/produit/produit-form.jsp").forward(request, response);
        }
        else if (id != -1) {
            produit = produitService.findById(id);
            if (mode == null) {
                request.setAttribute("produit", produit);
                request.getRequestDispatcher("views/produit/produit.jsp").forward(request, response);
            } else {
                if (isLoggedIn(request)) {
                    switch (mode) {
                        case "delete":
                            produitService.delete(produit);
                            break;
                        case "update":
//                            TODO : Mettre à jour un produit
                            request.setAttribute("produit", produit);
                            request.getRequestDispatcher("views/produit/produit-form.jsp").forward(request, response);
                            break;
                    }
                    response.sendRedirect("produits");
                } else {
                    response.sendRedirect("connexion");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isLoggedIn(req)) {
            produit = new Produit();
            String uploadPath = getServletContext().getRealPath("/") + "images";
            File file = new File(uploadPath);
            if(!file.exists()){
                file.mkdir();
            }
            Part image = req.getPart("image");
            String fileName = image.getSubmittedFileName();
            image.write(uploadPath + File.separator + fileName);
            produit.setUrlImage(fileName);
            produit.setMarque(req.getParameter("marque"));
            produit.setReference(req.getParameter("reference"));
            LocalDate localDateAchat = LocalDate.parse(req.getParameter("dateAchat"));
            Date dateAchat = Date.from(localDateAchat.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            produit.setDateAchat(dateAchat);
            produit.setPrix(Double.parseDouble(req.getParameter("prix")));
            produit.setStock(Integer.parseInt(req.getParameter("stock")));
            produitService.create(produit);
            resp.sendRedirect("produits");
        } else {
            resp.sendRedirect("connexion");
        }
    }

    private boolean isLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn");
    }
}