package org.example.poo.datastructure;

public  abstract class Engine {

    protected static int count;
    protected int id;
    protected int nbreRoue;
    protected String couleur;

    {
        count++;
    }

    protected abstract void test();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbreRoue() {
        return nbreRoue;
    }

    public void setNbreRoue(int nbreRoue) {
        this.nbreRoue = nbreRoue;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", nbreRoue=" + nbreRoue +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
