package com.creacionrelacionprueba.creacionrelacionprueba.service;

import com.creacionrelacionprueba.creacionrelacionprueba.domain.Department;
import com.creacionrelacionprueba.creacionrelacionprueba.repository.DepartmentRepository;
import com.creacionrelacionprueba.creacionrelacionprueba.service.dto.DepartmentDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DepartmentService implements IDepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDTO> getDepartments() {
        return departmentRepository.findAll().stream()
                .map(department -> DepartmentDTO.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .build()
                ).toList();
    }

    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) {        
        return departmentRepository.findById(departmentId)
                .map(department -> DepartmentDTO.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .build()
                ).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, 
                        "Department with id " + departmentId + " not found"
                ));
    }

    @Override
    public void saveDepartment(DepartmentDTO department) {
        departmentRepository.save(Department.builder()
                                .departmentName(department.getDepartmentName())
                                .build());
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public void updateDepartment(DepartmentDTO department) {
        departmentRepository.findById(department.getDepartmentId())
                .map(existing -> departmentRepository.save(
                        Department.builder()
                                .departmentId(department.getDepartmentId())
                                .departmentName(department.getDepartmentName())
                                .build()
                ))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Department with id " + department.getDepartmentId() + " not found"
                ));
    }
    
    
    
}
