package com.example.gestiondesabsences.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Définition de la classe enfant SQLiteOpenHelper, la classe se nomme SQLIteGestionAbsences
 */
public class SQLiteGestionAbsences extends SQLiteOpenHelper {
    // Version de la base de données
    private static final int DATABASE_VERSION = 17;
    // Nom de la base de données
    private static final String DATABASE_NAME = "GestionDesAbsences";
    // Contexte
    private Context context = null;

    /**
     * Constructeur de la classe SQLiteGestionAbsences
     * @param context
     */
    public SQLiteGestionAbsences(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    /**
     * Exécutée si la base de donneés n'existe pas déjà
     * @param db
     */
    public void onCreate(SQLiteDatabase db){
    try{
        db.execSQL("DROP TABLE IF EXISTS CATEGORIE");  // Drop la table categorie
        db.execSQL("DROP TABLE IF EXISTS JUDOKA"); // Drop la table judoka
        db.execSQL("DROP TABLE IF EXISTS COURS"); // Drop la table cours

        // Création de la table Categorie
        db.execSQL("CREATE TABLE CATEGORIE(IDCATEGORIE INTEGER PRIMARY KEY AUTOINCREMENT, LIBELLE VARCHAR(100))");
        // Insertion des categories
        db.execSQL("INSERT INTO CATEGORIE(IDCATEGORIE, LIBELLE) values (1, 'Eveils')");
        db.execSQL("INSERT INTO CATEGORIE(IDCATEGORIE, LIBELLE) values (2, 'Poussinets')");
        db.execSQL("INSERT INTO CATEGORIE(IDCATEGORIE, LIBELLE) values (3, 'Poussins')");
        db.execSQL("INSERT INTO CATEGORIE(IDCATEGORIE, LIBELLE) values (4, 'Benjamins')");
        db.execSQL("INSERT INTO CATEGORIE(IDCATEGORIE, LIBELLE) values (5, 'Minimes')");
        db.execSQL("INSERT INTO CATEGORIE(IDCATEGORIE, LIBELLE) values (6, 'Cadets')");
        db.execSQL("INSERT INTO CATEGORIE(IDCATEGORIE, LIBELLE) values (7, 'Juniors')");
        db.execSQL("INSERT INTO CATEGORIE(IDCATEGORIE, LIBELLE) values (8, 'Seniors')");
        Log.v("insertion", "Insertion des categories");

        // Création de la table judoka
        db.execSQL("CREATE TABLE JUDOKA(IDJUDOKA INTEGER PRIMARY KEY AUTOINCREMENT, NOM VARCHAR(100), " +
                "PRENOM VARCHAR(100), NUMEROTELEPHONE VARCHAR(100), DATENAISSANCE VARCHAR(100))");
                /*+"IDCATEGORIEJUDOKA INTEGER, FOREIGN KEY (IDCATEGORIEJUDOKA) REFERENCES CATEGORIE(IDCATEGORIE))")*/
        // Insertion des judokas
        db.execSQL("INSERT INTO JUDOKA(IDJUDOKA, NOM, PRENOM, NUMEROTELEPHONE, DATENAISSANCE) values (1, 'Rey', 'Thierry', '0548211472', '1979-06-01')");
        db.execSQL("INSERT INTO JUDOKA(IDJUDOKA, NOM, PRENOM, NUMEROTELEPHONE, DATENAISSANCE) values (2, 'Petrikov', 'Pavel', '0741271478', '1986-06-20')");
        db.execSQL("INSERT INTO JUDOKA(IDJUDOKA, NOM, PRENOM, NUMEROTELEPHONE, DATENAISSANCE) values (3, 'Jupke', 'Peter', '0924214472', '1957-06-03')");


        // Creation de la table COURS
        db.execSQL("CREATE TABLE COURS(IDCOURS INTEGER PRIMARY KEY AUTOINCREMENT, DATEPRESENCE VARCHAR(100))"); // Création de la table cours
        // Insertion des cours
        db.execSQL("INSERT INTO COURS(IDCOURS, DATEPRESENCE) values (1, '2024-01-05')");
        db.execSQL("INSERT INTO COURS(IDCOURS, DATEPRESENCE) values (2, '2024-02-18')");
        db.execSQL("INSERT INTO COURS(IDCOURS, DATEPRESENCE) values (3, '2024-03-11')");


        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Exéutée si la base de données change de version
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onCreate(db);
    }

}
