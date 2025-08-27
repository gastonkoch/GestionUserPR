package com.creacionrelacionprueba.creacionrelacionprueba.controller;

import com.creacionrelacionprueba.creacionrelacionprueba.service.IProfessorService;
import com.creacionrelacionprueba.creacionrelacionprueba.service.dto.ProfessorDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/professor")
public class ProfessorController {
    
    @Autowired
    private IProfessorService professorService;
    
    @GetMapping("/getProfessors")
    public ResponseEntity<List<ProfessorDTO>> getProfessors(){
        return ResponseEntity.ok(professorService.getProfessors());
    }
    
    @GetMapping("/getProfessorById/{professorId}")
    public ResponseEntity<ProfessorDTO> getProfessorById(@PathVariable Long professorId){
        return ResponseEntity.ok(professorService.getProfessorById(professorId));
    } 
    
    @PostMapping("/saveProfessor")
    public ResponseEntity<Void> saveProfessor(@RequestBody ProfessorDTO professor){
        System.out.print("controller");
//        professorService.saveProfessor(professor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping("/updateProfessor")
    public ResponseEntity<Void> updateProfessor(@RequestBody ProfessorDTO professor){
        professorService.updateProfessor(professor);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    
    @DeleteMapping("/deleteProfessor")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long professorId){
        professorService.deleteProfessor(professorId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
