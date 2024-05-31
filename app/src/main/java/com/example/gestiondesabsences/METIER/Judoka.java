package com.example.gestiondesabsences.METIER;



import com.google.android.material.tabs.TabLayout;

import java.util.Date;

public class Judoka {

    private int id;

    private String nom;

    private String prenom;

    private String numeroTelephone;

    private String dateNaissance;

    //private Categorie uneCategorie;

    public Judoka(int id, String nom, String prenom, String numeroTelephone, String dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = numeroTelephone;
        this.dateNaissance = dateNaissance;
        //this.uneCategorie = uneCategorie;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /*public Categorie getCategorie() {
        return uneCategorie;
    }*/

    @Override
    public String toString() {
        return "Judoka{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numeroTelephone=" + numeroTelephone +
                ", dateNaissance=" + dateNaissance +
                '}';
    }
}
