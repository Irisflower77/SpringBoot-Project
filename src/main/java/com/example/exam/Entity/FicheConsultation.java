package com.example.exam.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table

public class FicheConsultation extends FicheDeSoin{
    private String compteRendu ;
    @OneToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    @OneToMany(mappedBy = "ficheConsultation",fetch= FetchType.EAGER)
    private List<Prescription> prescriptions ;

    @OneToMany(mappedBy = "ficheConsultation",fetch= FetchType.EAGER)
    private List<OperationAnalyse> operationAnalyses;

    public FicheConsultation(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public FicheConsultation(int numeroFiche, LocalDate dateCreation, String agentCreateur, String adresseCreateur, String compteRendu) {
        super(numeroFiche, dateCreation, agentCreateur, adresseCreateur);
        this.compteRendu = compteRendu;
    }

    public FicheConsultation() {
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    @Override
    public String toString() {
        return "FicheConsultation{" +
                "compteRendu='" + compteRendu + '\'' +
                '}';
    }
}
