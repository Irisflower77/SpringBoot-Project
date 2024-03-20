package com.example.exam.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private LocalDate dateConsultation ;
    private String heure ;
    private String lieu ;
    private char etatConsultation ;

    public Consultation() {
    }

    public Consultation(Long id, LocalDate dateConsultation, String heure, String lieu, char etatConsultation) {
        this.id = id;
        this.dateConsultation = dateConsultation;
        this.heure = heure;
        this.lieu = lieu;
        this.etatConsultation = etatConsultation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(LocalDate dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public char getEtatConsultation() {
        return etatConsultation;
    }

    public void setEtatConsultation(char etatConsultation) {
        this.etatConsultation = etatConsultation;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", dateConsultation=" + dateConsultation +
                ", heure='" + heure + '\'' +
                ", lieu='" + lieu + '\'' +
                ", etatConsultation=" + etatConsultation +
                '}';
    }
}
