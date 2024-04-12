package com.example.gestiondesabsences.IHM.METIER;

public class Categorie {
    String libelle;

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "libelle='" + libelle + '\'' +
                '}';
    }
}
