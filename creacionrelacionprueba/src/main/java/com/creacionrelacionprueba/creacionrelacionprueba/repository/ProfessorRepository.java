package com.creacionrelacionprueba.creacionrelacionprueba.repository;

import com.creacionrelacionprueba.creacionrelacionprueba.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}

