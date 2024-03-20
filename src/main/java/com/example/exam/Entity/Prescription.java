package com.example.exam.Entity;

import jakarta.persistence.*;

@Entity
@Table

public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String designation ;
    private String periode ;
    private String indication ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ficheConsultationId", nullable = false)
private FicheConsultation ficheConsultation;


    public Prescription() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public Prescription(Long id, String designation, String periode, String indication) {
        this.id = id;
        this.designation = designation;
        this.periode = periode;
        this.indication = indication;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", periode='" + periode + '\'' +
                ", indication='" + indication + '\'' +
                '}';
    }
}
