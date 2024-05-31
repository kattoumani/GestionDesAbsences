package com.example.gestiondesabsences.METIER;

import java.util.Date;

public class Cours {
    String datePresence;

    public Cours(String datePresence) {
        this.datePresence = datePresence;
    }

    public String getDatePresence() {
        return datePresence;
    }

    public void setDatePresence(String datePresence) {
        this.datePresence = datePresence;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "datePresence=" + datePresence +
                '}';
    }
}
