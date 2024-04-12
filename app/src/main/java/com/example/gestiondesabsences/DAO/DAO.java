package com.example.gestiondesabsences.DAO;

/**
 * Le pattern DAO (Data Access Object) permet de faire le lien entre les objets et le la base de données.
 */

public abstract class DAO<T> {
    /**
     * Permet de créer une entrée dans la base de données par rapport à un objet
     */
    public abstract void insert(T obj);

    /**
     * Permet de mettre à jour les données d'une entrée dans la base
     */
    public abstract void update(T obj);

    /**
     * Permet la suppression d'une entrée de la base
     */
    public abstract void delete(T obj);

}

