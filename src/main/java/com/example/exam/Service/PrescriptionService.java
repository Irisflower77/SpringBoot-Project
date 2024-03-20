package com.example.exam.Service;

import com.example.exam.Entity.Consultation;
import com.example.exam.Entity.Prescription;
import com.example.exam.Repository.ConsultationRepository;
import com.example.exam.Repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository consultationRepository;

    public Prescription create(Prescription consultation){
        Prescription saved=consultationRepository.save(consultation);
        return saved ;
    }

    public Prescription getById(Long id){
        Optional<Prescription> fetched=consultationRepository.findById(id);
        return fetched.get();
    }

    public List<Prescription> getAll(){
        List<Prescription> all=consultationRepository.findAll();
        return all;
    }

    public Prescription update(Prescription consultation){
        Prescription existing=consultationRepository.findById(consultation.getId()).get();
        existing.setDesignation(consultation.getDesignation());
        existing.setIndication(consultation.getIndication());
        existing.setPeriode(consultation.getPeriode());
        Prescription updated=consultationRepository.save(existing);
        return updated;
    }


    public void delete(Long id){
        consultationRepository.deleteById(id);
    }
}
