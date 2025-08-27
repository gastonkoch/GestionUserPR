package com.creacionrelacionprueba.creacionrelacionprueba.service;

import com.creacionrelacionprueba.creacionrelacionprueba.service.dto.DepartmentDTO;
import com.creacionrelacionprueba.creacionrelacionprueba.service.dto.ProfessorDTO;
import java.util.List;

public interface IDepartmentService {
    public List<DepartmentDTO> getDepartments();
    public DepartmentDTO getDepartmentById(Long departmentId);
    public void saveDepartment(DepartmentDTO department);
    public void deleteDepartment(Long departmentId);
    public void updateDepartment(DepartmentDTO department);
}
