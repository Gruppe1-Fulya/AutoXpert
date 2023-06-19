package com.example.deneme.fahrzeug;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FahrzeugRepo extends CrudRepository<Fahrzeug, Integer> {
    @Query("select f from Fahrzeug f where f.kfz = ?1")
    Optional<Fahrzeug> findFahrzeugByKfz(String kfz);
}
