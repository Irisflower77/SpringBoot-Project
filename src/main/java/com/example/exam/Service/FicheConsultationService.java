package com.example.exam.Service;

import com.example.exam.Entity.FicheConsultation;
import com.example.exam.Repository.FicheConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FicheConsultationService {
    @Autowired
    private FicheConsultationRepository ficheConsultationRepository;

    public FicheConsultation create(FicheConsultation ficheConsultation){
        FicheConsultation saved=ficheConsultationRepository.save(ficheConsultation);
        return saved ;
    }

    public FicheConsultation getById(Integer id){
        Optional<FicheConsultation> fetched=ficheConsultationRepository.findById(id);
        return fetched.get();
    }

    public List<FicheConsultation> getAll(){
        List<FicheConsultation> all=ficheConsultationRepository.findAll();
        return all;
    }

    public FicheConsultation update(FicheConsultation ficheConsultation){
        FicheConsultation existing=ficheConsultationRepository.findById(ficheConsultation.getNumeroFiche()).get();
        existing.setCompteRendu(ficheConsultation.getCompteRendu());
        existing.setAgentCreateur(ficheConsultation.getAgentCreateur());
        existing.setAdresseCreateur(ficheConsultation.getAdresseCreateur());
        existing.setDateCreation(ficheConsultation.getDateCreation());
        FicheConsultation updated=ficheConsultationRepository.save(existing);
        return updated;
    }


    public void delete(Integer id){
        ficheConsultationRepository.deleteById(id);
    }
}
