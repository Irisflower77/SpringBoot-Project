package com.example.exam.Controller;

import com.example.exam.Entity.Consultation;
import com.example.exam.Entity.Prescription;
import com.example.exam.Service.ConsultationService;
import com.example.exam.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService consultationService;


    @PostMapping
    public ResponseEntity<Prescription> create(@RequestBody Prescription consultation){
        Prescription saved=consultationService.create(consultation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getById(@PathVariable Long id){
        Prescription fetched=consultationService.getById(id);
        return new ResponseEntity<>(fetched,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Prescription>> getAll(){
        List<Prescription> all=consultationService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescription> update(@RequestBody Prescription consultation,@PathVariable Long id){
        consultation.setId(id);
        Prescription updated=consultationService.update(consultation);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Long id){
        consultationService.delete(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
