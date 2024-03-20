package com.example.exam.Controller;

import com.example.exam.Entity.FicheConsultation;
import com.example.exam.Service.FicheConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ficheConsultation")
public class FicheConsultationController {
    @Autowired
    private FicheConsultationService ficheConsultationService;


    @PostMapping
    public ResponseEntity<FicheConsultation> create(@RequestBody FicheConsultation consultation){
        FicheConsultation saved=ficheConsultationService.create(consultation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FicheConsultation> getById(@PathVariable Integer id){
        FicheConsultation fetched=ficheConsultationService.getById(id);
        return new ResponseEntity<>(fetched,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FicheConsultation>> getAll(){
        List<FicheConsultation> all=ficheConsultationService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FicheConsultation> update(@RequestBody FicheConsultation ficheConsultation,@PathVariable Integer id){
        ficheConsultation.setNumeroFiche(id);
        FicheConsultation updated=ficheConsultationService.update(ficheConsultation);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Integer id){
        ficheConsultationService.delete(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
