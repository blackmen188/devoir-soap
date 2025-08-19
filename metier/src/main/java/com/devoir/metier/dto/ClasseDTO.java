package com.devoir.metier.dto;

public class ClasseDTO {
    private int id;
    private String libelle;
    private String description;
    private int sectorId;

    // Constructeurs
    public ClasseDTO() {}

    public ClasseDTO(int id, String libelle, String description, int sectorId) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.sectorId = sectorId;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getSectorId() { return sectorId; }
    public void setSectorId(int sectorId) { this.sectorId = sectorId; }
}
