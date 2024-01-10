package org.example.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contenu;
    @Temporal(TemporalType.DATE)
    private Date date;
    private double note;
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    public Commentaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) throws Exception {
        if (note > 0 && note < 5) {
            this.note = note;
        } else {
            throw new Exception("note invalide");
        }
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", contenu='" + contenu + '\'' +
                ", date=" + date +
                ", note=" + note +
                '}';
    }
}
