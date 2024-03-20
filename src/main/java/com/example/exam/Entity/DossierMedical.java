package com.example.exam.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero ;
    private LocalDate date ;
    private String codeAccessPatient ;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    @OneToMany(mappedBy = "dossierMedical")
    private List<FicheDeSoin> fichesDeSoin;
    public DossierMedical() {
    }

    public DossierMedical(int numero, LocalDate date, String codeAccessPatient) {
        this.numero = numero;
        this.date = date;
        this.codeAccessPatient = codeAccessPatient;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCodeAccessPatient() {
        return codeAccessPatient;
    }

    public void setCodeAccessPatient(String codeAccessPatient) {
        this.codeAccessPatient = codeAccessPatient;
    }

    @Override
    public String toString() {
        return "DossierMedical{" +
                "numero=" + numero +
                ", date=" + date +
                ", codeAccessPatient='" + codeAccessPatient + '\'' +
                '}';
    }
}
