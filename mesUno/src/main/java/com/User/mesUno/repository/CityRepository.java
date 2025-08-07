package com.User.mesUno.repository;

import com.User.mesUno.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
//    @Query("SELECT c FROM City c LEFT JOIN FETCH c.users")
    @Query("SELECT c FROM City c LEFT JOIN c.users")
    List<City> findAllWithUsers();


}
