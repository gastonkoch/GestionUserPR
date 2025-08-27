package com.creacionrelacionprueba.creacionrelacionprueba.service.dto;

import com.creacionrelacionprueba.creacionrelacionprueba.domain.Department;
import com.creacionrelacionprueba.creacionrelacionprueba.domain.Office;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorDTO {
    private Long professorId;
    private String professorName;
    private Department department;
    private Office office;    
    
    
}
