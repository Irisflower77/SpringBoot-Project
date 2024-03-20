package com.example.exam.Service;

import com.example.exam.Entity.FicheDeSoin;
import com.example.exam.Entity.FichePayement;
import com.example.exam.Repository.FichePayementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichePayementService {
    @Autowired
    private FichePayementRepository consultationRepository;

    public FichePayement create(FichePayement consultation){
        FichePayement saved=consultationRepository.save(consultation);
        return saved ;
    }

    public FichePayement getById(Integer id){
        Optional<FichePayement> fetched=consultationRepository.findById(id);
        return fetched.get();
    }

    public List<FichePayement> getAll(){
        List<FichePayement> all=consultationRepository.findAll();
        return all;
    }


    public FichePayement update(FichePayement consultation){
        FichePayement existing=consultationRepository.findById(consultation.getNumeroFiche()).get();
        existing.setAdresseCreateur(consultation.getAdresseCreateur());
        existing.setDateCreation(consultation.getDateCreation());
        existing.setAgentCreateur(consultation.getAgentCreateur());
        existing.setDateExigibilite(consultation.getDateExigibilite());
        existing.setDatePayement(consultation.getDatePayement());
        existing.setMontantPaye(consultation.getMontantPaye());
        existing.setIndicateurPayement(consultation.isIndicateurPayement());
        FichePayement updated=consultationRepository.save(existing);
        return updated;
    }

    public void delete(Integer id){
        consultationRepository.deleteById(id);
    }
}
