package com.example.exam.Controller;

import com.example.exam.Entity.Consultation;
import com.example.exam.Entity.Patient;
import com.example.exam.Service.ConsultationService;
import com.example.exam.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService consultationService;


    @PostMapping
    public ResponseEntity<Patient> create(@RequestBody Patient consultation){
        Patient saved=consultationService.create(consultation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Long id){
        Patient fetched=consultationService.getById(id);
        return new ResponseEntity<>(fetched,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAll(){
        List<Patient> all=consultationService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@RequestBody Patient consultation,@PathVariable Long id){
        consultation.setId(id);
        Patient updated=consultationService.update(consultation);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Long id){
        consultationService.delete(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
