package com.example.exam.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class FicheDeSoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroFiche ;
    private LocalDate dateCreation ;
    private String agentCreateur ;
    private String adresseCreateur ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dossier_medical_id")
    private DossierMedical dossierMedical;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fiche_desoin_id",nullable = false)
    private FicheDeSoin ficheDesoin;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "fiche_desoin_id")
    private List<FicheDeSoin> ficheDesoins;
    public FicheDeSoin() {
    }

    public FicheDeSoin(int numeroFiche, LocalDate dateCreation, String agentCreateur, String adresseCreateur) {
        this.numeroFiche = numeroFiche;
        this.dateCreation = dateCreation;
        this.agentCreateur = agentCreateur;
        this.adresseCreateur = adresseCreateur;
    }

    public int getNumeroFiche() {
        return numeroFiche;
    }

    public void setNumeroFiche(int numeroFiche) {
        this.numeroFiche = numeroFiche;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAgentCreateur() {
        return agentCreateur;
    }

    public void setAgentCreateur(String agentCreateur) {
        this.agentCreateur = agentCreateur;
    }

    public String getAdresseCreateur() {
        return adresseCreateur;
    }

    public void setAdresseCreateur(String adresseCreateur) {
        this.adresseCreateur = adresseCreateur;
    }

    @Override
    public String toString() {
        return "FicheDeSoin{" +
                "numeroFiche=" + numeroFiche +
                ", dateCreation=" + dateCreation +
                ", agentCreateur='" + agentCreateur + '\'' +
                ", adresseCreateur='" + adresseCreateur + '\'' +
                '}';
    }
}
