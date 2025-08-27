package com.creacionrelacionprueba.creacionrelacionprueba.service;

import com.creacionrelacionprueba.creacionrelacionprueba.domain.Department;
import com.creacionrelacionprueba.creacionrelacionprueba.domain.Office;
import com.creacionrelacionprueba.creacionrelacionprueba.domain.Professor;
import com.creacionrelacionprueba.creacionrelacionprueba.repository.DepartmentRepository;
import com.creacionrelacionprueba.creacionrelacionprueba.repository.OfficeRepository;
import com.creacionrelacionprueba.creacionrelacionprueba.repository.ProfessorRepository;
import com.creacionrelacionprueba.creacionrelacionprueba.service.dto.ProfessorDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProfessorService implements IProfessorService{
    @Autowired
    private ProfessorRepository professorRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public List<ProfessorDTO> getProfessors() {
        return professorRepository.findAll().stream()
                .map(professor -> ProfessorDTO.builder()
                        .professorId(professor.getProfessorId())
                        .professorName(professor.getProfessorName())
                        .department(professor.getDepartment())
                        .office(professor.getOffice())
                        .build()
                ).toList();
               
    }

    @Override
    public ProfessorDTO getProfessorById(Long professorId) {
        return professorRepository.findById(professorId)
                .map(professor -> ProfessorDTO.builder()
                        .professorId(professor.getProfessorId())
                        .professorName(professor.getProfessorName())
                        .department(professor.getDepartment())
                        .office(professor.getOffice())
                        .build())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor with id " + professorId + " not found"));
    }


    @Override
    public void saveProfessor(ProfessorDTO professor) {
        System.out.print("service");
//        System.out.print("professor " + professor);System.out.print("controller");
        
//        Department department = departmentRepository.findById(professor.getDepartment().getDepartmentId())
//                .orElseThrow(() -> new ResponseStatusException(
//                        HttpStatus.NOT_FOUND, 
//                        "Department with id " + professor.getDepartment().getDepartmentId() + " not found"
//                ));
//        
//        Office office = officeRepository.findById(professor.getOffice().getOfficeId())
//                .orElseThrow(() -> new ResponseStatusException(
//                        HttpStatus.NOT_FOUND, 
//                        "Office with id " + professor.getOffice().getOfficeId() + " not found"
//                ));
//        
//        
//        professorRepository.save(Professor.builder()
//                                .professorId(professor.getProfessorId())
//                                .professorName(professor.getProfessorName())
//                                .department(department)
//                                .office(office)
//                                .build());
    }

    @Override
    public void deleteProfessor(Long professorId) {
        professorRepository.deleteById(professorId);
    }

    @Override
    public void updateProfessor(ProfessorDTO professor) {
        professorRepository.findById(professor.getProfessorId())
            .map(existing -> professorRepository.save(
                    Professor.builder()
                            .professorId(professor.getProfessorId())
                            .professorName(professor.getProfessorName())
                            .department(professor.getDepartment())
                            .office(professor.getOffice())
                            .build()
            ))
            .orElseThrow(() -> new HttpClientErrorException(
                    HttpStatus.NOT_FOUND, "Professor not found"));
    }
}
