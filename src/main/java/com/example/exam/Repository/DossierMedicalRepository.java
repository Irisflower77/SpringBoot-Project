package com.example.exam.Repository;

import com.example.exam.Entity.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Integer> {
}
