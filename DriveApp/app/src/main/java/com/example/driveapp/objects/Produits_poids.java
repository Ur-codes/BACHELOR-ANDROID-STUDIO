package com.example.driveapp.objects;

public class Produits_poids {

    private String nom;
    private int prix,poids;

    public Produits_poids(String nom, int prix, int poids) {
        this.nom = nom;
        this.prix = prix;
        this.poids = poids;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }
}
