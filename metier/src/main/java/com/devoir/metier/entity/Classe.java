package com.devoir.metier.entity;

public class Classe {
    private int id;
    private String libelle;
    private String description;
    private Sector sector;

    // Constructeurs
    public Classe() {}

    public Classe(int id, String libelle, String description, Sector sector) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.sector = sector;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Sector getSector() { return sector; }
    public void setSector(Sector sector) { this.sector = sector; }
}
