package com.example.gestiondesabsences.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.gestiondesabsences.METIER.Categorie;
import com.example.gestiondesabsences.METIER.Judoka;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *  Permet de faire le mapping entre les objets de la classe métier Judoka et la base de données.
 */
public class JudokaDAO extends DAO<Judoka> {
        // Déclarations des outils nécessaires à la base
    private static final String TABLE_JUDOKA = "JUDOKA";
    private static final String COL_ID_JUDOKA = "IDJUDOKA";
    private static final String COL_NOM = "NOM";
    private static final String COL_PRENOM = "PRENOM";
    private static final String COL_NUMERO_TELEPHONE = "NUMEROTELEPHONE";
    private static final String COL_DATE_NAISSANCE = "DATENAISSANCE";

    private SQLiteGestionAbsences dbGestionAbsences;
    private SQLiteDatabase db;

    public JudokaDAO(Context context) {
        dbGestionAbsences = new SQLiteGestionAbsences(context);
    }

    public void open(){
        db = dbGestionAbsences.getWritableDatabase();
    }

    public void close(){
        dbGestionAbsences.close();
    }

    /**
     * Insertion d'un Judoka dans la base de données
     * @param       ju L'objet Judoka
     */
    public void insert(Judoka ju){
        open();
        ContentValues leJudoka = new ContentValues();
        close();

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
    public ArrayList<Judoka> read() throws ParseException {
        Cursor curseurJudoka;
        ArrayList<Judoka> listeDesJudokas;
        Judoka unJudoka;
        int idJudoka;
        String nom;
        String prenom;
        String numeroTelephone;
        String dateNaissance;

        open();
        // Requete
        curseurJudoka = db.query(TABLE_JUDOKA, null, null, null, null, null, COL_NOM);
        Log.v("curseur", "Curseur categorie : " + curseurJudoka);
        // Initialisation de la liste des catégories
        listeDesJudokas = new ArrayList<Judoka>();
        // Parcours du curseur
        curseurJudoka.moveToFirst();
        while(!curseurJudoka.isAfterLast()){
            // Récupération des données de l'enregistrement
            idJudoka = curseurJudoka.getInt(0);
            nom = curseurJudoka.getString(1);
            prenom = curseurJudoka.getString(2);
            numeroTelephone = curseurJudoka.getString(3);
            dateNaissance = curseurJudoka.getString(4);
            String dateString = dateNaissance;
            Date dateN = new SimpleDateFormat("YYYY-mm-dd").parse(dateString);


            // Ajout de la matière dans la liste
            unJudoka = new Judoka(idJudoka, nom, prenom, numeroTelephone, dateN);
            listeDesJudokas.add(unJudoka);
            curseurJudoka.moveToNext();
        }
        curseurJudoka.close();
        close();
        return listeDesJudokas;
    }






}
