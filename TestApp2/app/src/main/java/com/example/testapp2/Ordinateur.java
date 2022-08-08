package com.example.testapp2;

public class Ordinateur {

    private String marque, modele;
    private int ram;

    public Ordinateur(String marque, String modele, int ram) {
        this.marque = marque;
        this.modele = modele;
        this.ram = ram;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

}
