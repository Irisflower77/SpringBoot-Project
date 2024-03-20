package com.example.exam.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nSS;
    private String prenom;
    private String nom;
    private LocalDate dateDeNaissance;
    private char sexe;
    private String adresse ;
    private int numTelephone ;
    @OneToOne( mappedBy = "patient")
    private DossierMedical dossierMedical;

    public Patient() {
    }

    public Patient(Long id, String nSS, String prenom, String nom, LocalDate dateDeNaissance, char sexe, String adresse, int numTelephone) {
        this.id = id;
        this.nSS = nSS;
        this.prenom = prenom;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.adresse = adresse;
        this.numTelephone = numTelephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnSS() {
        return nSS;
    }

    public void setnSS(String nSS) {
        this.nSS = nSS;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(int numTelephone) {
        this.numTelephone = numTelephone;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nSS='" + nSS + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", sexe=" + sexe +
                ", adresse='" + adresse + '\'' +
                ", numTelephone=" + numTelephone +
                '}';
    }
}
