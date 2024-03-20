package com.example.exam.Service;

import com.example.exam.Entity.Consultation;
import com.example.exam.Repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ConsultationService {
    @Autowired
    private ConsultationRepository consultationRepository;

    public Consultation create(Consultation consultation){
        Consultation saved=consultationRepository.save(consultation);
        return saved ;
    }

    public Consultation getById(Long id){
        Optional<Consultation> fetched=consultationRepository.findById(id);
        return fetched.get();
    }

    public List<Consultation> getAll(){
        List<Consultation> all=consultationRepository.findAll();
    return all;
    }

    public Consultation update(Consultation consultation){
        Consultation existing=consultationRepository.findById(consultation.getId()).get();
        existing.setDateConsultation(consultation.getDateConsultation());
        existing.setHeure(consultation.getHeure());
        existing.setEtatConsultation(consultation.getEtatConsultation());
        existing.setLieu(consultation.getLieu());
        Consultation updated=consultationRepository.save(existing);
        return updated;
    }


    public void delete(Long id){
        consultationRepository.deleteById(id);
    }
}
