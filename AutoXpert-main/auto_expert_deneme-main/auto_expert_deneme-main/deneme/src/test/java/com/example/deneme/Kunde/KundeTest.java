package com.example.deneme.Kunde;

import com.example.deneme.fahrzeug.Fahrzeug;
import com.example.deneme.fahrzeug.FahrzeugRepo;
import com.example.deneme.kunden.Kunde;
import com.example.deneme.kunden.KundeRepo;
import com.example.deneme.kunden.KundeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class KundeTest {

    private KundeService kundeService;

    @Mock
    private KundeRepo kundeRepo;

    @Mock
    private FahrzeugRepo fahrzeugRepo;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        kundeService = new KundeService(kundeRepo, fahrzeugRepo);
    }

    @Test
    public void testGetKundeList() {
        Kunde kunde = new Kunde();
        Iterable<Kunde> kunden = List.of(kunde);

        when(kundeRepo.getAllKunde()).thenReturn(kunden);

        Iterable<Kunde> result = kundeService.getkundelist();

        assertNotNull(result);
        assertEquals(kunden, result);
        verify(kundeRepo, times(1)).getAllKunde();
    }

    @Test
    public void testKundeEkle() {
        Kunde kunde = new Kunde();
        Fahrzeug fahrzeug = new Fahrzeug();
        kunde.setFahrzeug(fahrzeug);

        when(fahrzeugRepo.save(fahrzeug)).thenReturn(fahrzeug);
        when(kundeRepo.save(kunde)).thenReturn(kunde);

        kundeService.kundeekle(kunde);

        assertEquals("Reparatur", fahrzeug.getZustand());
        assertEquals(kunde, fahrzeug.getKunde());
        verify(fahrzeugRepo, times(1)).save(fahrzeug);
        verify(kundeRepo, times(1)).save(kunde);
    }
}

