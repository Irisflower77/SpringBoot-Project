package com.example.exam.Controller;

import com.example.exam.Entity.Consultation;
import com.example.exam.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;


    @PostMapping
    public ResponseEntity<Consultation> create(@RequestBody Consultation consultation){
        Consultation saved=consultationService.create(consultation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultation> getById(@PathVariable Long id){
        Consultation fetched=consultationService.getById(id);
        return new ResponseEntity<>(fetched,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Consultation>> getAll(){
        List<Consultation> all=consultationService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultation> update(@RequestBody Consultation consultation,@PathVariable Long id){
        consultation.setId(id);
        Consultation updated=consultationService.update(consultation);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Long id){
        consultationService.delete(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
