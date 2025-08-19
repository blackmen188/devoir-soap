package com.devoir.metier.entity;

public class Sector {
    private int id;
    private String nom;

    // Constructeurs
    public Sector() {}

    public Sector(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
