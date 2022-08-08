package com.example.driveapp.objects;

public class HistoriqueCommande {

    private String date,codepostal;
    int montant;

    public HistoriqueCommande(String date, String codepostal, int montant) {
        this.date = date;
        this.codepostal = codepostal;
        this.montant = montant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
