package com.example.gestiondesabsences.METIER;

public class Categorie {
    int id;
    String libelle;

    public Categorie(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
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
                "id='" + id + '\'' +
                "libelle='" + libelle + '\'' +
                '}';
    }
}
