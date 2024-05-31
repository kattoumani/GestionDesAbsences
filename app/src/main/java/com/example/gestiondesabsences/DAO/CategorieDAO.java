package com.example.gestiondesabsences.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.gestiondesabsences.METIER.Categorie;

import java.util.ArrayList;

/**
 *  Permet de faire le mapping entre les objets de la classe métier Catégorie et la base de données.
 */
public class CategorieDAO extends DAO<Categorie> {

    // Déclarations des outils nécessaires à la base
    private static final String TABLE_CATEGORIE = "CATEGORIE";
    private static final String COL_ID_CATEGORIE = "IDCATEGORIE";
    private static final String COL_LIBELLE = "LIBELLE";
    private SQLiteGestionAbsences dbGestionAbsences;
    private SQLiteDatabase db;
    private JudokaDAO judokaDAO;

    /**
     * Constructeur de la classe CategorieDAO
     * @param       context Accéder aux ressources et classes spécifiques de l'application
     */
    public CategorieDAO(Context context){
        dbGestionAbsences = new SQLiteGestionAbsences(context);
    }

    public void open(){
        db = dbGestionAbsences.getWritableDatabase();
    }

    public void close(){
        dbGestionAbsences.close();
    }



    /**
     * Insertion d'une catégorie dans la base de données
     * @param       ca L'objet Catégorie
     */
    @Override
    public void insert(Categorie ca) {
        open();
        ContentValues laCategorie = new ContentValues();
        laCategorie.put("libelle", "Eveils");
        laCategorie.put("libelle", "Poussinets");
        laCategorie.put("libelle", "Poussins");
        long id = db.insert("categorie", null, laCategorie);
        System.out.println("clé pour le libellé : " + id);
        close();
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

        open();
        // Requete
        curseurCategorie = db.query(TABLE_CATEGORIE, null, null, null, null, null, COL_LIBELLE);
        Log.v("curseur", "Curseur categorie : " + curseurCategorie);
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
        close();
        return listeDesCategories;
    }

    /**
     * Récupérer la catégorie d'un judoka
     * @param id    Id de la catégorie du judoka
     * @return      La categorie du judoka
     */
    /*public Categorie getCategorieId(int id) {
        open();
        Categorie categorie = null;
        String libelle;
        Cursor cursor = db.query(TABLE_CATEGORIE, null, "IDCATEGORIE=?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToFirst()) {
            id = cursor.getInt(0);
            libelle = cursor.getString(1);
            categorie = new Categorie(id, libelle);
        }
        cursor.close();
        close();
        return categorie;
    }*/

}
