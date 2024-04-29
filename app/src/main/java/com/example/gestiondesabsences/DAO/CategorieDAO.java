package com.example.gestiondesabsences.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gestiondesabsences.METIER.Categorie;

import java.util.ArrayList;

/**
 *  Permet de faire le mapping entre les objets de la classe métier Catégorie et la base de données.
 */
public class CategorieDAO extends DAO<Categorie> {
    private SQLiteGestionAbsences dbGestionAbsences;

    // Déclarations des outils nécessaires à la base
    private static final String TABLE_CATEGORIE = "CATEGORIE";
    private static final String COL_ID_CATEGORIE = "IDCATEGORIE";
    private static final String COL_LIBELLE = "LIBELLE";

    /**
     * Insertion d'une catégorie dans la base de données
     * @param       ca L'objet Catégorie
     */
    @Override
    public void insert(Categorie ca) {
        SQLiteDatabase db = dbGestionAbsences.getWritableDatabase();
        ContentValues valeursIns = new ContentValues();
        valeursIns.put("libelle", "Eveils");
        valeursIns.put("libelle", "Poussinets");
        valeursIns.put("libelle", "Poussins");
        long id = db.insert("categorie", null, valeursIns);
        System.out.println("clé pour le libellé : " + id);
        db.close();

    }

    /**
     * Modification du libelle d'une catégorie en fonction de son identifiant
     * @param       ca L'objet Catégorie
     */
    @Override
    public void update(Categorie ca) {

    }

    /**
     * Suppression d'une catégorie en fonction de son identifiant
     * @param       ca L'objet Catégorie
     */
    @Override
    public void delete(Categorie ca) {

    }

    /**
     * Recherche l'identifiant d'une catégorie dans la base de données et le retourne
     *
     * @param       id L'identifiant d'une catégorie
     * @return      L'identifiant d"une catégorie
     */
    /*public Categorie read(long id){

    }*/

    /**
     * Retourne la liste de toutes les catégories enregistré dans la base de données
     * @return      La liste de toutes les catégories dans un tableau
     */
    public ArrayList<Categorie> read(){
        Cursor curseurCategorie;
        ArrayList<Categorie> listeDesCategories;
        Categorie uneCategorie;
        int idCategorie;
        String libelleCategorie;

        SQLiteDatabase db = dbGestionAbsences.getWritableDatabase();
        // Requete
        curseurCategorie = db.query(TABLE_CATEGORIE, null, null, null, null, null, COL_LIBELLE);
        // Initialisation de la liste des catégories
        listeDesCategories = new ArrayList<Categorie>();
        // Parcours du curseur
        curseurCategorie.moveToFirst();
        while(!curseurCategorie.isAfterLast()){
            // Récupération des données de l'enregistrement
            idCategorie = curseurCategorie.getInt(0);
            libelleCategorie = curseurCategorie.getString(1);
            // Ajout de la matière dans la liste
            uneCategorie = new Categorie(idCategorie, libelleCategorie);
            listeDesCategories.add(uneCategorie);
            curseurCategorie.moveToNext();
        }
        curseurCategorie.close();
        //close();
        return listeDesCategories;



    }
}
