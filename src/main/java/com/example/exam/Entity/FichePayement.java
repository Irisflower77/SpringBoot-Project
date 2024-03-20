package com.example.exam.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table
public class FichePayement extends FicheDeSoin{

    private LocalDate dateExigibilite;
    private LocalDate datePayement ;
    private double montantPaye ;
    private boolean indicateurPayement ;

    public FichePayement() {
    }



    public LocalDate getDateExigibilite() {
        return dateExigibilite;
    }

    public void setDateExigibilite(LocalDate dateExigibilite) {
        this.dateExigibilite = dateExigibilite;
    }

    public LocalDate getDatePayement() {
        return datePayement;
    }


    public void setDatePayement(LocalDate datePayement) {
        this.datePayement = datePayement;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public boolean isIndicateurPayement() {
        return indicateurPayement;
    }

    public void setIndicateurPayement(boolean indicateurPayement) {
        this.indicateurPayement = indicateurPayement;
    }

    @Override
    public String toString() {
        return "FichePayement{" +
                "dateExigibilite=" + dateExigibilite +
                ", datePayement=" + datePayement +
                ", montantPaye=" + montantPaye +
                ", indicateurPayement=" + indicateurPayement +
                '}';
    }
}
