package com.example.exam.Service;

import com.example.exam.Entity.Consultation;
import com.example.exam.Entity.Patient;
import com.example.exam.Repository.ConsultationRepository;
import com.example.exam.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository consultationRepository;

    public Patient create(Patient consultation){
        Patient saved=consultationRepository.save(consultation);
        return saved ;
    }

    public Patient getById(Long id){
        Optional<Patient> fetched=consultationRepository.findById(id);
        return fetched.get();
    }

    public List<Patient> getAll(){
        List<Patient> all=consultationRepository.findAll();
        return all;
    }

    public Patient update(Patient consultation){
        Patient existing=consultationRepository.findById(consultation.getId()).get();
existing.setAdresse(consultation.getAdresse());
existing.setNom(consultation.getNom());
existing.setnSS(consultation.getnSS());
existing.setSexe(consultation.getSexe());
existing.setDateDeNaissance(consultation.getDateDeNaissance());
existing.setPrenom(consultation.getPrenom());
existing.setNumTelephone(consultation.getNumTelephone());
        Patient updated=consultationRepository.save(existing);
        return updated;
    }


    public void delete(Long id){
        consultationRepository.deleteById(id);
    }
}
