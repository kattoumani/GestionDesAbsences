package com.example.gestiondesabsences.DAO;

import com.example.gestiondesabsences.METIER.Categorie;

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
    /*public ArrayList<Categorie> read(){

    }*/
}
