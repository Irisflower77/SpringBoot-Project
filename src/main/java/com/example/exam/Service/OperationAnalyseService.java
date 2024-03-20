package com.example.exam.Service;

import com.example.exam.Entity.Consultation;
import com.example.exam.Entity.OperationAnalyse;
import com.example.exam.Repository.ConsultationRepository;
import com.example.exam.Repository.OperationAnalyseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class OperationAnalyseService {
    @Autowired
    private OperationAnalyseRepository consultationRepository;

    public OperationAnalyse create(OperationAnalyse consultation){
        OperationAnalyse saved=consultationRepository.save(consultation);
        return saved ;
    }

    public OperationAnalyse getById(Long id){
        Optional<OperationAnalyse> fetched=consultationRepository.findById(id);
        return fetched.get();
    }

    public List<OperationAnalyse> getAll(){
        List<OperationAnalyse> all=consultationRepository.findAll();
        return all;
    }

    public OperationAnalyse update(OperationAnalyse consultation){
        OperationAnalyse existing=consultationRepository.findById(consultation.getId()).get();
       existing.setDescription(consultation.getDescription());
       existing.setResultat(consultation.getResultat());
       existing.setDateHeureOperation(consultation.getDateHeureOperation());
        OperationAnalyse updated=consultationRepository.save(existing);
        return updated;
    }


    public void delete(Long id){
        consultationRepository.deleteById(id);
    }
}
