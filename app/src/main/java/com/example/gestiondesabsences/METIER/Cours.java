package com.example.gestiondesabsences.METIER;

import java.util.Date;

public class Cours {
    Date datePresence;

    public Cours(Date datePresence) {
        this.datePresence = datePresence;
    }

    public Date getDatePresence() {
        return datePresence;
    }

    public void setDatePresence(Date datePresence) {
        this.datePresence = datePresence;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "datePresence=" + datePresence +
                '}';
    }
}
