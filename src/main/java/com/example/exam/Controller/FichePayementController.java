package com.example.exam.Controller;


import com.example.exam.Entity.FichePayement;

import com.example.exam.Service.FichePayementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichePayement")
public class FichePayementController {
    @Autowired
    private FichePayementService consultationService;


    @PostMapping
    public ResponseEntity<FichePayement> create(@RequestBody FichePayement consultation){
        FichePayement saved=consultationService.create(consultation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichePayement> getById(@PathVariable Integer id){
        FichePayement fetched=consultationService.getById(id);
        return new ResponseEntity<>(fetched,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FichePayement>> getAll(){
        List<FichePayement> all=consultationService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichePayement> update(@RequestBody FichePayement consultation,@PathVariable Integer id){
        consultation.setNumeroFiche(id);
        FichePayement updated=consultationService.update(consultation);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Integer id){
        consultationService.delete(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
