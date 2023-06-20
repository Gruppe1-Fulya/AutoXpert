package com.example.deneme.Fahrzeug;

import com.example.deneme.fahrzeug.Fahrzeug;
import com.example.deneme.fahrzeug.FahrzeugRepo;
import com.example.deneme.fahrzeug.FahrzeugService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FahrzeugTest {

    private FahrzeugService fahrzeugService;

    @Mock
    private FahrzeugRepo fahrzeugRepo;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        fahrzeugService = new FahrzeugService(fahrzeugRepo);
    }

    @Test
    public void testGetFahrzeug() {
        Fahrzeug fahrzeug = new Fahrzeug(1, "ABC123");
        Iterable<Fahrzeug> fahrzeuge = List.of(fahrzeug);

        when(fahrzeugRepo.findAll()).thenReturn(fahrzeuge);

        Iterable<Fahrzeug> result = fahrzeugService.getFahrzeug();

        assertNotNull(result);
        assertEquals(fahrzeuge, result);
        verify(fahrzeugRepo, times(1)).findAll();
    }


    @Test
    public void testArabaEkle() {
        Fahrzeug fahrzeug = new Fahrzeug(1, "ABC123");

        fahrzeugService.arabaEkle(fahrzeug);

        assertEquals("Reparatur", fahrzeug.getZustand());
        verify(fahrzeugRepo, times(1)).save(fahrzeug);
    }

    @Test
    public void testFahrzeugById_ExistingId() {
        int fahrzeugId = 1;
        Fahrzeug fahrzeug = new Fahrzeug(fahrzeugId, "ABC123");

        when(fahrzeugRepo.findById(fahrzeugId)).thenReturn(Optional.of(fahrzeug));

        Optional<Fahrzeug> result = fahrzeugService.fahrzeugById(fahrzeugId);

        assertTrue(result.isPresent());
        assertEquals(fahrzeugId, result.get().getId());
        assertEquals("ABC123", result.get().getKfz());
        verify(fahrzeugRepo, times(1)).findById(fahrzeugId);
    }

    @Test
    public void testFahrzeugById_NonExistingId() {
        int fahrzeugId = 1;

        when(fahrzeugRepo.findById(fahrzeugId)).thenReturn(Optional.empty());

        Optional<Fahrzeug> result = fahrzeugService.fahrzeugById(fahrzeugId);

        assertFalse(result.isPresent());
        verify(fahrzeugRepo, times(1)).findById(fahrzeugId);
    }

    @Test /////+++++
    public void testFahrzeugByKfz_ExistingKfz() {
        String kfz = "ABC123";
        Fahrzeug fahrzeug = new Fahrzeug(1, kfz);

        when(fahrzeugRepo.findFahrzeugByKfz(kfz)).thenReturn(Optional.of(fahrzeug));

        Optional<Fahrzeug> result = fahrzeugService.fahrzeugByKfz(kfz);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertEquals(kfz, result.get().getKfz());
        verify(fahrzeugRepo, times(1)).findFahrzeugByKfz(kfz);
    }

    @Test /////+++++
    public void testFahrzeugByKfz_NonExistingKfz() {
        String kfz = "ABC123";

        when(fahrzeugRepo.findFahrzeugByKfz(kfz)).thenReturn(Optional.empty());

        Optional<Fahrzeug> result = fahrzeugService.fahrzeugByKfz(kfz);

        assertFalse(result.isPresent());
        verify(fahrzeugRepo, times(1)).findFahrzeugByKfz(kfz);
    }

    @Test /////++++++
    public void testZustandsInfoAktualisieren_ExistingKfz() {
        String kfz = "ABC123";
        String zustand = "Reparatur";
        Fahrzeug fahrzeug = new Fahrzeug(1, kfz);

        when(fahrzeugRepo.findFahrzeugByKfz(kfz)).thenReturn(Optional.of(fahrzeug));

        String result = fahrzeugService.zustandsInfoAktualisieren(zustand, kfz);

        assertEquals("Zustand ist erfolgreich aktualisiert.", result);
        assertEquals(zustand, fahrzeug.getZustand());
        verify(fahrzeugRepo, times(1)).findFahrzeugByKfz(kfz);
        verify(fahrzeugRepo, times(1)).save(fahrzeug);
    }

    @Test ///////++++++
    public void testZustandsInfoAktualisieren_NonExistingKfz() {
        String kfz = "ABC123";
        String zustand = "Reparatur";

        when(fahrzeugRepo.findFahrzeugByKfz(kfz)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            fahrzeugService.zustandsInfoAktualisieren(zustand, kfz);
        });

        verify(fahrzeugRepo, times(1)).findFahrzeugByKfz(kfz);
        verify(fahrzeugRepo, never()).save(any(Fahrzeug.class));
    }

    @Test //////++++++
    public void testFahrzeugAktu() {
        // Test verilerini hazırla
        String kfz = "34ABC123";
        String zustand = "fertig";
        String reparaturen = "Bir takım tamirler";
        String kosten = "1000 TL";

        Fahrzeug existingFahrzeug = new Fahrzeug();
        existingFahrzeug.setId(1);
        existingFahrzeug.setKfz(kfz);
        existingFahrzeug.setZustand("fertig");
        existingFahrzeug.setReparaturen("Bir takım tamirler");
        existingFahrzeug.setKosten("1000 TL");

        Fahrzeug updatedFahrzeug = new Fahrzeug();
        updatedFahrzeug.setId(1);
        updatedFahrzeug.setKfz(kfz);
        updatedFahrzeug.setZustand(zustand);
        updatedFahrzeug.setReparaturen(reparaturen);
        updatedFahrzeug.setKosten(kosten);

        // Mock Repository yanıtlarını ayarla
        when(fahrzeugRepo.findFahrzeugByKfz(kfz)).thenReturn(Optional.of(existingFahrzeug));
        when(fahrzeugRepo.save(any(Fahrzeug.class))).thenReturn(updatedFahrzeug);

        // Metodu çağır
        String result = fahrzeugService.fahrzeugAktu(existingFahrzeug, kfz);

        // Sonucu doğrula
        assertEquals("Fahrzeug ist erfolgreich aktualisiert.", result);
        assertEquals(zustand, existingFahrzeug.getZustand());
        assertEquals(reparaturen, existingFahrzeug.getReparaturen());
        assertEquals(kosten, existingFahrzeug.getKosten());

        // Repository metotlarının doğru şekilde çağrıldığını doğrula
        verify(fahrzeugRepo, times(1)).findFahrzeugByKfz(kfz);
        verify(fahrzeugRepo, times(1)).save(existingFahrzeug);
    }
}

