package com.example.gestiondesabsences.DAO;

import com.example.gestiondesabsences.METIER.Cours;

/**
 *  Permet de faire le mapping entre les objets de la classe métier Cours et la base de données.
 */
public class CoursDAO extends DAO<Cours> {
    private SQLiteGestionAbsences dbGestionAbsences;
    // Déclarations des outils nécessaires à la base
    private static final String TABLE_COURS = "COURS";
    private static final String COL_ID_COURS = "IDCOURS";
    private static final String COL_DATE_PRESENCE = "DATEPRESENCE";

    /**
     * Insertion d'un cours dans la base de données
     * @param       co L'objet Cours
     */
    @Override
    public void insert(Cours co) {

    }

    /**
     * Modification de la date du cours en fonction de son identifiant
     * @param       co L'objet Cours
     */
    @Override
    public void update(Cours co) {

    }

    /**
     * Suppression d'une date en fonction de son identifiant
     * @param       co L'objet Cours
     */
    @Override
    public void delete(Cours co) {

    }

    /**
     * Recherche l'identifiant d'un cours dans la base de données et le retourne
     *
     * @param       id L'identifiant d'un cours
     * @return      L'identifiant d'un cours
     */
    /*public Categorie read(long id){

    }*/

    /**
     * Retourne la liste de tous les cours enregistré dans la base de données
     * @return      La liste de tous les cours dans un tableau
     */
    /*public ArrayList<Categorie> read(){

    }*/
}
