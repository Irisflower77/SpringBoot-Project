package com.example.exam.Service;

import com.example.exam.Entity.FicheDeSoin;
import com.example.exam.Repository.FicheDeSoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FicheDeSoinService {

    @Autowired
    private FicheDeSoinRepository consultationRepository;

    public FicheDeSoin create(FicheDeSoin consultation){
        FicheDeSoin saved=consultationRepository.save(consultation);
        return saved ;
    }

    public FicheDeSoin getById(Integer id){
        Optional<FicheDeSoin> fetched=consultationRepository.findById(id);
        return fetched.get();
    }

    public List<FicheDeSoin> getAll(){
        List<FicheDeSoin> all=consultationRepository.findAll();
        return all;
    }

    public FicheDeSoin update(FicheDeSoin consultation){
        FicheDeSoin existing=consultationRepository.findById(consultation.getNumeroFiche()).get();
        existing.setAdresseCreateur(consultation.getAdresseCreateur());
        existing.setDateCreation(consultation.getDateCreation());
        existing.setAgentCreateur(consultation.getAgentCreateur());
        FicheDeSoin updated=consultationRepository.save(existing);
        return updated;
    }


    public void delete(Integer id){
        consultationRepository.deleteById(id);
    }
}
