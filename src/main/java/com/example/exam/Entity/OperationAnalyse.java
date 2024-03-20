package com.example.exam.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class OperationAnalyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String description ;
    private LocalDate dateHeureOperation ;
    private String resultat ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ficheConsultationId")
    private FicheConsultation ficheConsultation;

    public OperationAnalyse() {
    }

    public OperationAnalyse(Long id, String description, LocalDate dateHeureOperation, String resultat) {
        this.id = id;
        this.description = description;
        this.dateHeureOperation = dateHeureOperation;
        this.resultat = resultat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateHeureOperation() {
        return dateHeureOperation;
    }

    public void setDateHeureOperation(LocalDate dateHeureOperation) {
        this.dateHeureOperation = dateHeureOperation;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return "OperationAnalyse{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateHeureOperation=" + dateHeureOperation +
                ", resultat='" + resultat + '\'' +
                '}';
    }
}
