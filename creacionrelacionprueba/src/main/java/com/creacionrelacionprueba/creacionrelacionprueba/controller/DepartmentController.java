package com.creacionrelacionprueba.creacionrelacionprueba.controller;

import com.creacionrelacionprueba.creacionrelacionprueba.service.DepartmentService;
import com.creacionrelacionprueba.creacionrelacionprueba.service.dto.DepartmentDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping("/getDepartments")
    private ResponseEntity<List<DepartmentDTO>> getDepartments(){
        return ResponseEntity.ok(departmentService.getDepartments());
    }
    
    @GetMapping("/getDepartmentById/{departmentId}")
    private ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
    }
    
    @PostMapping("/saveDepartment")
    private ResponseEntity<Void> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        departmentService.saveDepartment(departmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @DeleteMapping("/deleteDepartment/{departmentId}")
    private ResponseEntity<Void> deleteDepartment(@PathVariable Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    @PutMapping("/updateDepartment")
    private ResponseEntity<Void> updateDepartment(@RequestBody DepartmentDTO departmentDTO){
        departmentService.updateDepartment(departmentDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
}
