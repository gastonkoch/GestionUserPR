package com.creacionrelacionprueba.creacionrelacionprueba.service;

import com.creacionrelacionprueba.creacionrelacionprueba.service.dto.ProfessorDTO;
import java.util.List;

public interface IProfessorService {
    public List<ProfessorDTO> getProfessors();
    public ProfessorDTO getProfessorById(Long professorId);
    public void saveProfessor(ProfessorDTO professor);
    public void deleteProfessor(Long professorId);
    public void updateProfessor(ProfessorDTO professor);
}
