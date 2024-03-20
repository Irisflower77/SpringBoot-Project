package com.example.exam.Controller;

import com.example.exam.Entity.DossierMedical;
import com.example.exam.Service.DossierMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dossiermedical")
public class DossierMedicalController {

    @Autowired
    private DossierMedicalService dossierMedicalService;


    @PostMapping
    public ResponseEntity<DossierMedical> create(@RequestBody DossierMedical dossierMedical){
        DossierMedical saved=dossierMedicalService.create(dossierMedical);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DossierMedical> getById(@PathVariable Integer id){
        DossierMedical fetched=dossierMedicalService.getById(id);
        return new ResponseEntity<>(fetched,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DossierMedical>> getAll(){
        List<DossierMedical> all=dossierMedicalService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DossierMedical> update(@RequestBody DossierMedical dossierMedical,@PathVariable Integer id){
        dossierMedical.setNumero(id);
        DossierMedical updated=dossierMedicalService.update(dossierMedical);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Integer id){
        dossierMedicalService.delete(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
