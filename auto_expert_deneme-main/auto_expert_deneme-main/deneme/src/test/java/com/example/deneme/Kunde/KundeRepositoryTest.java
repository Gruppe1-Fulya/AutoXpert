package com.example.deneme.Kunde;

import com.example.deneme.kunden.Kunde;
import com.example.deneme.kunden.KundeRepo;
import com.example.deneme.fahrzeug.Fahrzeug;
import com.example.deneme.fahrzeug.FahrzeugRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class KundeRepositoryTest {




    @Autowired
    private KundeRepo kundeRepo;

    @Autowired
    private FahrzeugRepo fahrzeugRepo;

    @Test
    public void testKundeCreation() {
        Fahrzeug fahrzeug = new Fahrzeug();
        fahrzeug.setKfz("ABC123");
        fahrzeug.setMarka("BMW");
        fahrzeugRepo.save(fahrzeug);

        Kunde kunde = new Kunde();
        kunde.setName("John");
        kunde.setNachname("Doe");
        kunde.setFahrzeug(fahrzeug);

        kundeRepo.save(kunde);

        assertNotNull(kunde.getId());

        Kunde savedKunde = kundeRepo.findById(kunde.getId()).orElse(null);
        assertNotNull(savedKunde);
        assertEquals("John", savedKunde.getName());
        assertEquals("Doe", savedKunde.getNachname());
        assertNotNull(savedKunde.getFahrzeug());
        assertEquals("ABC123", savedKunde.getFahrzeug().getKfz());
        assertEquals("BMW", savedKunde.getFahrzeug().getMarka());
    }
}
