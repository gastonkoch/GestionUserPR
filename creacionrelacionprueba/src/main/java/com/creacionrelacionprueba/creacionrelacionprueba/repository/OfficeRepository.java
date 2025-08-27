package com.creacionrelacionprueba.creacionrelacionprueba.repository;

import com.creacionrelacionprueba.creacionrelacionprueba.domain.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long>{
    
}
