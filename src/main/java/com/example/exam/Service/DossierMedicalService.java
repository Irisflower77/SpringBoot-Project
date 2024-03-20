package com.example.exam.Service;

import com.example.exam.Entity.DossierMedical;
import com.example.exam.Repository.DossierMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DossierMedicalService {

    @Autowired
    private DossierMedicalRepository dossierMedicalRepository;

    public DossierMedical create(DossierMedical dossierMedical){
        DossierMedical saved=dossierMedicalRepository.save(dossierMedical);
        return saved ;
    }

    public DossierMedical getById(Integer id){
        Optional<DossierMedical> fetched=dossierMedicalRepository.findById(id);
        return fetched.get();
    }

    public List<DossierMedical> getAll(){
        List<DossierMedical> all=dossierMedicalRepository.findAll();
        return all;
    }

    public DossierMedical update(DossierMedical dossierMedical){
        DossierMedical existing=dossierMedicalRepository.findById(dossierMedical.getNumero()).get();
       existing.setDate(dossierMedical.getDate());
       existing.setCodeAccessPatient(dossierMedical.getCodeAccessPatient());
        DossierMedical updated=dossierMedicalRepository.save(existing);
        return updated;
    }


    public void delete(Integer id){
        dossierMedicalRepository.deleteById(id);
    }
}
