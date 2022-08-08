package com.example.driveapp.objects;

public class Produits_lot {

    private String nom;
    private int prix,quantite;

    public Produits_lot(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = 1;
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = 1;
    }
}
