package com.example.exam.Controller;

import com.example.exam.Entity.FicheDeSoin;
import com.example.exam.Service.FicheDeSoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ficheDeSoin")
public class FicheDeSoinController {
    @Autowired
    private FicheDeSoinService consultationService;


    @PostMapping
    public ResponseEntity<FicheDeSoin> create(@RequestBody FicheDeSoin consultation){
        FicheDeSoin saved=consultationService.create(consultation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FicheDeSoin> getById(@PathVariable Integer id){
        FicheDeSoin fetched=consultationService.getById(id);
        return new ResponseEntity<>(fetched,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FicheDeSoin>> getAll(){
        List<FicheDeSoin> all=consultationService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FicheDeSoin> update(@RequestBody FicheDeSoin consultation,@PathVariable Integer id){
        consultation.setNumeroFiche(id);
        FicheDeSoin updated=consultationService.update(consultation);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Integer id){
        consultationService.delete(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
