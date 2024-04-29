package com.example.gestiondesabsences.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        db.execSQL("DROP TABLE IF EXISTS categorie");
        db.execSQL("DROP TABLE IF EXISTS judoka");
        db.execSQL("DROP TABLE IF EXISTS cours");
        db.execSQL("CREATE TABLE categorie(id INTEGER PRIMARY KEY AUTOINCREMENT, libelle VARCHAR(100))");
        db.execSQL("CREATE TABLE judoka(id INTEGER PRIMARY KEY AUTOINCREMENT, nom VARCHAR(100), " +
                "prenom VARCHAR(100), numeroTelephone VARCHAR(100), dateNaissance DATE)");
        db.execSQL("CREATE TABLE cours(id INTEGER PRIMARY KEY AUTOINCREMENT, datePresence DATE)");
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
