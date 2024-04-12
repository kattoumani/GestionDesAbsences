package com.example.gestiondesabsences.DAO;

import com.example.gestiondesabsences.METIER.Judoka;

import java.util.ArrayList;

/**
 *  Permet de faire le mapping entre les objets de la classe métier Judoka et la base de données.
 */
public class JudokaDAO extends DAO<Judoka> {

    private SQLiteGestionAbsences dbGestionAbsences;

    // Déclarations des outils nécessaires à la base
    private static final String TABLE_JUDOKA = "JUDOKA";
    private static final String COL_ID_JUDOKA = "IDJUDOKA";
    private static final String COL_NOM = "NOM";
    private static final String COL_PRENOM = "PRENOM";
    private static final String COL_NUMERO_TELEPHONE = "NUMEROTELEPHONE";
    private static final String COL_DATE_NAISSANCE = "DATENAISSANCE";

    /**
     * Insertion d'un Judoka dans la base de données
     * @param       ju L'objet Judoka
     */
    public void insert(Judoka ju){

    }

    /**
     * Modification de nom, prenom, numero de téléphone et date de naissance d'un Judoka
     * en fonction de son identifiant
     * @param       ju L'objet Judoka
     */
    public void update(Judoka ju){

    }

    /**
     * Suppression d'un judoka en fonction de son identifiant
     * @param       ju L'objet Judoka
     */
    public void delete(Judoka ju){

    }

    /**
     * Recherche l'identifiant du judoka dans la base de données et le retourne
     *
     * @param       id L'identifiant du Jodoka
     * @return      L'identifiant du Jodoka
     */
    /*public Judoka read(long id){

    }*/

    /**
     * Retourne la liste de tous les Judokas enregistré dans la base de données
     * @return      La liste de tous les Judokas dans un tableau
     */
    /*public ArrayList<Judoka> read(){

    }*/






}
