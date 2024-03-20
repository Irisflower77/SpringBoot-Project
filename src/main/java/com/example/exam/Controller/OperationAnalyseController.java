package com.example.exam.Controller;

import com.example.exam.Entity.Consultation;
import com.example.exam.Entity.OperationAnalyse;
import com.example.exam.Service.ConsultationService;
import com.example.exam.Service.OperationAnalyseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operationAnalyse")
public class OperationAnalyseController {

    @Autowired
    private OperationAnalyseService consultationService;


    @PostMapping
    public ResponseEntity<OperationAnalyse> create(@RequestBody OperationAnalyse consultation){
        OperationAnalyse saved=consultationService.create(consultation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationAnalyse> getById(@PathVariable Long id){
        OperationAnalyse fetched=consultationService.getById(id);
        return new ResponseEntity<>(fetched,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OperationAnalyse>> getAll(){
        List<OperationAnalyse> all=consultationService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperationAnalyse> update(@RequestBody OperationAnalyse consultation,@PathVariable Long id){
        consultation.setId(id);
        OperationAnalyse updated=consultationService.update(consultation);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Long id){
        consultationService.delete(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
