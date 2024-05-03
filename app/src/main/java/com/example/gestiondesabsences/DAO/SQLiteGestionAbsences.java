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
    private static final int DATABASE_VERSION = 7;
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

        db.execSQL("CREATE TABLE CATEGORIE(IDCATEGORIE INTEGER PRIMARY KEY AUTOINCREMENT, LIBELLE VARCHAR(100))");
        // Insertion Categorie
        db.execSQL("INSERT INTO CATEGORIE(IDCATEGORIE, LIBELLE) values (1, 'Eveils')");
        db.execSQL("INSERT INTO CATEGORIE(IDCATEGORIE, LIBELLE) values (2, 'Poussinets')");
        db.execSQL("INSERT INTO CATEGORIE(IDCATEGORIE, LIBELLE) values (3, 'Poussins')");
        Log.v("insertion", "Insertion des categories");

        // Création de la table judoka
        db.execSQL("CREATE TABLE JUDOKA(IDJUDOKA INTEGER PRIMARY KEY AUTOINCREMENT, NOM VARCHAR(100), " +
                "PRENOM VARCHAR(100), NUMERO VARCHAR(100), DATENAISSANCE DATE)");
        db.execSQL("INSERT INTO JUDOKA(IDJUDOKA, NOM, PRENOM, NUMERO, DATENAISSANCE) values (1, 'Rey', 'Thierry', '0548211472', '1979-06-01')");
        db.execSQL("INSERT INTO JUDOKA(IDJUDOKA, NOM, PRENOM, NUMERO, DATENAISSANCE) values (2, 'Petrikov', 'Pavel', '0741271478', '1986-06-20')");
        db.execSQL("INSERT INTO JUDOKA(IDJUDOKA, NOM, PRENOM, NUMERO, DATENAISSANCE) values (3, 'Jupke', 'Peter', '0924214472', '1957-06-03')");

        db.execSQL("CREATE TABLE COURS(IDCOURS INTEGER PRIMARY KEY AUTOINCREMENT, DATEPRESENCE DATE)"); // Création de la table cours
        db.execSQL("INSERT INTO COURS(IDCOURS, DATEPRESENCE) values (1, '2024-01-05')");
        db.execSQL("INSERT INTO COURS(IDCOURS, DATEPRESENCE) values (2, '2024-02-18')");
        db.execSQL("INSERT INTO COURS(IDCOURS, DATEPRESENCE) values (3, '2024-03-11')");


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
