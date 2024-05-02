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
    private static final int DATABASE_VERSION = 1;
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
        db.execSQL("DROP TABLE IF EXISTS CATEGORIE");

        db.execSQL("DROP TABLE IF EXISTS JUDOKA"); // Création de la table judoka
        db.execSQL("DROP TABLE IF EXISTS COURS");
        db.execSQL("CREATE TABLE CATEGORIE(IDCATEGORIE INTEGER PRIMARY KEY AUTOINCREMENT, LIBELLE VARCHAR(100))");
        // Insertion Categorie
        db.execSQL("INSERT INTO CATEGORIE(COL_ID_CATEGORIE, COL_LIBELLE) values (1, 'Eveils')");
        db.execSQL("INSERT INTO CATEGORIE(COL_ID_CATEGORIE, COL_LIBELLE) values (1, 'Poussinets')");
        db.execSQL("INSERT INTO CATEGORIE(COL_ID_CATEGORIE, COL_LIBELLE) values (1, 'Poussins')");
        Log.v("insertion", "Insertion des categories");

        // Création de la table judoka
        db.execSQL("CREATE TABLE JUDOKA(IDJUDOKA INTEGER PRIMARY KEY AUTOINCREMENT, NOM VARCHAR(100), " +
                "PRENOM VARCHAR(100), NUMERO VARCHAR(100), DATENAISSANCE DATE)");
        db.execSQL("CREATE TABLE COURS(IDCOURS INTEGER PRIMARY KEY AUTOINCREMENT, DATEPRESENCE DATE)"); // Création de la table cours

        } catch(Exception e){
            e.printStackTrace();
        }
        Log.v("oncreate", "BDD créer");
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
