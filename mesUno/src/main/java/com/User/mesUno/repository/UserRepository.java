package com.User.mesUno.repository;

import com.User.mesUno.domain.City;
import com.User.mesUno.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // Buscar por objeto City
    List<User> findByCity(City city);

    // O buscar por ID de la ciudad
    List<User> findByCity_CityId(Long cityId);


}
