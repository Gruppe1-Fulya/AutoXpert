package com.example.deneme.Fahrzeug;

import com.example.deneme.fahrzeug.Fahrzeug;
import com.example.deneme.fahrzeug.FahrzeugRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class FahrzeugRepositoryTest {

    @Autowired
    private FahrzeugRepo fahrzeugRepo;

    @Test
    public void testFahrzeugCreation() {
        Fahrzeug fahrzeug = new Fahrzeug();
        fahrzeug.setKfz("ABC123");
        fahrzeug.setMarka("BMW");

        fahrzeugRepo.save(fahrzeug);

        assertNotNull(fahrzeug.getId());

        Fahrzeug savedFahrzeug = fahrzeugRepo.findById(fahrzeug.getId()).orElse(null);
        assertNotNull(savedFahrzeug);
        assertEquals("ABC123", savedFahrzeug.getKfz());
        assertEquals("BMW", savedFahrzeug.getMarka());
    }
}
