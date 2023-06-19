package com.example.deneme.kunden;

import com.example.deneme.fahrzeug.Fahrzeug;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KundeRepo extends CrudRepository<Kunde, Integer> {
    @Query("SELECT e FROM Kunde e")
    Iterable<Kunde> getAllKunde();
}
